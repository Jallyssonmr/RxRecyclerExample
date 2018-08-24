package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter
{
    private final List<Fragment> listFragment = new ArrayList<>();

    private final List<String> listTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm)   {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {
       return this.listFragment.get(position);
    }

    @Override
    public int getCount() {
        return this.listTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.listTitles.get(position);
    }

    public void AddFragment (Fragment fragment, String title)
    {
        this.listFragment.add(fragment);
        this.listTitles.add(title);
    }
}