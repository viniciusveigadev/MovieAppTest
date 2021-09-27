package com.movieapp.test.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;
import com.movieapp.test.data.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.moviesListViewHolder> {

    private List<Movie> movies;
    private static MovieItemClickListener movieItemClickListener;

    public MovieListAdapter(MovieItemClickListener movieItemClickListener) {
        this.movieItemClickListener = movieItemClickListener;

        movies = new ArrayList<>();
    }

    @NonNull
    @Override
    public moviesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new moviesListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull moviesListViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return (movies != null && movies.size() > 0) ? movies.size() : 0;
    }

    static class moviesListViewHolder extends RecyclerView.ViewHolder {

        private TextView txtMovieTitle;
        private ImageView imgMoviePoster;
        private Movie movie;

        public moviesListViewHolder(View itemView) {
            super(itemView);

            txtMovieTitle = itemView.findViewById(R.id.text_movie_title);
            imgMoviePoster = itemView.findViewById(R.id.image_movie_poster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (movieItemClickListener != null) {
                        movieItemClickListener.onClickMovieItem(movie);
                    }
                }
            });
        }

        public void bind(Movie movie) {
            this.movie = movie;

            txtMovieTitle.setText(movie.getTitle());

            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500/" + movie.getPosterPath())
                    .into(imgMoviePoster);
        }
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public interface MovieItemClickListener {

        void onClickMovieItem(Movie movie);
    }
}
