package com.example.bpnsa.tablayout;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragAndTitles(new FirstFrag(), "PAID");
        viewPagerAdapter.addFragAndTitles(new SecondFrag(),"NON PAID");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
