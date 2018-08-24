package com.unnamed.manga.service;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unnamed.manga.model.MangaModel;
import com.unnamed.manga.util.MangaDeserialize;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MangaServiceAsync extends AsyncTask<Void, Void, List<MangaModel>>
{
    private Context context;

    private onResponseRetrofitListenner listenner;

    public MangaServiceAsync(Context context, onResponseRetrofitListenner listenner) {
        this.context = context;
        this.listenner = listenner;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<MangaModel> doInBackground(Void... params) {
        String baseurl = "http://192.168.11.6:5000/";

        Gson gsonConverter = new GsonBuilder().registerTypeAdapter(MangaModel.class, new MangaDeserialize())
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                .build();

        final IMangaServiceAsync service = retrofit.create(IMangaServiceAsync.class);

        Call<List<MangaModel>> mangas = service.GetSinopse();

        try {
            List<MangaModel> mangasResponse = mangas.execute().body();

            return mangasResponse;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<MangaModel> mangas) {
        this.listenner.responseSinopses(mangas);
    }

    public interface onResponseRetrofitListenner {
        public void responseSinopses(List<MangaModel> response);
    }
}

