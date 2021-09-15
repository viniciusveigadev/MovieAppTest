package com.movieapp.test.data.network;

import com.movieapp.test.data.network.response.movieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/now_playing")
    Call<movieResult> getPopularMovies(@Query("api_key") String myApiKey, @Query("language") String defaultLanguage);

}
