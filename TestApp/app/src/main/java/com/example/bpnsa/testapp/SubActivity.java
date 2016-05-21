package com.example.bpnsa.testapp;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    ImageView imageView;
    TextView descriptionView;
    TextView nameView;
    Toolbar toolbar;
    ArrayList<Dog> dogs=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        dogs=Metadata.getDogs(this);



        imageView= (ImageView) findViewById(R.id.individualPic);
        nameView= (TextView) findViewById(R.id.individualName);
        descriptionView= (TextView) findViewById(R.id.individualDescription);


        if(getSupportActionBar()!=null) {
            setSupportActionBar(toolbar);
           getSupportActionBar().setDisplayShowHomeEnabled(true);

        }


        Intent intent=getIntent();
        int position=intent.getIntExtra("positionKey", 0);
        Dog  dog=dogs.get(position);
        Toast.makeText(this,"position"+position,Toast.LENGTH_LONG).show();
        nameView.setText(dog.getName());
        imageView.setImageResource(dog.getImage());
        descriptionView.setText(dog.getDescription());






    }
}
