package com.example.bpnsa.loadshedding;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


    public class MainActivity extends AppCompatActivity {

    private String grousname[] = {"Group 1", "Group 2", "Group 3", "Group 4", "Group 5", "Group 6", "Group 7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        for (int i = 0; i < 7; i++) {

            GroupFragment gf = new GroupFragment();
            Bundle b = new Bundle();
            b.putInt("gid", i);
            gf.setArguments(b);

            viewPagerAdapter.addFragmentAndTitle(gf, grousname[i]);
        }


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}



