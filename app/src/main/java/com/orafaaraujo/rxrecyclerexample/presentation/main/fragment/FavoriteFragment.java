package com.orafaaraujo.rxrecyclerexample.presentation.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.activities.MainActivity;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.SinopseAdapter;

public class FavoriteFragment extends android.support.v4.app.Fragment
{
    private View view;

    private RecyclerView recyclerView;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.view = inflater.inflate(R.layout.favorite_fragment, container, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recycler_view_favorite_fragment);

        SinopseAdapter sinopseAdapter = new SinopseAdapter(MainActivity.sinopses, getContext());

        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setAdapter(sinopseAdapter);

        return this.view;
    }
}
