package com.eng.elfarsisy.moviesdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.eng.elfarsisy.moviesdb.adapter.MovieAdapter;
import com.eng.elfarsisy.moviesdb.api.MoviesApi;
import com.eng.elfarsisy.moviesdb.api.RetrofitClient;
import com.eng.elfarsisy.moviesdb.model.MovieResponse;
import com.eng.elfarsisy.moviesdb.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    MovieAdapter moiveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setUpRecycler();
        viewMoives();
    }

    private void setUpRecycler() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        moiveAdapter = new MovieAdapter(this);
        recyclerView.setAdapter(moiveAdapter);
    }


    private void viewMoives() {
        Retrofit retrofit = RetrofitClient.getInstance();
        MoviesApi moviesApi = retrofit.create(MoviesApi.class);
        Call<MovieResponse> moives = moviesApi.getMoives("popular", "39124f42fcda5e6e4e22a9d602876810");
        moives.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                viewMoivesOnRecycler(movieResponse);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }

    private void viewMoivesOnRecycler(MovieResponse movieResponse) {
        List<Result> results = movieResponse.getResults();
        moiveAdapter.setData(results);
        moiveAdapter.notifyDataSetChanged();

    }
}
