package com.andproj.skm.fondoffood;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andproj.skm.fondoffood.model.ItemModel;

import java.util.ArrayList;

/**
 * Created by skumarmanda on 2/4/2018.
 */

public class CustomListAdapter extends ArrayAdapter<ItemModel> {

    Context context;
    ArrayList<ItemModel> itemModelData;


    public CustomListAdapter(@NonNull Context context, ArrayList<ItemModel> itemModelData) {
        super(context, R.layout.row_item, itemModelData);

        this.context=context;
        this.itemModelData=itemModelData;
    }

    private class ViewHolder{
        TextView item_name,item_price,item_desc;
        ImageView item_image;
    }

    @Override
    public int getCount() {
        return itemModelData.size();
    }

    @Nullable
    @Override
    public ItemModel getItem(int position) {
        return itemModelData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itemModelData.indexOf(getItem(position));
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //load the model item..
        ItemModel mitem=itemModelData.get(position);

        ViewHolder viewHolder=null;

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.row_item,null);

            viewHolder=new ViewHolder();

            //load the views to ViewHolder..
            viewHolder.item_name=(TextView)convertView.findViewById(R.id.item_name);
            viewHolder.item_price=(TextView)convertView.findViewById(R.id.item_price);
            viewHolder.item_desc=(TextView)convertView.findViewById(R.id.item_desc);
            viewHolder.item_image=(ImageView)convertView.findViewById(R.id.item_image);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        //set the model item data to ViewHolder..
        viewHolder.item_name.setText(mitem.getItem_name());
        viewHolder.item_price.setText(" RS. "+mitem.getItem_price()+"/-");
        viewHolder.item_desc.setText(mitem.getItem_Desc());
        viewHolder.item_image.setImageResource(mitem.getItem_image_id());

        return convertView;
    }
}
