package com.example.bipin.gharbetti.pojos;

/**
 * Created by bipin on 6/12/16.
 */
public class SummaryItem {

    public SummaryItem(String name, int roomNo, int total) {

        this.name = name;
        this.roomNo = roomNo;
        this.total = total;
    }

    String name;
    int roomNo,total;

    public String getName() {
        return name;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getTotal() {
        return total;
    }


}
