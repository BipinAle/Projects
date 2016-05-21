package com.example.bpnsa.recyclerwithinrecycler;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bpnsa on 5/18/16.
 */

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.MyViewHolder> {
    Context context;
    LayoutInflater inflater;

    public SubAdapter(Context context)
    {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public SubAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.single_row_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SubAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
