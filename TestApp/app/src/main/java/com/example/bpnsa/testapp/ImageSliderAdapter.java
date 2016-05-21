package com.example.bpnsa.testapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by bpnsa on 5/5/16.
 */
public class ImageSliderAdapter extends PagerAdapter {
    private int[] images1 = {R.drawable.dewey, R.drawable.shadow, R.drawable.oldjack, R.drawable.buck,R.drawable.eightbelow};

    Context context;
    LayoutInflater inflater;

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return images1.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//validation

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = LayoutInflater.from(context);
        Toast.makeText(context, "position" + position, Toast.LENGTH_LONG).show();
        View view = inflater.inflate(R.layout.swipe_layout, container, false);//container =====>viewpager ko parenti.e. LinearLayout
        ImageView imageView1 = (ImageView) view.findViewById(R.id.swipeImage1);


        imageView1.setImageResource(images1[position]);


        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "You have clicked position" + position, Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}

