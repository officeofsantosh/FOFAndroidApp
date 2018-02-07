package com.andproj.skm.fondoffood;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.andproj.skm.fondoffood.model.CheckoutItem;

import java.util.ArrayList;

/**
 * Created by skumarmanda on 2/6/2018.
 */

public class CustomCheckoutListAdaptor extends ArrayAdapter<CheckoutItem> {

    Context context;
    ArrayList<CheckoutItem> checkoutItem_data;

    public CustomCheckoutListAdaptor(@NonNull Context context, ArrayList<CheckoutItem> checkoutItem_data) {
        super(context, R.layout.checkout_row_item,checkoutItem_data);
        this.context = context;
        this.checkoutItem_data = checkoutItem_data;
    }


    public class ViewHolder{
        ImageView item_image;
        TextView item_name,item_price;
        EditText item_total;
        Spinner qty_spinner;
        ArrayAdapter<CharSequence> spinner_adapter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final CheckoutItem checkoutItem=checkoutItem_data.get(position);

        ViewHolder viewHolder=null;

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.checkout_row_item,null);

            viewHolder=new ViewHolder();

            viewHolder.item_name=convertView.findViewById(R.id.item_name);
            viewHolder.item_price=convertView.findViewById(R.id.item_price);
            viewHolder.item_image=convertView.findViewById(R.id.item_image);
            //viewHolder.item_quantity=convertView.findViewById(R.id.item_qty);
            viewHolder.item_total=convertView.findViewById(R.id.item_total);
            viewHolder.qty_spinner=convertView.findViewById(R.id.qty_spinner);

            viewHolder.spinner_adapter=ArrayAdapter.createFromResource(this.getContext(),R.array.quantity_options,android.R.layout.simple_spinner_item);
            viewHolder.spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            viewHolder.qty_spinner.setAdapter(viewHolder.spinner_adapter);

            convertView.setTag(viewHolder);
        }
        else {

            viewHolder=(ViewHolder) convertView.getTag();
        }

        viewHolder.item_name.setText(checkoutItem.getItem().getItem_name());
        viewHolder.item_price.setText("     Rs. "+checkoutItem.getItem().getItem_price()+"/- ");
        viewHolder.item_image.setImageResource(checkoutItem.getItem().getItem_image_id());
        //viewHolder.item_quantity.setText(checkoutItem.getQuantity()+"");
        viewHolder.item_total.setText((Integer.parseInt(checkoutItem.getItem().getItem_price())*(Integer.parseInt(viewHolder.qty_spinner.getSelectedItem().toString()))+".00"));
        final ViewHolder viewHolder_final=viewHolder;
        viewHolder.qty_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int qty=Integer.parseInt(viewHolder_final.qty_spinner.getSelectedItem().toString());
                int price=Integer.parseInt(checkoutItem.getItem().getItem_price());
                viewHolder_final.item_total.setText((qty*price)+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        return convertView;

    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}
