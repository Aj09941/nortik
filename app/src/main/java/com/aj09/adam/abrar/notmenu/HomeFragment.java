package com.aj09.adam.abrar.notmenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment{
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View x = inflater.inflate(R.layout.home_tab_layout,null);
        /**
         * Inflate tab_layout and setup Views.
         */
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        /**
         * Set An adapter for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        /**
         * Now , This is The workaround,
         * The setup With ViewPager doesn't work without runnable .
         * May be a support Library bug
         */
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return x;
    }
    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * return fragment with resspect to position .
         * @param position
         * @return
         */

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new LifeStyleTabFragment();
                case 1: return new AutoTabFragment();
                case 2: return new ExpoTabFragment();

            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }
        /**
         * This mesthod return the title of the tab according to position
         */
        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "Life Style";
                case 1:
                    return "Auto";
                case 2:
                    return "Expo";
            }
            return null;
        }

    }

}