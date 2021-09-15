package com.movieapp.test.data.model;

public class Movie {
    private final String title;
    private final String posterPath;

    public Movie(String title, String posterPath) {
        this.title = title;
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
