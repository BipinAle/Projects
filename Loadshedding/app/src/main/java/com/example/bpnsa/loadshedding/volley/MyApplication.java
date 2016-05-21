package com.example.bpnsa.loadshedding.volley;

import android.app.Application;
import android.content.Context;

/**
 * Created by trees on 8/28/15.
 */
public class MyApplication extends Application
{


    private static MyApplication sInstance;
    @Override
    public void onCreate()
    {
        super.onCreate();
        sInstance=this;
    }

    public static MyApplication getInstance()
    {
        return sInstance;
    }

    public static Context getAppContext()
    {
        return sInstance.getApplicationContext();
    }
}
