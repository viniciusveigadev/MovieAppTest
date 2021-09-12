package com.movieapp.test.data.network;

import com.movieapp.test.data.network.response.FilmesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

    @GET("movie/now_playing")
    Call<FilmesResult> obterFilmesPopulares(@Query("api_key") String chaveApi, @Query("language") String lingua);

}
