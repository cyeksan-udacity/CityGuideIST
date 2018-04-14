package com.example.android.tourguideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Cansu on 10.04.2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "INFORMATION", "MAP"};

    public SimpleFragmentPagerAdapter (FragmentManager fm){

        super(fm);
    }

    @Override

    public Fragment getItem(int position) {

        if (position == 0) {

            return new InformationFragment();

        } else {

            return new MapFragment();

        }

    }

    @Override

    public int getCount() {

        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}



