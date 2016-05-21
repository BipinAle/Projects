package com.example.bpnsa.arrayfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerAdapter=new RecyclerAdapter(this,getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

    }

    private ArrayList<DataSource> getData() {
        ArrayList<DataSource> list=new ArrayList<>();
        //yo list ma Datasource ko object add gardai pathauney
        //teskolagi datasource ko object banaunu paryo
        DataSource datsource=new DataSource();
        int [] images={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        //String[] names={"Ram","Shyam","Hari"};
        String [] names=this.getResources().getStringArray(R.array.Names);
        for (int i=0;i<images.length && i<names.length;i++) {
            datsource.image = images[i];
            datsource.name = names[i];

            list.add(datsource);


        }
        return list;
    }
}