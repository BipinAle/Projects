package com.example.bpnsa.testapp;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by bpnsa on 5/15/16.
 */
public class Metadata {

    public static ArrayList<Dog> getDogs(Context context) {
        int[] images = {R.drawable.shadow, R.drawable.dewey, R.drawable.buck, R.drawable.pedigree, R.drawable.oldjack, R.drawable.shadow, R.drawable.eightbelow};
        String[] description = context.getResources().getStringArray(R.array.description);
        String[] names = {"Shadow", "Brown", "Maya", "Max", "Truman", "Shorty", "Dewey", "Buck"};
        float[] rating = {4, 4.5f, 3, 4, 4.5f, 3, 4, 4.5f};
        String[] life = {"11", "13", "15", "11", "13", "15", "11", "13"};

        ArrayList<Dog> dogs = new ArrayList<>();
        for(int i=0; i<=images.length; i++){

            try {
                dogs.add(new Dog(names[i], description[i], life[i], images[i], rating[i]));
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        return dogs;
    }


}
