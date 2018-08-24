package com.unnamed.manga.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.unnamed.manga.R;
import com.unnamed.manga.model.MangaModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.FavoriteViewHolder>
{
    private List<MangaModel> mangas;

    private Context context;

    public MangaAdapter(List<MangaModel> mangas, Context context)
    {
        this.mangas = mangas;
        this.context = context;
    }

    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FavoriteViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.manga_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(MangaAdapter.FavoriteViewHolder holder, int position)
    {
        holder.title.setText(this.mangas.get(position).getTitulo());

        holder.desc.setText(this.mangas.get(position).getGenero());

        holder.moreButton.setOnClickListener(view -> updateItem(position));
        holder.deleteButton.setOnClickListener(view -> removerItem(position));
    }

    // Método responsável por atualizar um usuário já existente na lista.
    private void updateItem(int position) {
        MangaModel userModel = this.mangas.get(position);
        notifyItemChanged(position);
    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {
        this.mangas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.mangas.size());
    }

    @Override
    public int getItemCount() {
        return this.mangas != null ? this.mangas.size() : 0;
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

