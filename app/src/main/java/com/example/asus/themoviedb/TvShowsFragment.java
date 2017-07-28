package com.example.asus.themoviedb;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {

    public static boolean tvFlag = false;

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;


    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewpager_root_fragment, container, false);

        tvFlag=true;
        MoviesFragment.movieFlag = false;

        // Inflate the layout for this fragment
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);


        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        viewPagerAdapter.addFragments(new ItemsListFragment(),"AIRING TODAY");
        viewPagerAdapter.addFragments(new ItemsListFragment(),"ON THE AIR");
        viewPagerAdapter.addFragments(new ItemsListFragment(),"POPULAR");
        viewPagerAdapter.addFragments(new ItemsListFragment(),"TOP RATED");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


        return v;
        }

}
