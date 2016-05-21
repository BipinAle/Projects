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

/**
 * Created by bpnsa on 2/18/16.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MineGalleryViewHolder>{
    LayoutInflater inflater;
    Context context;
    ArrayList<GallerySingleRow> data;
    public GalleryAdapter(Context  context)
    {
        inflater=LayoutInflater.from(context);
        this.context=context;
        data=new ArrayList<>();

    }

    @Override
    public GalleryAdapter.MineGalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.singlerowgallery,parent,false);

        return new MineGalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GalleryAdapter.MineGalleryViewHolder holder, int position) {
        ImageLoader loader= VolleySingleton.getInstance().getmImageLoader();
        loader.get(data.get(position).galleryUrl,
                new ImageLoader.ImageListener() {
                    @Override
                    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                            holder.gImage.setImageBitmap(response.getBitmap());

                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        holder.covertext.setText(data.get(position).galleryCover);
        holder.date.setText(data.get(position).galleryDate);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class MineGalleryViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView date,covertext;
        ImageView gImage;
        public MineGalleryViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            date= (TextView) itemView.findViewById(R.id.gallerydate);
            covertext= (TextView) itemView.findViewById(R.id.gallerytext);
            gImage= (ImageView) itemView.findViewById(R.id.galleryImage);

        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,FotoCollnActivity.class);
            context.startActivity(intent);


        }
    }
    public void setData(ArrayList<GallerySingleRow> data)
    {
        this.data=data;
        notifyDataSetChanged();
    }
}
