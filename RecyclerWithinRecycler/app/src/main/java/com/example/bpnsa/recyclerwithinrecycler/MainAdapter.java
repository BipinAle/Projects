package com.example.bpnsa.recyclerwithinrecycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by bpnsa on 5/18/16.
 */
public class MainAdapter extends RecyclerView.Adapter <MainAdapter.MyViewHolder>{

    Context context;
    LayoutInflater inflater;



    public MainAdapter(Context context) {

        this.context = context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.mainsinglerow,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.rc.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        SubAdapter adapter=new SubAdapter(context);
        holder.rc.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rc;
        public MyViewHolder(View itemView) {
            super(itemView);
            rc= (RecyclerView) itemView.findViewById(R.id.singlerowRecyclerView);

        }
    }
}
