package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.activities;

import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.Service.SinopseServiceAsync;
import com.orafaaraujo.rxrecyclerexample.presentation.main.fragment.FavoriteFragment;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.SinopseModel;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.SinopseAdapter;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.ViewPagerAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity
{
    private TabLayout tabLayout;

    private ViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;

    public static List<SinopseModel> sinopses;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.GetSinopses();

        this.tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        this.viewPager = (ViewPager) findViewById(R.id.pager);
        this.viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment here

        this.viewPagerAdapter.AddFragment(new FavoriteFragment(), "Mangás");
        this.viewPagerAdapter.AddFragment(new FavoriteFragment(), "Favoritos");
        this.viewPagerAdapter.AddFragment(new FavoriteFragment(), "");

        this.viewPager.setAdapter(this.viewPagerAdapter);
        this.tabLayout.setupWithViewPager(this.viewPager);

        this.tabLayout.getTabAt(2).setIcon(R.drawable.ic_notification_holo_dark);
    }

    private void GetSinopses()
    {
        SinopseServiceAsync async = new SinopseServiceAsync(this, new SinopseServiceAsync.onResponseRetrofitListenner() {
            @Override
            public void responseSinopses(List<SinopseModel> response) {}
        });

        try {

            this.sinopses = async.execute().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
