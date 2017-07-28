package com.example.asus.themoviedb.network;

import com.example.asus.themoviedb.movies_tvs.ItemsList;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/27/2017.
 */

public class ItemsResponse {
    private ArrayList<ItemsList> results;


    public ArrayList<ItemsList> getResults() {
        return results;
    }

}
