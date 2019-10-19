package com.example.project1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.project1.dbAdd.Addhelper;
import com.example.project1.dbAdd.dpAddData;
import com.example.project1.dpUpdate.dbUpdateData;

import java.sql.Date;

public class AddjobActivity extends AppCompatActivity {

    private EditText editText , startDate , endDate ;
    private SQLiteDatabase dp;
    //private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjob);
        editText = findViewById(R.id.editText3);
        startDate = findViewById(R.id.editText4);
        endDate = findViewById(R.id.editText8);
        Addhelper helper = new Addhelper(this);
        dp = helper.getWritableDatabase();
       // spinner = findViewById(R.id.spinner2);
        // final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(C);
      //  final String array [] ={"comleted","waiting","started","ended"};

       // ArrayAdapter<String> adapter = new ArrayAdapter<>(AddjobActivity.this,R.layout.support_simple_spinner_dropdown_item);
        // spinner.setAdapter(adapter);
        Button add = findViewById(R.id.button5);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                String start = startDate.getText().toString();
                String end = endDate.getText().toString();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(start) && !TextUtils.isEmpty(end) ){
                    ContentValues values = new ContentValues();
                    values.put(dpAddData.COL_NAME,name);
                    values.put(dpAddData.COL_START,start);
                    values.put(dpAddData.COL_END,end);
                    long row = dp.insert(dpAddData.TABLE_NAME, null, values);
                    if (row>0) {
                        Toast.makeText(AddjobActivity.this, "DONE ...", Toast.LENGTH_SHORT).show();
                    }
                      if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(start) && !TextUtils.isEmpty(end) ) {


                    jobData data = new jobData(name, start, end);
                    Intent i = new Intent(AddjobActivity.this, MyjobsActivity.class);
                    i.putExtra("data", data);
                    startActivity(i);
                }
            }

            }
        });
    }

    //@Override
   // protected void onStart() {
    //    super.onStart();
  //  }
}
