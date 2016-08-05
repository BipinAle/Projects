package com.example.bipin.gharbetti.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bipin.gharbetti.R;
import com.example.bipin.gharbetti.activities.LoginActivity;
import com.example.bipin.gharbetti.activities.TransactionActivity;
import com.example.bipin.gharbetti.pojos.SummaryItem;

import java.util.ArrayList;

/**
 * Created by bipin on 6/8/16.
 */
public class PaidListAdapter extends RecyclerView.Adapter<PaidListAdapter.MyViewHolder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<SummaryItem> data=new ArrayList<>();


    public PaidListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);

    }

    public void setData(ArrayList<SummaryItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }



    @Override
    public PaidListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.individuallist, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PaidListAdapter.MyViewHolder holder, int position)  {

      holder.roomNo.setText(data.get(position).getRoomNo()+"");
        holder.total.setText(data.get(position).getTotal()+"");
        holder.name.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView roomNo,name,total;
        public MyViewHolder(View itemView) {
            super(itemView);

            roomNo= (TextView) itemView.findViewById(R.id.roomId);
            name= (TextView) itemView.findViewById(R.id.nameId);
            total= (TextView) itemView.findViewById(R.id.totalId);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            //int pos=getAdapterPosition();
            Intent intent = new Intent(context, TransactionActivity.class);
           // intent.putExtra("positionKey",pos);
            context.startActivity(intent);

        }
    }
}
