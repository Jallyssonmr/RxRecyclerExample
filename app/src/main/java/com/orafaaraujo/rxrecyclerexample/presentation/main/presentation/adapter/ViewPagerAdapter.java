package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.orafaaraujo.rxrecyclerexample.presentation.main.fragment.FavoriteFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter
{
    private int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position) {
            case 0:
                FavoriteFragment tab1 = new FavoriteFragment();
                return tab1;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}