package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.SinopseModel;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.viewholder.SinopseViewHolder;

import java.util.List;
import java.util.Locale;

public class SinopseAdapter extends RecyclerView.Adapter
{
    private List<SinopseModel> sinopses;

    private Context context;

    public SinopseAdapter(List<SinopseModel> sinopses, Context context)
    {
        this.sinopses = sinopses;
        this.context = context;
    }

    @Override
    public SinopseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SinopseViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sinopse_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
    {
        SinopseViewHolder holder = (SinopseViewHolder) viewHolder;

        SinopseModel sinopse  = this.sinopses.get(position);

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
}

