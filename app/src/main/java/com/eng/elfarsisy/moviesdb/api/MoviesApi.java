package com.eng.elfarsisy.moviesdb.api;

import com.eng.elfarsisy.moviesdb.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApi {
    @GET("/3/movie/{sort}")
    Call<MovieResponse>getMoives(@Path("sort") String sort, @Query("api_key") String key);
}
