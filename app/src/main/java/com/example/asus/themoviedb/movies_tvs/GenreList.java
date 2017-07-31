package com.example.asus.themoviedb.movies_tvs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 7/28/2017.
 */

public class GenreList {

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("job")
    String job;

    public String getJob() {
        return job;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
