package com.example.bpnsa.loadshedding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bpnsa on 5/20/16.
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<RoutineItem> data;

    public GroupAdapter(Context context) {

        this.context = context;
        inflater=LayoutInflater.from(context);
        data = new ArrayList<>();

    }

    public void setData(ArrayList<RoutineItem> data){

        this.data = data;
        notifyItemRangeChanged(0, data.size());
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.timerow,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.dayTv.setText(data.get(position).getDay());
        holder.timeTv.setText(data.get(position).getTime1()+"\n"+data.get(position).getTime2());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dayTv,timeTv;
        public MyViewHolder(View itemView) {
            super(itemView);

            dayTv= (TextView) itemView.findViewById(R.id.day);
            timeTv= (TextView) itemView.findViewById(R.id.time);
        }
    }
}
