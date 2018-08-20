package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.Service.SinopseServiceAsync;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.SinopseModel;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.UserModel;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.CardAdapter;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.SinopseAdapter;
import com.orafaaraujo.rxrecyclerexample.presentation.main.repository.UserLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
    private List<SinopseModel> sinopses;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SinopseServiceAsync async = new SinopseServiceAsync(this, new SinopseServiceAsync.onResponseRetrofitListenner() {
            @Override
            public void responseSinopses(List<SinopseModel> response) {}
        });

        try {

            sinopses = async.execute().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (sinopses != null)
        {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_layour_recycler_main);

            recyclerView.setAdapter(new SinopseAdapter(this.sinopses, this));

            StaggeredGridLayoutManager layoutManager =
                    new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setLayoutManager(layoutManager);
        }
    }
}
