package com.unnamed.manga.presentation.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.unnamed.manga.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MangaViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.main_card_title)
    public TextView title;

    @BindView(R.id.main_card_desc)
    public TextView desc;

    @BindView(R.id.main_card_more)
    public ImageButton moreButton;

    @BindView(R.id.main_card_delete)
    public ImageButton deleteButton;

    public MangaViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
