package com.example.asus.themoviedb.NowPlaying_list.network;

import com.example.asus.themoviedb.NowPlaying_list.NowPlayingMovieList;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/26/2017.
 */

public class NowPlayingResponse {

        public ArrayList<NowPlayingMovieList> results;

    public ArrayList<NowPlayingMovieList> getResults() {
        return results;
    }

    public void setResults(ArrayList<NowPlayingMovieList> results) {
        this.results = results;
    }
}
