package com.example.asus.themoviedb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/25/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabTitle = new ArrayList<>();

    public void addFragments(Fragment fragment , String tabTitle){

        this.fragments.add(fragment);
        this.tabTitle.add(tabTitle);

    }

    public ViewPagerAdapter(FragmentManager fm){

        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public CharSequence getPageTitle(int position){
        return tabTitle.get(position);
    }
}
