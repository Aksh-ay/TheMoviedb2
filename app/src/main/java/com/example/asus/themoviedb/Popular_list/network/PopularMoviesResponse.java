package com.example.asus.themoviedb.Popular_list.network;

import com.example.asus.themoviedb.Popular_list.PopularMovieList;

import java.util.ArrayList;
import java.util.PropertyPermission;

/**
 * Created by ASUS on 7/27/2017.
 */

public class PopularMoviesResponse {

    public ArrayList<PopularMovieList> results;

    public ArrayList<PopularMovieList> getResults() {
        return results;
    }

    public void setResults(ArrayList<PopularMovieList> results) {
        this.results = results;
    }
}
