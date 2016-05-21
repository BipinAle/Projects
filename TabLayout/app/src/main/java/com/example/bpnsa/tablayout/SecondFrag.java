package com.example.bpnsa.tablayout;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFrag extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;



    public SecondFrag() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      tabLayout= (TabLayout) getActivity().findViewById(R.id.tab2Layout);

        viewPager= (ViewPager) getActivity().findViewById(R.id.fragmentViewPager);
        SecondViewPagerAdapter adapter=new SecondViewPagerAdapter(getFragmentManager());

        adapter.addFragmentAndTitle(new FreeFrag(),"Free");
        adapter.addFragmentAndTitle(new TopFreeFrag(),"Top Free");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


}
