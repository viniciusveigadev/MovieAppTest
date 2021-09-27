package com.movieapp.test.data.mapper;

import com.movieapp.test.data.model.Movie;
import com.movieapp.test.data.network.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    public static List<Movie> responseToDomainLayer(List<MovieResponse> movieResponseList) {
        List<Movie> movieList = new ArrayList<>();

        for (MovieResponse movieResponse : movieResponseList) {
            final Movie movie = new Movie(movieResponse.getTitle(), movieResponse.getPosterPath(), movieResponse.getOverview(), movieResponse.getId(), movieResponse.getRelease_date());
            movieList.add(movie);
        }

        return  movieList;
    }
}
