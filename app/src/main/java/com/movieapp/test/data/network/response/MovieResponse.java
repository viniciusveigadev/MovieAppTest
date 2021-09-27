package com.movieapp.test.data.network.response;

import com.squareup.moshi.Json;

public class MovieResponse {

    @Json(name = "poster_path")
    private final String posterPath;

    @Json(name = "title")
    private final String title;

    @Json(name = "overview")
    private final String overview;

    @Json(name = "id")
    private final int id;

    public MovieResponse(String posterPath, String title, String overview, int id) {
        this.posterPath = posterPath;
        this.title = title;
        this.overview = overview;
        this.id = id;
    }
    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public int getId() {
        return id;
    }
}
