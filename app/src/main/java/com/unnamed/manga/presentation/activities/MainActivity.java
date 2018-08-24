package com.unnamed.manga.presentation.activities;

import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.unnamed.manga.R;
import com.unnamed.manga.fragment.MangaFragment;
import com.unnamed.manga.model.MangaModel;
import com.unnamed.manga.presentation.adapter.ViewPagerAdapter;
import com.unnamed.manga.service.MangaServiceAsync;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity
{
    private TabLayout tabLayout;

    private ViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;

    public static List<MangaModel> mangas;

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

        this.viewPagerAdapter.AddFragment(new MangaFragment(), "Mangás");
        this.viewPagerAdapter.AddFragment(new MangaFragment(), "Favoritos");
        this.viewPagerAdapter.AddFragment(new MangaFragment(), "");

        this.viewPager.setAdapter(this.viewPagerAdapter);
        this.tabLayout.setupWithViewPager(this.viewPager);

        this.tabLayout.getTabAt(2).setIcon(R.drawable.ic_notification_holo_dark);
    }

    private void GetSinopses()
    {
        MangaServiceAsync async = new MangaServiceAsync(this, new MangaServiceAsync.onResponseRetrofitListenner() {
            @Override
            public void responseSinopses(List<MangaModel> response) {}
        });

        try {

            this.mangas = async.execute().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
