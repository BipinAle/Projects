package com.example.bpnsa.recyclerwithinrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.firstRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainAdapter adapter=new MainAdapter(this);
        recyclerView.setAdapter(adapter);




    }
}
