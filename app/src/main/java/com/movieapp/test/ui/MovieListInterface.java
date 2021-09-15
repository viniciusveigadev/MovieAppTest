package com.movieapp.test.ui;

import com.movieapp.test.data.model.Movie;

import java.util.List;

public interface MovieListInterface {

    interface MovieListView {

        void displayMovies(List<Movie> movies);
        void errorMessage();
    }

    interface MovieListPresenter {

        void getMovies();

        void viewOnDestroy();
    }

}
