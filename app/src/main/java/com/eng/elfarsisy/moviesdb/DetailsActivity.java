package com.eng.elfarsisy.moviesdb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.posterImage)
    ImageView posterImage;
    @BindView(R.id.movieTitle)
    TextView movieTitle;
    @BindView(R.id.movielang)
    TextView movielang;
    @BindView(R.id.movieoverview)
    TextView movieoverview;
    @BindView(R.id.movievote)
    TextView movievote;
    @BindView(R.id.moviepopularity)
    TextView moviepopularity;
    @BindView(R.id.movieoriginalT)
    TextView movieoriginalT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        Intent intent = getIntent();

        String movietitle = intent.getExtras().getString("movietitle");
        movieTitle.setText(movietitle);

        String movieorigintitle = intent.getExtras().getString("movieorigintitle");
        movieoriginalT.setText(movieorigintitle);
        String movieoverviewString = intent.getExtras().getString("movieoverview");
        movieoverview.setText(movieoverviewString);
        String movie_poster = intent.getExtras().getString("movie_poster");
        Glide.with(this).load("https://image.tmdb.org/t/p/w185/"+movie_poster).into(posterImage);

        String movielanguage = intent.getExtras().getString("movielanguage");
        movielang.setText(movielanguage);
        String moviepopular = intent.getExtras().getString("moviepopularity");
        moviepopularity.setText(moviepopular);
        double movievoteavrage =intent.getExtras().getDouble("movievote");
        movievote.setText(Double.toString(movievoteavrage));


    }
}
