package com.example.bpnsa.recyclerwithinrecycler;

import android.support.v7.widget.RecyclerView;

/**
 * Created by bpnsa on 5/18/16.
 */
public class SingleRow {
    int image;
    String name;


    public SingleRow(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
