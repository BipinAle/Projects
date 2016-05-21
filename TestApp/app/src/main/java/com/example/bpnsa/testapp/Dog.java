package com.example.bpnsa.testapp;

/**
 * Created by bpnsa on 5/15/16.
 */
public class Dog {


    private String name, description, lifeExp;
    private int image;
    private float rating;

    public Dog(String name, String description, String lifeExp, int image, float rating) {
        this.name = name;
        this.description = description;
        this.lifeExp = lifeExp;
        this.image = image;
        this.rating = rating;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLifeExp() {
        return lifeExp;
    }

    public int getImage() {
        return image;
    }

    public float getRating() {
        return rating;
    }


    
    
    
}
