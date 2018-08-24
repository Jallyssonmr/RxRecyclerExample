package com.unnamed.manga.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unnamed.manga.R;
import com.unnamed.manga.presentation.activities.MainActivity;
import com.unnamed.manga.presentation.adapter.MangaAdapter;

public class MangaFragment extends android.support.v4.app.Fragment
{
    private View view;

    private RecyclerView recyclerView;

    public MangaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.view = inflater.inflate(R.layout.manga_fragment, container, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recycler_view_favorite_fragment);

        MangaAdapter mangaAdapter = new MangaAdapter(MainActivity.mangas, getContext());

        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setAdapter(mangaAdapter);

        return this.view;
    }
}
