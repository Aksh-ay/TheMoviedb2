package com.example.asus.themoviedb.NowPlaying_list.network;

import com.example.asus.themoviedb.NowPlaying_list.NowPlayingMovieList;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/26/2017.
 */

public class NowPlayingResponse {

        public ArrayList<NowPlayingMovieList> results;

       public  int total_pages;

    public ArrayList<NowPlayingMovieList> getResults() {
        return results;
    }

    public void setResults(ArrayList<NowPlayingMovieList> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
