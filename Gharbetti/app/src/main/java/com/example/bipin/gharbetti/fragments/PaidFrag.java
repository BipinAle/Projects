package com.example.bipin.gharbetti.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bipin.gharbetti.adapters.PaidListAdapter;
import com.example.bipin.gharbetti.R;
import com.example.bipin.gharbetti.pojos.SummaryItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaidFrag extends Fragment {
    RecyclerView recyclerView;
    PaidListAdapter adapter;
    ArrayList<SummaryItem> data = new ArrayList<>();


    public PaidFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paid, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.paidRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PaidListAdapter(getContext());


        recyclerView.setAdapter(adapter);
        data.add(new SummaryItem("Hari", 1, 10000));
        data.add(new SummaryItem("Sarki", 2, 6666));
        data.add(new SummaryItem("Kaley", 3, 7655));
        data.add(new SummaryItem("Farsi", 4, 5555));
        data.add(new SummaryItem("Baun", 5, 6653));
        data.add(new SummaryItem("Ale", 6, 1234));
        data.add(new SummaryItem("Bhotia", 7, 5325));
        data.add(new SummaryItem("Jhuthey", 8, 1554));

        adapter.setData(data);


        return view;
    }


}
