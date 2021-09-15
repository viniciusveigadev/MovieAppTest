package com.movieapp.test.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    public static FilmesService INSTANCE;

    public static FilmesService getInstance() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
            INSTANCE = retrofit.create(FilmesService.class);
        }
        return INSTANCE;
    }
}
