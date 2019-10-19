package com.example.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.QuickContactBadge;

import java.util.ArrayList;
import java.util.List;

public class MyprofileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile2);
        GridView list = findViewById(R.id.gridview);
        profileAdapter adapter = new profileAdapter(this,DataSource());
        list.setAdapter(adapter);
        ImageView imageView = findViewById(R.id.imageView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent(MyprofileActivity.this,MyjobsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private List<profile> DataSource() {
        int image[] = {R.drawable.job,R.drawable.inf };
        String title[] = {"My job", "My inf"};
        List<profile> content = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            content.add(new profile(image[i], title[i]));
        }
        return content;
    }
}