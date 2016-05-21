package com.example.bpnsa.staggeredview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by bpnsa on 5/7/16.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<String> data;
    public CustomAdapter(Context context,ArrayList<String> data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {

        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.singlerow,parent);


        return view;
    }
}
