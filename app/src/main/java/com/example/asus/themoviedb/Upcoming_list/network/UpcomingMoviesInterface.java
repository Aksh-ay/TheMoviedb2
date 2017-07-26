package com.example.asus.themoviedb.Upcoming_list.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASUS on 7/26/2017.
 */

public interface UpcomingMoviesInterface {

    @GET("upcoming")
    Call <UpcomingMoviesResponse> getUpcomingList(@Query("api_key") String api_key);
}
