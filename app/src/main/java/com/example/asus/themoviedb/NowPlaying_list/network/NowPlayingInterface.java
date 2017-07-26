package com.example.asus.themoviedb.NowPlaying_list.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ASUS on 7/26/2017.
 */

public interface NowPlayingInterface {

    @GET("now_playing")

    Call<NowPlayingResponse> getNowPlaying(@Query("api_key")String api_key);

//    @GET("now_playing")
//
//    Call<NowPlayingResponse> getNowPlaying(@Query("api_key")String api_key,@Query("page") int page);




}
