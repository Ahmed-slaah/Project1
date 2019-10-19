package com.example.project1.dpUpdate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.project1.UpdateActivity;

public class Updatehelper extends SQLiteOpenHelper {
    public Updatehelper( Context context) {
        super(context,dbUpdateData.DB_NAME , null, dbUpdateData.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dp) {

        String sql = "create table "+dbUpdateData.TABLE_NAME+" ( "+dbUpdateData.COL_ID+" integer primary key autoincrement, "+dbUpdateData.COL_NAME+" text, "+dbUpdateData.COL_START+" text, "+dbUpdateData.COL_END+" text ) ";
        //String sql = "create table update "+dbUpdateData.TABLE_NAME+" ( "+dbUpdateData.COL_NAME+" integer primary key autoincrement, "+dbUpdateData.COL_START+" text , "+dbUpdateData.COL_END+" text )";
        dp.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int i, int i1) {
        String sql = "drop table update" +dbUpdateData.TABLE_NAME;

        dp.execSQL(sql);
        onCreate(dp);


    }
}
