package com.example.asus.themoviedb.Upcoming_list.network;

import com.example.asus.themoviedb.Upcoming_list.UpcomingMoviesList;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/26/2017.
 */

public class UpcomingMoviesResponse {

    ArrayList<UpcomingMoviesList> results;

    public ArrayList<UpcomingMoviesList> getResults() {
        return results;
    }

    public void setResults(ArrayList<UpcomingMoviesList> results) {
        this.results = results;
    }
}
