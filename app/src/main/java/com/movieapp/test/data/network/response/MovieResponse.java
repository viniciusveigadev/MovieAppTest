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

    @Json(name = "release_date")
    private final String release_date;

    public MovieResponse(String posterPath, String title, String overview, int id, String release_date) {
        this.posterPath = posterPath;
        this.title = title;
        this.overview = overview;
        this.id = id;
        this.release_date = release_date;
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

    public String getRelease_date() {
        return release_date;
    }
}
