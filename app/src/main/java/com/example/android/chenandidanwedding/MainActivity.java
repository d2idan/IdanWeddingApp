package com.example.android.chenandidanwedding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView stuff = (TextView) findViewById(R.id.stuff);
        stuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StuffActivity.class);
                startActivity(intent);
            }
        });

        TextView idanTextView = (TextView) findViewById(R.id.idan);
        idanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,IdanActivity.class);
                startActivity(intent);
            }
        });

        TextView chenTextView = (TextView) findViewById(R.id.chen);
        chenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChenActivity.class);
                startActivity(intent);
            }
        });
    }
}
