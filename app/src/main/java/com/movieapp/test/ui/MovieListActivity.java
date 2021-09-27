package com.movieapp.test.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.movieapp.test.R;
import com.movieapp.test.data.model.Movie;
import com.movieapp.test.ui.moviedetails.MovieDetailsActivity;

import java.util.List;

public class MovieListActivity extends AppCompatActivity implements MovieListInterface.MovieListView, MovieListAdapter.MovieItemClickListener {

    private RecyclerView recyclerMovies;
    private MovieListAdapter moviesAdapter;
    MovieListInterface.MovieListPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setAdapter();

        presenter = new MovieListPresenter(this);

        presenter.getMovies();
    }

    private void setAdapter() {
        recyclerMovies = findViewById(R.id.recycler_view);

        moviesAdapter = new MovieListAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager;

        //Change number of columns displayed when user change screen orientation
        if (getBaseContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            gridLayoutManager = new GridLayoutManager(this, 2);
        } else {
            gridLayoutManager = new GridLayoutManager(this, 4);
        }

        recyclerMovies.setLayoutManager(gridLayoutManager);
        //recyclerMovies.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
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

    @Override
    public void onClickMovieItem(Movie movie) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.MOVIE_EXTRA, movie);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.favorites) {
            Intent intent = new Intent(this, FavoriteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
