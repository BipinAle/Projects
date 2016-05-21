package com.example.bpnsa.arrayfeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bpnsa on 5/3/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MineViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<DataSource> dataList=new ArrayList<>();

    //constructor define
    public RecyclerAdapter(Context context,ArrayList<DataSource> dataList) {
       inflater=LayoutInflater.from(context);
        this.dataList=dataList;
        this.context = context;
    }




    @Override
    public MineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.singlerow,parent,false);
        MineViewHolder holder=new MineViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MineViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position).name);
        holder.imageView.setImageResource(dataList.get(position).image);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MineViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MineViewHolder(View itemView) {
            super(itemView);

            imageView= (ImageView) itemView.findViewById(R.id.singleImage);
            textView= (TextView) itemView.findViewById(R.id.singleName);

        }
    }
}
