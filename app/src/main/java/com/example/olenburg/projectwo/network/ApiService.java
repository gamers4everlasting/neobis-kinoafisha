package com.example.olenburg.projectwo.network;


import com.example.olenburg.projectwo.model.CinemaObject;
import com.example.olenburg.projectwo.model.TeatrObject;
import com.example.olenburg.projectwo.model.TeatrObjectParser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("kinoafisha_load?")
    Call<CinemaObject> getKino(@Query("city") String city, @Query("date") String date,
                                   @Query("kinoteatr") String kinoID);

    @GET("kinoteatrs_load")
    Call<TeatrObjectParser> getTeatr();
}
