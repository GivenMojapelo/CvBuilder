package com.givenchdy.cvbuilder.cvbuilder.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class CvViewPagerAdapter extends FragmentPagerAdapter {

    protected Fragment[] fragments;
    private static String TAG = "CvViewPagerAdapter";

    public CvViewPagerAdapter(FragmentManager fm, Fragment[] fragments)
    {
        super(fm);
        Log.d(TAG, "ExplainerViewPageAdapter : START");
        try
        {
            this.fragments = fragments;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        Log.d(TAG, "ExplainerViewPageAdapter : END");
    }


    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
