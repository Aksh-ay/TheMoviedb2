package com.example.asus.themoviedb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/25/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<ItemsListFragment> fragmentArrayList;
    ArrayList<String> tabTitles = new ArrayList<>();

    public void addFragments(ItemsListFragment fragment , String tabTitles){
        Bundle b = new Bundle();
        b.putInt("position", fragmentArrayList.size());
        fragment.setArguments(b);
        fragmentArrayList.add(fragment);
        this.tabTitles.add(tabTitles);
    }


    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
        fragmentArrayList = new ArrayList<>();
    }
    @Override
    public Fragment getItem(int position) {
        ItemsListFragment fragment = fragmentArrayList.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position){
        return tabTitles.get(position);
    }
}
