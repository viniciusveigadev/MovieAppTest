package com.movieapp.test.ui;

import com.movieapp.test.data.mapper.MovieMapper;
import com.movieapp.test.data.model.Movie;
import com.movieapp.test.data.network.ApiService;
import com.movieapp.test.data.network.response.movieResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListPresenter implements MovieListInterface.MovieListPresenter {

    private MovieListInterface.MovieListView view;

    public MovieListPresenter(MovieListInterface.MovieListView view) {
        this.view = view;
    }

    @Override
    public void getMovies() {
        ApiService.getInstance()
                .getPopularMovies("fcb6188dc381c27658a694c99c2bbd12", "pt-BR")
                .enqueue(new Callback<movieResult>() {
                    @Override
                    public void onResponse(Call<movieResult> call, Response<movieResult> response) {
                        if (response.isSuccessful()) { //200 ok
                            final List<Movie> movieList = MovieMapper.
                                    responseToDomainLayer(response.body().getMovieResults());
                            view.displayMovies(movieList);
                        } else {
                            view.errorMessage();
                        }
                    }

                    @Override
                    public void onFailure(Call<movieResult> call, Throwable t) {
                        view.errorMessage();
                    }
                });
    }

    @Override
    public void viewOnDestroy() {
        this.view = null;
    }
}
