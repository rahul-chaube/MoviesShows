package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Android7 on 3/6/2018.
 */

public class MovieResponse  implements Serializable{
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("rating")
    private float rating;
    @SerializedName("releaseYear")
    private int releaseYear;
//    @SerializedName("genre")
//    private
}
