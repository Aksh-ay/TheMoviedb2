package com.example.asus.themoviedb.NowPlaying_list;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 7/25/2017.
 */

public class NowPlayingMovieList {

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("title")
    private  String title;

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
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
