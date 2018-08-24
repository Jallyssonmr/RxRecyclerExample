package com.unnamed.manga.util;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.unnamed.manga.model.MangaModel;

import java.lang.reflect.Type;

public class MangaDeserialize implements JsonDeserializer<MangaModel>
{
    @Override
    public MangaModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement sinopse = json.getAsJsonObject();

        if (json.getAsJsonObject().get("sinopse") != null){
            sinopse = json.getAsJsonObject();
        }

        return (new Gson().fromJson(sinopse, MangaModel.class));
    }
}

