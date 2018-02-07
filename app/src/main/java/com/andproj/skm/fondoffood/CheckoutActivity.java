package com.andproj.skm.fondoffood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.andproj.skm.fondoffood.model.CheckoutItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckoutActivity extends AppCompatActivity {

    ListView listView;
    EditText total_quantity,total_price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setTitle("Checkout:");

        listView=findViewById(R.id.listview);
        Toast.makeText(getBaseContext(),"on create from Checkoutactivity",Toast.LENGTH_SHORT).show();
        Set<CheckoutItem> checkoutItem_set=new HashSet<>(MainTabActivity.checkout_item_list);
        MainTabActivity.checkout_item_list=null;
        MainTabActivity.checkout_item_list=new ArrayList<>(checkoutItem_set);
        CustomCheckoutListAdaptor customCheckoutListAdaptor=new CustomCheckoutListAdaptor(this,MainTabActivity.checkout_item_list);

        listView.setAdapter(customCheckoutListAdaptor);

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });  */

       total_quantity=findViewById(R.id.total_quantity);
       total_price=findViewById(R.id.total_price);




        StringBuffer s=new StringBuffer();
        for(CheckoutItem item: MainTabActivity.checkout_item_list)
        {
            s.append(item.getItem().getItem_name()+" : "+item.getQuantity()+"\n");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


    }



    public void totalCalculator()
    {

    }
}
