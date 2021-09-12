package com.movieapp.test.data.mapper;

import com.movieapp.test.data.model.Filme;
import com.movieapp.test.data.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse) {
        List<Filme> listaFilmes = new ArrayList<>();

        for (FilmeResponse filmeResponse : listaFilmeResponse) {
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster()); //Primeira coisa que o construtor pede é o titulo e ele ta vindo da clase de response que é FilmesResponse (vindo em Json e Java) e sendo jogado na classe de dominio que é Filme(classe tupo dataclass do kotlin). Ou seja passa pela response, depois dominio e enfim chega certinho aqui.
            listaFilmes.add(filme); //Add primneiro item no array de filmes
        }

        return  listaFilmes; //reorna o array com os dados
    }
}
