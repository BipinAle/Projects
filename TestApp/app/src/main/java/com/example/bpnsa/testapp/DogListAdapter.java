package com.example.bpnsa.testapp;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.MineViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Dog> data = new ArrayList<>();

    public DogListAdapter(Context context) {
        this.context = context;
        this.data = Metadata.getDogs(context);
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.mainsinglerow, parent, false);//xml ko root layout ho
        return new MineViewHolder(view);

        //steps: inflate xml layout and give it to ViewHolder
    }

    @Override
    public void onBindViewHolder(MineViewHolder holder, int position) { //holder sanga xml ko View cha

        Dog dog = data.get(position);
        holder.nameView.setText(dog.getName());
        holder.imageView.setImageResource(dog.getImage());
        holder.frindlyView.setRating(dog.getRating());
        holder.lifeView.setText(dog.getLifeExp());

        holder.c_rating.setText(R.string.friendly);
        holder.c_life.setText(R.string.life);
        holder.c_name.setText(R.string.name);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView nameView, lifeView;
        RatingBar frindlyView;
        TextView c_name, c_life, c_rating;

        public MineViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            imageView = (ImageView) itemView.findViewById(R.id.mainSingleRowFoto);
            nameView = (TextView) itemView.findViewById(R.id.mainSingleRowText);
            lifeView = (TextView) itemView.findViewById(R.id.mainSingleRowLifeExpentency);
            frindlyView = (RatingBar) itemView.findViewById(R.id.mainSingleRowFriendlyStar);

            c_life = (TextView) itemView.findViewById(R.id.LifeExpentency);
            c_name = (TextView) itemView.findViewById(R.id.name);
            c_rating = (TextView) itemView.findViewById(R.id.Freindly);


        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Intent intent = new Intent(context, SubActivity.class);
            intent.putExtra("positionKey",position);
            context.startActivity(intent);


        }
    }

}
