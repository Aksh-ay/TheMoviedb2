package com.example.asus.themoviedb.movies_tvs;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.themoviedb.R;
import com.example.asus.themoviedb.ViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    public static boolean movieFlag = false;

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;


    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.viewpager_root_fragment, container, false);

        movieFlag = true ;
        TvShowsFragment.tvFlag =false;

        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);


        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new ItemsListFragment(),"NOW PLAYING");
        viewPagerAdapter.addFragments(new ItemsListFragment(),"UPCOMING");
        viewPagerAdapter.addFragments(new ItemsListFragment(),"POPULAR");
        viewPagerAdapter.addFragments(new ItemsListFragment(),"TOP RATED");


        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);




        return v;
    }

}
