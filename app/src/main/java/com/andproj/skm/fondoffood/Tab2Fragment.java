package com.andproj.skm.fondoffood;

import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.andproj.skm.fondoffood.model.CheckoutItem;
import com.andproj.skm.fondoffood.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skumarmanda on 2/4/2018.
 */

public class Tab2Fragment extends Fragment implements AdapterView.OnItemClickListener{

    private static final String TAG="Tab2Fragment";


    String[] tab2_item_names;
    String[] tab2_item_prices;
    String[] tab2_item_descs;
    TypedArray tab2_item_images;

    static ArrayList<ItemModel> tab2_row_items;
    static ListView tab2ListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab2_fragment,container,false);

        tab2ListView=view.findViewById(R.id.tab2ListView);

        tab2_row_items=new ArrayList<ItemModel>();
        tab2_item_names=getResources().getStringArray(R.array.tab2_item_names);
        tab2_item_prices=getResources().getStringArray(R.array.tab2_item_prices);
        tab2_item_descs=getResources().getStringArray(R.array.tab2_item_descriptions);
        tab2_item_images=getResources().obtainTypedArray(R.array.tab2_item_images);

        for(int i=0;i<tab2_item_names.length;i++)
        {
            ItemModel item=new ItemModel(tab2_item_names[i],tab2_item_prices[i],tab2_item_descs[i],tab2_item_images.getResourceId(i,-1));
            tab2_row_items.add(item);
        }

        CustomListAdapter customListAdapter=new CustomListAdapter(this.getContext(),tab2_row_items);


        tab2ListView.setAdapter(customListAdapter);
        tab2ListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(view.getContext(), "You have selected item no."
                +(i+1)+" from Juice", Toast.LENGTH_SHORT).show();
        CheckBox ckbox=view.findViewById(R.id.item_checked);
        ckbox.performClick();
    }

    public static void add_tab2_checkout_items()
    {
        List<CheckoutItem> tab1_list=new ArrayList<>();
        CheckBox cb=null;

        if(tab2ListView!=null) {
            for (int i = 0; i < tab2ListView.getChildCount(); i++) {
                cb = tab2ListView.getChildAt(i).findViewById(R.id.item_checked);
                if (cb.isChecked())
                    MainTabActivity.checkout_item_list.add(new CheckoutItem(tab2_row_items.get(i)));
            }
        }
    }
}
