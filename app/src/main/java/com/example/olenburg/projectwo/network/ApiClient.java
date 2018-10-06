package com.example.olenburg.projectwo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "https://kinoafisha.ua/ajax/";
    private static Retrofit retrofit = null;
    private static ApiService myApi;

    public static ApiService getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(ApiService.class);
        }
        return myApi;

    }

}
