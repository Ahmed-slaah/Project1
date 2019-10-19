package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {


    private TextView emailText, password, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);
        emailText = findViewById(R.id.editText5);
        password = findViewById(R.id.editText6);
        confirm = findViewById(R.id.editText7);
    }

    private boolean validEmail() {
        String mail = emailText.getText().toString();
        if (!TextUtils.isEmpty(mail)) {
            return true;
        } else {
            emailText.setError("Email is empty");

            return true;
        }

}

    private boolean validPassword() {
        String pass = password.getText().toString();
            String conf = confirm.getText().toString();
       if (conf.equals(pass)) {
           return true;
        } else {
           confirm.setError("You must make confirm and password are same ...");

           return false;
        }
    }

    public void creat(View view) {

        if ( validEmail() && validPassword()){
            Intent i = new Intent(SignupActivity.this,MyprofileActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "TRY AGAIN ..", Toast.LENGTH_SHORT).show();
        }



    }

}