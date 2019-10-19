package com.example.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button2);

    }

    public void signin(View view) {
        Intent i = new Intent(MainActivity.this,SigninACtivity.class);
        startActivity(i);
    }


    public void signup(View view) {
        Intent i = new Intent(MainActivity.this,SignupActivity.class);
        startActivity(i);
    }

    public void btn(View view) {
        Intent i = new Intent(MainActivity.this,MyjobsActivity.class);
        startActivity(i);
    }
}
