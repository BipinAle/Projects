package com.example.bpnsa.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

/**
 * Created by bpnsa on 5/3/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragmentList=new ArrayList<>();
    ArrayList<String> tabTitlesList=new ArrayList<>();

    //add fragments and titles in these list
    public void addFragAndTitles(Fragment fragments,String titles)
    {
        fragmentList.add(fragments);
        tabTitlesList.add(titles);

    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);


    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=fragmentList.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        int fragmentCount=fragmentList.size();
        return fragmentCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       String title= tabTitlesList.get(position);
        return title;
    }
}
