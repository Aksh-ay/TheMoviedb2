package com.example.asus.themoviedb.network;

import com.example.asus.themoviedb.persons.PersonsList;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/28/2017.
 */

public class PersonsResponse {

    private ArrayList<PersonsList> results;

    public ArrayList<PersonsList> getResults() {
        return results;
    }
}
