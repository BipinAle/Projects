package com.example.bipin.gharbetti.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by bipin on 6/8/16.
 */
public class StatusViewPagerAdapter extends FragmentStatePagerAdapter {

  ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> titles=new ArrayList<>();


    public void addTitleFragment(Fragment fragment,String title)
    {
        fragments.add(fragment);
        titles.add(title);



    }
    public StatusViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);

    }
}
