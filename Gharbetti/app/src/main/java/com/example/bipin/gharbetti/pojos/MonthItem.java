package com.example.bipin.gharbetti.pojos;

/**
 * Created by bipin on 6/12/16.
 */
public class MonthItem {

    private String month;
    private int batti, pani, fohor, extras;

    public MonthItem(String month, int batti, int pani, int fohor, int extras) {
        this.month = month;
        this.batti = batti;
        this.pani = pani;
        this.fohor = fohor;
        this.extras = extras;
    }

    public String getMonth() {
        return month;
    }

    public int getBatti() {
        return batti;
    }

    public int getPani() {
        return pani;
    }

    public int getFohor() {
        return fohor;
    }

    public int getExtras() {
        return extras;
    }

    public int getTotal(){

        return  batti + pani + fohor + extras;
    }

    public int getBattiPer(){

        return (batti*100)/getTotal();
    }

    public int getPaniPer(){

        return (pani*100)/getTotal();
    }


    public int getFohorPer(){

        return (fohor*100)/getTotal();
    }

    public int getExtraPer(){

        return (extras*100)/getTotal();
    }

}
