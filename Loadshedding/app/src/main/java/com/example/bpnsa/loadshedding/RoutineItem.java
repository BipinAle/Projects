package com.example.bpnsa.loadshedding;

/**
 * Created by bpnsa on 5/19/16.
 */
public class RoutineItem {

    private  String group,day,time1, time2;

    public RoutineItem(String group, String day, String time1, String time2) {
        this.group = group;
        this.day = day;
        this.time1 = time1;
        this.time2=time2;
    }


    public String getGroup() {
        return group;
    }

    public String getDay() {
        return day;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }
}
