package com.orafaaraujo.rxrecyclerexample.presentation.main.Service;

import com.orafaaraujo.rxrecyclerexample.presentation.main.model.SinopseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ISinopseServiceAsync
{
    @GET("sinopse")
    public Call<List<SinopseModel>> GetSinopse();
}