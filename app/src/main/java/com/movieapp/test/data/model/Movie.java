package com.movieapp.test.data.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private final String title;
    private final String posterPath;
    private final String overview;
    private final int id;
    private boolean isMovieFavorited;

    public Movie(String title, String posterPath, String overview, int id) {
        this.title = title;
        this.posterPath = posterPath;
        this.overview = overview;
        this.id = id;
        this.isMovieFavorited = false;
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

    public int getId() {
        return id;
    }

    public boolean isMovieFavorited() {
        return isMovieFavorited;
    }

    //Setters

    public void setFavorited(boolean favorited) {
        isMovieFavorited = favorited;
    }

}
