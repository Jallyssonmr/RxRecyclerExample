package com.orafaaraujo.rxrecyclerexample.presentation.main.Util;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.SinopseModel;

import java.lang.reflect.Type;

public class SinopseDeserialize implements JsonDeserializer<SinopseModel>
{
    @Override
    public SinopseModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement sinopse = json.getAsJsonObject();

        if (json.getAsJsonObject().get("sinopse") != null){
            sinopse = json.getAsJsonObject();
        }

        return (new Gson().fromJson(sinopse, SinopseModel.class));
    }
}

