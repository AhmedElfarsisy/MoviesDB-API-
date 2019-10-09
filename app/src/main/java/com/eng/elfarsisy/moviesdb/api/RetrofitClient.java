package com.eng.elfarsisy.moviesdb.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit getInstance() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.themoviedb.org").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        return retrofit;
    }
}
