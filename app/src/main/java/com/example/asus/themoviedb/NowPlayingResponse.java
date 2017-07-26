package com.example.asus.themoviedb;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/26/2017.
 */

public class NowPlayingResponse {

        public ArrayList<MovieListThumblain> results;

    public ArrayList<MovieListThumblain> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieListThumblain> results) {
        this.results = results;
    }
}
