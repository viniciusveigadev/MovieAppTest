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
//Getter que nos dão liberdade de obter os dados e "JOGAR" no nosso adapter. Mais especificamente no viewHolder que é o cara que joga os dados em cada item da lista
    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }
}
