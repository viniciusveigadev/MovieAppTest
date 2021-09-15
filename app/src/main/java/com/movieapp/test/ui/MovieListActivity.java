package com.movieapp.test.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;
import com.movieapp.test.data.model.Movie;

import java.util.List;

public class MovieListActivity extends AppCompatActivity implements MovieListInterface.MovieListView {

    private RecyclerView recyclerMovies;
    private MovieListAdapter moviesAdapter;
    MovieListInterface.MovieListPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list_activity);

        setAdapter();

        presenter = new MovieListPresenter(this);

        presenter.getMovies();
    }

    private void setAdapter() {
        recyclerMovies = findViewById(R.id.recycler_view);

        moviesAdapter = new MovieListAdapter();

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerMovies.setLayoutManager(gridLayoutManager);
        recyclerMovies.setAdapter(moviesAdapter);
    }

    @Override
    public void displayMovies(List<Movie> movies) {
        moviesAdapter.setMovies(movies);
    }

    @Override
    public void errorMessage() {
        Toast.makeText(this, "Erro ao obter lista de filmes", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.viewOnDestroy();
    }
}
