package com.example.asus.themoviedb;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 7/28/2017.
 */

public class PersonsList {

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("profile_path")
    String profileImage_path;

    public String getProfileImage_path() {
        return profileImage_path;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
