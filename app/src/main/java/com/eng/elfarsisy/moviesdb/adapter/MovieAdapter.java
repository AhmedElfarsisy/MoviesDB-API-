package com.eng.elfarsisy.moviesdb.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eng.elfarsisy.moviesdb.DetailsActivity;
import com.eng.elfarsisy.moviesdb.R;
import com.eng.elfarsisy.moviesdb.model.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private Context context;
    List<Result> moviesResualt;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.movie_card, parent, false);
        return new MovieHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Result result = moviesResualt.get(position);
        holder.movieLanguage.setText(moviesResualt.get(position).getOriginalLanguage());
        holder.movieName.setText(moviesResualt.get(position).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w185/" + moviesResualt.get(position).getPosterPath()).into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return moviesResualt != null ? moviesResualt.size() : 0;
    }

    public void setData(List<Result> results) {
        moviesResualt = results;
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;
        TextView movieName;
        TextView movieLanguage;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.movieImage);
            movieName = itemView.findViewById(R.id.movieName);
            movieLanguage = itemView.findViewById(R.id.movieLanguage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("movietitle", moviesResualt.get(position).getTitle());
                    intent.putExtra("movieorigintitle", moviesResualt.get(position).getOriginalTitle());
                    intent.putExtra("movie_poster", moviesResualt.get(position).getPosterPath());
                    intent.putExtra("movieoverview", moviesResualt.get(position).getOverview());
                    intent.putExtra("movielanguage", moviesResualt.get(position).getOriginalLanguage());
                    intent.putExtra("moviepopularity", moviesResualt.get(position).getPopularity());
                    intent.putExtra("movievote", moviesResualt.get(position).getVoteAverage());
                    context.startActivity(intent);
                }
            });

        }
    }
}
