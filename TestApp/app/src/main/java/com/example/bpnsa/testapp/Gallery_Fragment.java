package com.example.bpnsa.testapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gallery_Fragment extends Fragment {
    ViewPager viewPager1;
    ImageSliderAdapter adapter;



    public Gallery_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_gallery, container, false);

        return  view;

    }

    @Override  //fragment ma add garna lai (onActivityCreated ) override garnu parcha
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager1= (ViewPager) getActivity().findViewById(R.id.viewPager1);
        adapter=new ImageSliderAdapter(getActivity());
        viewPager1.setAdapter(adapter);

           }
}
