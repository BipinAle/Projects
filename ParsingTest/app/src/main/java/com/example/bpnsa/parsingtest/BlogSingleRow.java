package com.example.bpnsa.parsingtest;

/**
 * Created by bpnsa on 2/13/16.
 */
public class BlogSingleRow {
    String textUrl,date;
    String imageUrl;

    public BlogSingleRow(String imageUrl, String textUrl, String date) {
        this.imageUrl=imageUrl;
        this.textUrl = textUrl;
        this.date = date;
    }
}
