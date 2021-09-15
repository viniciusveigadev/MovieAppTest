package com.movieapp.test.data.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private final String title;
    private final String posterPath;
    private final String overview;

    public Movie(String title, String posterPath, String overview) {
        this.title = title;
        this.posterPath = posterPath;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }
}
