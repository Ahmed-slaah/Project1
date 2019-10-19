package com.example.project1.dbAdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.project1.dpUpdate.dbUpdateData;

public class Addhelper extends SQLiteOpenHelper {
    public Addhelper( Context context) {
        super(context, dpAddData.DB_NAME, null, dpAddData.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dp) {
        String sql = "create table add" + dpAddData.TABLE_NAME+" ( "+dpAddData.COL_NAME+" integer primary key autoincrement, "+dpAddData.COL_START+" text , "+dpAddData.COL_END+" text )";
        dp.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int i, int i1) {
        String sql = "drop table add" +dpAddData.TABLE_NAME;
        dp.execSQL(sql);
        onCreate(dp);

    }
}
