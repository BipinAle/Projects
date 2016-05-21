package com.example.bpnsa.parsingtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.bpnsa.parsingtest.volley.VolleySingleton;

import java.util.ArrayList;

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.MineViewHolder>{
    LayoutInflater inflater;
    ArrayList<BlogSingleRow> data;
    Context context;

    public BlogListAdapter(Context context) {

        inflater=LayoutInflater.from(context);
        data=new ArrayList<>();
        this.context=context;
    }



    @Override
    public BlogListAdapter.MineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.singlerowblogy, parent, false);
        return new MineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BlogListAdapter.MineViewHolder holder, int position) {
        ImageLoader loader=VolleySingleton.getInstance().getmImageLoader();
        loader.get(data.get(position).imageUrl, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                holder.imageView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        holder.titleView.setText(data.get(position).textUrl);
        holder.dateView.setText(data.get(position).date);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<BlogSingleRow> data) {
        this.data=data;
        notifyDataSetChanged();
    }



    public class MineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView dateView;
        TextView titleView;
      public MineViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView= (ImageView) itemView.findViewById(R.id.image);
            dateView= (TextView) itemView.findViewById(R.id.date);
            titleView= (TextView) itemView.findViewById(R.id.text);

        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,GalleryActivity.class);
            context.startActivity(intent);

        }
    }
}