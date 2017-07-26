package com.example.asus.themoviedb.TopRated_list.network;

import com.example.asus.themoviedb.NowPlaying_list.network.NowPlayingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASUS on 7/26/2017.
 */

public interface TopRatedInterface {

    @GET("top_rated")
    Call<TopRatedResponse> getTopRated(@Query("api_key")String api_key);


}
