package com.movieapp.test.data.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

    @GET("movie/now_playing")
    Call<ResponseBody> obterFilmesPopulares(@Query("api_key") String chaveApi);

}
