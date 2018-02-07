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

public class Tab3Fragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String TAG="Tab1Fragment";


    String[] tab3_item_names;
    String[] tab3_item_prices;
    String[] tab3_item_descs;
    TypedArray tab3_item_images;

    static ArrayList<ItemModel> tab3_row_items;
    static ListView tab3ListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab3_fragment,container,false);

        tab3ListView=view.findViewById(R.id.tab3ListView);

        tab3_row_items=new ArrayList<ItemModel>();
        tab3_item_names=getResources().getStringArray(R.array.tab3_item_names);
        tab3_item_prices=getResources().getStringArray(R.array.tab3_item_prices);
        tab3_item_descs=getResources().getStringArray(R.array.tab3_item_descriptions);
        tab3_item_images=getResources().obtainTypedArray(R.array.tab3_item_images);

        for(int i=0;i<tab3_item_names.length;i++)
        {
            ItemModel item=new ItemModel(tab3_item_names[i],tab3_item_prices[i],tab3_item_descs[i],tab3_item_images.getResourceId(i,-1));
            tab3_row_items.add(item);
        }

        CustomListAdapter customListAdapter=new CustomListAdapter(this.getContext(),tab3_row_items);


        tab3ListView.setAdapter(customListAdapter);

        tab3ListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(view.getContext(), "You have selected item no."
                +(i+1)+" from Others", Toast.LENGTH_SHORT).show();
        CheckBox ckbox=view.findViewById(R.id.item_checked);
        ckbox.performClick();
    }

    public static void add_tab3_checkout_items()
    {
        List<CheckoutItem> tab1_list=new ArrayList<>();
        CheckBox cb=null;

        if(tab3ListView!=null) {
            for (int i = 0; i < tab3ListView.getChildCount(); i++) {
                cb = tab3ListView.getChildAt(i).findViewById(R.id.item_checked);
                if (cb.isChecked())
                    MainTabActivity.checkout_item_list.add(new CheckoutItem(tab3_row_items.get(i)));
            }
        }
    }
}
