package com.example.bpnsa.loadshedding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by bpnsa on 5/19/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> titles=new ArrayList<>();


    public void addFragmentAndTitle(Fragment fragment,String title)
    {
        fragments.add(fragment);
        titles.add(title);



    }



    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=fragments.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {


        String title=titles.get(position);
        return title;
    }
}
