package com.example.bpnsa.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by bpnsa on 5/18/16.
 */
public class SecondViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    ArrayList<String> titles=new ArrayList<>();

    public SecondViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public  void addFragmentAndTitle(Fragment fragment,String title)
    {
        fragmentArrayList.add(fragment);
        titles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
       Fragment fragment=fragmentArrayList.get(position);
        return  fragment;

    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=titles.get(position);
        return title;
    }
}
