package com.unnamed.manga.service;

import com.unnamed.manga.model.MangaModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMangaServiceAsync
{
    @GET("sinopse")
    public Call<List<MangaModel>> GetSinopse();
}