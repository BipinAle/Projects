package com.example.bipin.gharbetti.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bipin.gharbetti.fragments.DueFrag;
import com.example.bipin.gharbetti.fragments.PaidFrag;
import com.example.bipin.gharbetti.R;
import com.example.bipin.gharbetti.adapters.StatusViewPagerAdapter;

import java.io.IOException;

public class HomeActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //this if case is to avoid Caused by: android.os.NetworkOnMainThreadException error

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View header = navigationView.getHeaderView(0);
        ImageView imageView= (ImageView) header.findViewById(R.id.profile_image);
        //Navigation populate garna lai Navigation vitra ko header vitra ko image,name ra email.

        String picUrl=getIntent().getStringExtra("profilePicUrl");
        Bitmap profilePic = null;
        try {
            profilePic = LoginActivity.getFacebookProfilePicture(picUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setImageBitmap(profilePic);

        TextView text = (TextView) header.findViewById(R.id.nav_name);

        SharedPreferences prefs=getSharedPreferences("FbName",MODE_PRIVATE);
        String name=prefs.getString("profileName",null);

        text.setText(name);


       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);


        if (drawerLayout != null)
            drawerLayout.addDrawerListener(actionBarDrawerToggle);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        StatusViewPagerAdapter adapter = new StatusViewPagerAdapter(getSupportFragmentManager());

        adapter.addTitleFragment(new PaidFrag(), "Paid List");
        adapter.addTitleFragment(new DueFrag(), "Due List");

        if (viewPager != null)
            viewPager.setAdapter(adapter);

        if (tabLayout != null)
            tabLayout.setupWithViewPager(viewPager);


    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
