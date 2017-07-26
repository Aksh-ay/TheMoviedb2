package com.example.asus.themoviedb.TopRated_list.network;

import com.example.asus.themoviedb.NowPlaying_list.NowPlayingMovieList;
import com.example.asus.themoviedb.TopRated_list.TopRatedMovieList;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/26/2017.
 */

public class TopRatedResponse {


    public ArrayList<TopRatedMovieList> results;

    public ArrayList<TopRatedMovieList> getResults() {
        return results;
    }

    public void setResults(ArrayList<TopRatedMovieList> results) {
        this.results = results;
    }

}
