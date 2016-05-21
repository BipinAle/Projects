package com.example.bpnsa.staggeredview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.riontech.staggeredtextgridview.StaggeredTextGridView;

public class MainActivity extends AppCompatActivity {
    StaggeredTextGridView staggeredTextGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
