package com.movieapp.test.data.network.response;

import com.squareup.moshi.Json;

public class MovieResponse {

    @Json(name = "poster_path")
    private final String posterPath;

    @Json(name = "title")
    private final String title;

    public MovieResponse(String posterPath, String title) {
        this.posterPath = posterPath;
        this.title = title;
    }
    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }
}
