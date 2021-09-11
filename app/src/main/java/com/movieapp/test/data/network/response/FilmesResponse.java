package com.movieapp.test.data.network.response;

import com.squareup.moshi.Json;

public class FilmesResponse {
    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "original_title")
    private final String tituloOriginal;

    public FilmesResponse(String caminhoPoster, String tituloOriginal) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
    }
}
