package com.example.asus.themoviedb.Popular_list.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASUS on 7/27/2017.
 */

public interface PopularInterface {

    @GET ("popular")
    Call<PopularMoviesResponse> getPopular(@Query("api_key") String api_key);
}


