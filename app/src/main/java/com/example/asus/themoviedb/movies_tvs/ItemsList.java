package com.example.asus.themoviedb.movies_tvs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 7/27/2017.
 */

public class ItemsList {

    //For Movies
    @SerializedName("release_date")
    private String movieDate;

    @SerializedName("title")
    private  String movieTitle;

    //For Tv Shows
    @SerializedName("first_air_date")
    private String tvDate;

    @SerializedName("name")
    private  String tvTitle;

    //Common in both
    @SerializedName("id")
    private  int id;

    @SerializedName("poster_path")
    private  String imagePath;

    @SerializedName("vote_average")
    private  float rating;

    @SerializedName("genre_ids")
    private int genreIds[];

    @SerializedName("overview")
    private  String overview;

    public String getMovieDate() {
        return movieDate;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public float getRating() {
        return rating;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public String getOverview() {
        return overview;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public String getTvDate() {return tvDate; }
}

