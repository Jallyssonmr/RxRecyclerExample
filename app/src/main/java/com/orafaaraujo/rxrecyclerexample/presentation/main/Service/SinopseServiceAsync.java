package com.orafaaraujo.rxrecyclerexample.presentation.main.Service;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orafaaraujo.rxrecyclerexample.presentation.main.Util.SinopseDeserialize;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.SinopseModel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SinopseServiceAsync extends AsyncTask<Void, Void, List<SinopseModel>> {
    private Context context;

    private onResponseRetrofitListenner listenner;

    public SinopseServiceAsync(Context context, onResponseRetrofitListenner listenner) {
        this.context = context;
        this.listenner = listenner;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<SinopseModel> doInBackground(Void... params) {
        String baseurl = "http://192.168.11.5:5000/";

        Gson gsonConverter = new GsonBuilder().registerTypeAdapter(SinopseModel.class, new SinopseDeserialize())
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                .build();

        final ISinopseServiceAsync service = retrofit.create(ISinopseServiceAsync.class);

        Call<List<SinopseModel>> sinopses = service.GetSinopse();

        try {
            List<SinopseModel> sinopseResponse = sinopses.execute().body();

            return sinopseResponse;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<SinopseModel> sinopses) {
        this.listenner.responseSinopses(sinopses);
    }

    public interface onResponseRetrofitListenner {
        public void responseSinopses(List<SinopseModel> response);
    }
}

