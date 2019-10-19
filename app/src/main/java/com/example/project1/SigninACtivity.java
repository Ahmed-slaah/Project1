package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class SigninACtivity extends AppCompatActivity {

    private EditText emaiText , passwordText ;
    private CheckBox remember;
    private SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_activity);
        sh = getPreferences(MODE_PRIVATE);
        emaiText = findViewById(R.id.editText);
        passwordText = findViewById(R.id.editText2);
        remember = findViewById(R.id.checkBox);

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences.Editor editor = sh.edit();
                   editor.putBoolean("check",remember.isChecked());
                    editor.commit();
                    Toast.makeText(SigninACtivity.this, "CHECKED...", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(SigninACtivity.this, "UNCHECKED...", Toast.LENGTH_SHORT).show();

                } }
        });
    }

    public void login(View view) {
        Intent i = new Intent(SigninACtivity.this,MyprofileActivity.class);
        startActivity(i);
    }
    @Override
    protected void onStart() {
        super.onStart();
        boolean check = sh.getBoolean("check",false);
        if (check){
            SharedPreferences.Editor editor = sh.edit();
            editor.putBoolean("check",remember.isChecked());
            editor.commit();
            Intent i = new Intent(SigninACtivity.this,MyprofileActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(SigninACtivity.this, "UNCHECKED...", Toast.LENGTH_SHORT).show();
        }
    }
}
