package com.example.bpnsa.testapp;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        DogListAdapter adapter = new DogListAdapter(this);
        recyclerView.setAdapter(adapter);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {


                String title;
                Fragment fragment;

                switch (item.getItemId())

                {
                    case R.id.home:

                        title = "Home FRagment";
                        fragment = new Home_Fragment();
                        break;


                    case R.id.setting:
                        title = "Setting";
                        fragment = new Setting_Fragment();
                        break;

                    case R.id.gallery:
                        title = "Gallery";
                        fragment = new Gallery_Fragment();
                        break;

                    default:
                        title = "default";
                        fragment = null;


                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragment).commit();
                    if (getSupportActionBar() != null)
                        getSupportActionBar().setTitle(title);
                    recyclerView.setVisibility(View.INVISIBLE);
                    drawerLayout.closeDrawers();
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                }

                return false;

            }
        });

    }


    //hamburger icon ko lagi
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


}
