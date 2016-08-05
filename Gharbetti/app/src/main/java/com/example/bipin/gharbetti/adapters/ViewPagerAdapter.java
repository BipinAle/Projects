package com.example.bipin.gharbetti.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bipin.gharbetti.R;
import com.example.bipin.gharbetti.pojos.MonthItem;

import java.util.ArrayList;

/**
 * Created by bipin on 6/10/16.
 */
public class ViewPagerAdapter extends PagerAdapter {

    ArrayList<MonthItem> months = new ArrayList<>();

    Context context;


    public ViewPagerAdapter(Context context) {
        this.context = context;
        months.add(new MonthItem("Jan", 100, 68, 23, 23));
        months.add(new MonthItem("Feb", 34, 32, 23, 23));
        months.add(new MonthItem("Mar", 456, 4, 23, 5));
        months.add(new MonthItem("Apr", 56, 76, 23, 63));
        months.add(new MonthItem("May", 78, 32, 45, 23));
        months.add(new MonthItem("Jun", 99, 38, 23, 23));
        months.add(new MonthItem("Jul", 10, 32, 6, 23));
        months.add(new MonthItem("Aug", 90, 98, 23, 67));
        months.add(new MonthItem("Sep", 56, 32, 23, 23));
        months.add(new MonthItem("Oct", 98, 56, 67, 98));
        months.add(new MonthItem("Nov", 3, 12, 23, 23));
        months.add(new MonthItem("Dec", 3, 97, 23, 23));
    }

    @Override
    public int getCount() {
        return months.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Log.i("debug", " on InstansiateItem");
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.month_card, container, false);

        MonthItem monthItem = months.get(position);

        ViewHolder holder = new ViewHolder(view);
        holder.month.setText(monthItem.getMonth());
        holder.batti.setText(monthItem.getBatti()+"");
        holder.fohor.setText(monthItem.getFohor()+"");
        holder.extra.setText(monthItem.getExtras()+"");
        holder.pani.setText(monthItem.getPani()+"");
        holder.total.setText(monthItem.getTotal()+"");
        holder.battiPer.setText(monthItem.getBattiPer()+"%");
        holder.fohorPer.setText(monthItem.getFohorPer()+"%");
        holder.paniPer.setText(monthItem.getPaniPer()+"%");
        holder.extraper.setText(monthItem.getExtraPer()+"%");

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        Log.i("debug", " on DestroyItem");
        container.removeView((View) object);
    }

    class ViewHolder {
        TextView month, fohor, batti, pani, extra,total,fohorPer,battiPer,paniPer,extraper;

        public ViewHolder(View parent) {

            month = (TextView) parent.findViewById(R.id.month);
            fohor = (TextView) parent.findViewById(R.id.fohor_ko_paisa);
            batti = (TextView) parent.findViewById(R.id.batti_ko_paisa);
            pani = (TextView) parent.findViewById(R.id.pani_ko_paisa);
            extra = (TextView) parent.findViewById(R.id.extra_ko_paisa);
            total= (TextView) parent.findViewById(R.id.total);
            fohorPer = (TextView) parent.findViewById(R.id.fohor_ko_per);
            battiPer = (TextView) parent.findViewById(R.id.batti_ko_per);
            paniPer = (TextView) parent.findViewById(R.id.pani_ko_per);
            extraper= (TextView) parent.findViewById(R.id.extra_ko_per);
        }
    }
}
