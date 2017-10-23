package com.sharadtechnologies.rarome.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sharadtechnologies.rarome.utilities.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    private static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(AppConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create(setGsonBuilder())).build();
        }
        return retrofit;
    }

    private static Gson setGsonBuilder()
    {
        return new GsonBuilder().setLenient().create();
    }
}