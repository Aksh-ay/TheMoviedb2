package com.example.asus.themoviedb.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ASUS on 7/26/2017.
 */

public interface ApiInterface {

    //for fetching movies
    @GET("movie/now_playing")
    Call<ItemsResponse> getNowPlaying(@Query("api_key") String api_key);

    @GET ("movie/popular")
    Call<ItemsResponse> getPopular(@Query("api_key") String api_key);

    @GET("movie/top_rated")
    Call<ItemsResponse> getTopRated(@Query("api_key")String api_key);

    @GET("movie/upcoming")
    Call <ItemsResponse> getUpcomingList(@Query("api_key") String api_key);

    @GET("movie/{movie_id}")
    Call<DetailsResponse> getMovieDetails(@Path("movie_id") int id,@Query("api_key") String api_key, @Query("append_to_response") String response);


    //------------------------------------------------------------------------------------//

    //for fetching tv_shows
    @GET("tv/airing_today")
    Call<ItemsResponse> getAiringToday(@Query("api_key") String api_key);

    @GET("tv/on_the_air")
    Call<ItemsResponse> getTvOnAir(@Query("api_key") String api_key);

    @GET("tv/popular")
    Call<ItemsResponse> getTvPopular(@Query("api_key") String api_key);

    @GET("tv/top_rated")
    Call<ItemsResponse> getTvTopRated(@Query("api_key") String api_key);

    @GET("tv/{tv_id}")
    Call<DetailsResponse> getTvDetails(@Path("tv_id") int id,@Query("api_key") String api_key);


    //====================================================================================//

    //for fetcing peoples
    @GET("person/popular")
    Call<PersonsResponse> getPersonPopular(@Query("api_key") String api_key);

    //====================================================================================//

    //for genres list
    @GET("genre/movie/list")
    Call<GenresResponse> getMoviesGenre(@Query("api_key") String api_key);

    @GET("genre/tv/list")
    Call<GenresResponse> getTvShowsGenre(@Query("api_key") String api_key);

    //====================================================================================//










//    @GET("now_playing")
//
//    Call<NowPlayingResponse> getNowPlaying(@Query("api_key")String api_key,@Query("page") int page);




}
