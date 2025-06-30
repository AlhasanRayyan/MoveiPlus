package com.k.sekiro.finalproject;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class Movie implements Serializable {

    String name;
    int img;
    String description;

    String date;

    String duration;

    String category;

    float rating;
    String country;
    public Movie(String name, @DrawableRes int img, String description,String date, String duration, String  category,float rating,String country){
        this.name = name;
        this.img = img;
        this.date = date;
        this.category = category;
        this.description = description;
        this.duration = duration;
        this.rating = rating;
        this.country = country;

    }

}
