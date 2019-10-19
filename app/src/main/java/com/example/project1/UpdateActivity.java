package com.example.project1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project1.dpUpdate.Updatehelper;
import com.example.project1.dpUpdate.dbUpdateData;

public class UpdateActivity extends AppCompatActivity {

    private EditText startatText,endText;
    private SQLiteDatabase dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Updatehelper helper = new Updatehelper(this);
         dp = helper.getWritableDatabase();
        startatText = findViewById(R.id.editText4);
        endText = findViewById(R.id.editText8);
    }

    public void update(View view) {

        String start = startatText.getText().toString();
        String end = endText.getText().toString();
        if (!TextUtils.isEmpty(start) && !TextUtils.isEmpty(end)){
            ContentValues values = new ContentValues();
            values.put(dbUpdateData.COL_START,start);
            values.put(dbUpdateData.COL_END,end);
            long row = dp.insert(dbUpdateData.TABLE_NAME, null, values);
            if (row>0) {
                Toast.makeText(this, "Ubdate DONE ...", Toast.LENGTH_SHORT).show();
            }
        }
            UpdateData updateData = new UpdateData(start,end);
        if (!TextUtils.isEmpty(start) && !TextUtils.isEmpty(end)){
            Intent i = new Intent(UpdateActivity.this,MyjobsActivity.class);
            i.putExtra("update",updateData);
            startActivity(i);

        }

    }
}
