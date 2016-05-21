package com.example.bpnsa.parsingtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.bpnsa.parsingtest.volley.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by bpnsa on 2/18/16.
 */
public class FotoCollnAdapter extends RecyclerView.Adapter<FotoCollnAdapter.MineFotoCollnViewHolder>{

    private static final String TAG = FotoCollnAdapter.class.getSimpleName();
    LayoutInflater inflater;
    private ArrayList<FotoCollnSingleRow> data;

    public FotoCollnAdapter(Context context)
    {
        inflater=LayoutInflater.from(context);
        data=new ArrayList<>();
    }


    @Override
    public FotoCollnAdapter.MineFotoCollnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.fotocollnsinglerow,parent,false);
        return new MineFotoCollnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FotoCollnAdapter.MineFotoCollnViewHolder holder, int position) {

        ImageLoader loader= VolleySingleton.getInstance().getmImageLoader();
        FotoCollnSingleRow row=data.get(position);
        String url=row.imageUrl;

        loader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

                holder.imageView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();

    }

    public void setData(ArrayList<FotoCollnSingleRow> data) {
        this.data = data;
        notifyItemRangeChanged(0, data.size());
        Log.i(TAG, "data size "+data.size());
        Log.v("bipin", "onSetData()");
    }

    public  class MineFotoCollnViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MineFotoCollnViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.fotoharu);
        }
    }
}
