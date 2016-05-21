package com.example.bpnsa.swipetabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Toolbar_Example extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_example);

        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }
}
