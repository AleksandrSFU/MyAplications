package com.example.myaplications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class List_one extends AppCompatActivity {
    public Button but1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_one);
        but1 = (Button) findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                list_option();
            }
        });
    }
    public void list_option(){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        List_one.this.startActivity(myIntent);
    }
}