package com.andproj.skm.fondoffood;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skumarmanda on 2/4/2018.
 */

public class FragmentPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> fragmentTitleList=new ArrayList<>();

    public FragmentPageAdapter(FragmentManager fm)
    {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title)
    {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    public CharSequence getPageTitle(int position)
    {
        return fragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
