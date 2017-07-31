package com.example.asus.themoviedb.network;

import com.example.asus.themoviedb.movies_tvs.GenreList;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/31/2017.
 */

public class DetailsResponse {

    public credits credits;

    private  ArrayList<GenreList> created_by;

    private ArrayList<GenreList> genres;

    private String overview;

    @SerializedName("runtime")
    private int movieRuntime;

    @SerializedName("episode_run_time")
    private ArrayList<Integer> tvRuntime;


    private int budget;

    private int revenue;

    private String last_air_date;

    private String networks;

    private String status;

    private String type;


    public static class credits {
        ArrayList<GenreList> crew = new ArrayList<>();

        public ArrayList<GenreList> getCrew() {
            return crew;
        }
    }

    public DetailsResponse.credits getCredits() {
        return credits;
    }

    public ArrayList<GenreList> getCreated_by() {
        return created_by;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public String getNetworks() {
        return networks;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getOverview() {
        return overview;
    }

    public int getMovieRuntime() {
        return movieRuntime;
    }

    public int getBudget() {
        return budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public ArrayList<Integer> getTvRuntime() {
        return tvRuntime;
    }

    public ArrayList<GenreList> getGenres() {
        return genres;
    }





}


