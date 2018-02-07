package com.andproj.skm.fondoffood;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.andproj.skm.fondoffood.model.CheckoutItem;

import java.util.ArrayList;
import java.util.List;

public class MainTabActivity extends AppCompatActivity {

    private static final String TAG="MainTabActivity";

    ViewPager viewPager;
    FloatingActionButton next;

    public static ArrayList<CheckoutItem> checkout_item_list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        viewPager=findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        next=findViewById(R.id.next);
        next.setImageResource(R.drawable.next);
        final Intent checkoutActivity=new Intent(this,CheckoutActivity.class);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readAllSelectedItems();
                startActivity(checkoutActivity);
            }
        });
    }

    private void readAllSelectedItems() {
       // try {
            Tab1Fragment.add_tab1_checkout_items();
            Tab2Fragment.add_tab2_checkout_items();
            Tab3Fragment.add_tab3_checkout_items();


       // }catch (Exception e){e.printStackTrace(); System.exit(0);}

    }

    private void setupViewPager(ViewPager viewPager)
    {
        FragmentPageAdapter fragmentPageAdapter=new FragmentPageAdapter(getSupportFragmentManager());
        fragmentPageAdapter.addFragment(new Tab1Fragment(),"Sandwich");
        fragmentPageAdapter.addFragment(new Tab2Fragment(),"Juice");
        fragmentPageAdapter.addFragment(new Tab3Fragment(),"Others");
        viewPager.setAdapter(fragmentPageAdapter);

    }

}
