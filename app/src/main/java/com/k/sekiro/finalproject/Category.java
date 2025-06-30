package com.k.sekiro.finalproject;

import androidx.annotation.DrawableRes;

public class Category {

    String name;
    @DrawableRes int img;

    public Category(String name, int img){
        this.name = name;
        this.img = img;
    }

}
