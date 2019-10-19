package com.example.project1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyjobsActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private TextView nameView, startView, endView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myjobs);
        nameView = findViewById(R.id.textView);
        startView = findViewById(R.id.textView5);
        endView = findViewById(R.id.textView6);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("data")) {
            jobData data = intent.getExtras().getParcelable("data");
            nameView.setText(data.getName());
            startView.setText(data.getStart());
            endView.setText(data.getEnd());
        }
        Intent intent1 = getIntent();
        if (intent != null && intent.hasExtra("update")) {
            UpdateData updateData  = intent.getExtras().getParcelable("data");
           // Toast.makeText(this, updateData.getStart()==null?"y", Toast.LENGTH_SHORT).show();
          ///////////////////// startView.setText(updateData.getstart());
            endView.setText(updateData.getEnd());
        }

        imageButton = findViewById(R.id.imageButton5);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyjobsActivity.this,AddjobActivity.class);
                startActivity(i);
            }
        });
    }

    public void edit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose ...").setIcon(R.drawable.ic_edit_black_24dp).setMessage("Choose ..!")
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent (MyjobsActivity.this,UpdateActivity.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }
}

