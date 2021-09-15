package com.movieapp.test.data.mapper;

import com.movieapp.test.data.model.Filme;
import com.movieapp.test.data.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse) {
        List<Filme> listaFilmes = new ArrayList<>();

        for (FilmeResponse filmeResponse : listaFilmeResponse) {
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster());
            listaFilmes.add(filme);
        }

        return  listaFilmes;
    }
}
