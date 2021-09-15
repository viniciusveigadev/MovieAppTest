package com.movieapp.test.data.network.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "title")
    private final String tituloOriginal;

    public FilmeResponse(String caminhoPoster, String tituloOriginal) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
    }
    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }
}
