package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.SinopseModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SinopseAdapter extends RecyclerView.Adapter<SinopseAdapter.FavoriteViewHolder>
{
    private List<SinopseModel> sinopses;

    private Context context;

    public SinopseAdapter(List<SinopseModel> sinopses, Context context)
    {
        this.sinopses = sinopses;
        this.context = context;
    }

    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FavoriteViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sinopse_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(SinopseAdapter.FavoriteViewHolder holder, int position)
    {
        holder.title.setText(this.sinopses.get(position).getTitulo());

        holder.desc.setText(this.sinopses.get(position).getGenero());

        holder.moreButton.setOnClickListener(view -> updateItem(position));
        holder.deleteButton.setOnClickListener(view -> removerItem(position));
    }

    // Método responsável por atualizar um usuário já existente na lista.
    private void updateItem(int position) {
        SinopseModel userModel = this.sinopses.get(position);
        notifyItemChanged(position);
    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {
        this.sinopses.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.sinopses.size());
    }

    @Override
    public int getItemCount() {
        return this.sinopses != null ? this.sinopses.size() : 0;
    }

    public static class FavoriteViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.main_card_title)
        public TextView title;

        @BindView(R.id.main_card_desc)
        public TextView desc;

        @BindView(R.id.main_card_more)
        public ImageButton moreButton;

        @BindView(R.id.main_card_delete)
        public ImageButton deleteButton;

        public FavoriteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

