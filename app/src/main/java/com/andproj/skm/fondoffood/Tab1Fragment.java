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

public class Tab1Fragment extends Fragment implements AdapterView.OnItemClickListener{

    private static final String TAG="Tab1Fragment";


    String[] tab1_item_names;
    String[] tab1_item_prices;
    String[] tab1_item_descs;
    TypedArray tab1_item_images;

    static ArrayList<ItemModel> tab1_row_items;
    static ListView tab1ListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab1_fragment,container,false);

        tab1ListView=view.findViewById(R.id.tab1ListView);

        tab1_row_items=new ArrayList<ItemModel>();
        tab1_item_names=getResources().getStringArray(R.array.tab1_item_names);
        tab1_item_prices=getResources().getStringArray(R.array.tab1_item_prices);
        tab1_item_descs=getResources().getStringArray(R.array.tab1_item_descriptions);
        tab1_item_images=getResources().obtainTypedArray(R.array.tab1_item_images);

        for(int i=0;i<tab1_item_names.length;i++)
        {
            ItemModel item=new ItemModel(tab1_item_names[i],tab1_item_prices[i],tab1_item_descs[i],tab1_item_images.getResourceId(i,-1));
            tab1_row_items.add(item);
        }

        CustomListAdapter customListAdapter=new CustomListAdapter(this.getContext(),tab1_row_items);



        tab1ListView.setAdapter(customListAdapter);
        tab1ListView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            CheckBox ckbox=view.findViewById(R.id.item_checked);
            ckbox.performClick();
            if(ckbox.isChecked()){
                Toast.makeText(getContext(),"checked",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getContext(),"Unchecked",Toast.LENGTH_SHORT).show();
            }
    }

    public static void add_tab1_checkout_items()
    {
        List<CheckoutItem> tab1_list=new ArrayList<>();
        CheckBox cb=null;

        if(tab1ListView!=null) {
            for (int i = 0; i < tab1ListView.getChildCount(); i++) {
                cb = tab1ListView.getChildAt(i).findViewById(R.id.item_checked);
                if (cb.isChecked())
                    MainTabActivity.checkout_item_list.add(new CheckoutItem(tab1_row_items.get(i)));
            }
        }
    }
}
