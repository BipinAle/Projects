package com.example.bipin.gharbetti.activities;

import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bipin.gharbetti.R;
import com.example.bipin.gharbetti.adapters.ViewPagerAdapter;
import com.example.bipin.gharbetti.pojos.MonthItem;

public class TransactionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPagerAdapter adapter=new ViewPagerAdapter(this);
        ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);
        if (viewPager!=null)
        viewPager.setAdapter(adapter);

        setLinearParams();
    }

    private void setLinearParams() {
        CardView cardView= (CardView)findViewById(R.id.cardview);
        int width=getWidth();
        LinearLayout.LayoutParams params;//transaction ko linearlayout (parent of cardview)

        if (isPotrait()){
            params=new LinearLayout.LayoutParams(width-40, ViewGroup.LayoutParams.WRAP_CONTENT);

        }
        else {
            params=new LinearLayout.LayoutParams((width-40)/2, ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        if (cardView!=null)
            cardView.setLayoutParams(params);
        params.setMargins(25,20,25,20);
    }

    public int getWidth() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;

    }

    public boolean isPotrait() {
        return getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT;
    }



}
