package com.movieapp.test.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class movieResult {

    @Json(name = "results")
    private final List<MovieResponse> movieResult;

    public movieResult(List<MovieResponse> movieResult) {
        this.movieResult = movieResult;
    }

    public List<MovieResponse> getMovieResults() {
        return movieResult;
    }
}
