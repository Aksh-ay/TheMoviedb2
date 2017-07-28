package com.example.asus.themoviedb;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 7/27/2017.
 */

public class ItemsList {
    @SerializedName("release_date")
    private String movieDate;

    @SerializedName("first_air_date")
    private String tvDate;

    @SerializedName("title")
    private  String movieTitle;

    @SerializedName("name")
    private  String tvTitle;

    @SerializedName("id")
    private  int id;

    @SerializedName("poster_path")
    private  String imagePath;

    @SerializedName("vote_average")
    private  float rating;

    public String getTvTitle() {
        return tvTitle;
    }

    public String getTvDate() {

        return tvDate;
    }

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
}

