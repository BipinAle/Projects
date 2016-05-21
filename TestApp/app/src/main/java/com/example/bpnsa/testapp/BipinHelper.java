package com.example.bpnsa.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bpnsa on 5/16/16.
 */


public class BipinHelper extends  SQLiteOpenHelper{

    private  final static String DATABASE_NAME="bipindb";
    private  final static String DATABASE_TABLE="BIPINTABLE";
    private  final static String UID="_Id";
    private  final static String NAME="Name";
    private  final static int  DATABASE_VERSION=1;

    public BipinHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        ContentValues contentValues=new ContentValues();

        db.execSQL("CREATE TABLE "+DATABASE_TABLE+" ;");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
