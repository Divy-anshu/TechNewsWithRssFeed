package com.divyansh.samarth.technews;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityFirst extends AppCompatActivity {
     ImageView cnet,techcrunch,techradar,dataquest,gadget360,pcquest,opensource,androidauthority;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first);
        intent = new Intent(ActivityFirst.this,MainActivity.class);
        cnet=(ImageView)findViewById(R.id.cnet);
        techcrunch = (ImageView)findViewById(R.id.techcrunch);
        techradar = (ImageView)findViewById(R.id.techradar);
        dataquest = (ImageView)findViewById(R.id.dataquest);
        gadget360 = (ImageView)findViewById(R.id.gadget360);
        pcquest = (ImageView)findViewById(R.id.pcquest);
        opensource = (ImageView)findViewById(R.id.opensource);
        androidauthority=(ImageView)findViewById(R.id.androidauthority);
        cnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("key","cnet");
                startActivity(intent);
            }
        });
        techcrunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("key","techcrunch");
                startActivity(intent);
            }
        });
        techradar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("key","techradar");
                startActivity(intent);
            }
        });
        dataquest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("key","dataquest");
                startActivity(intent);
            }
        });
        gadget360.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("key","gadget360");
                startActivity(intent);
            }
        });
        pcquest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("key","pcquest");
                startActivity(intent);
            }
        });
        opensource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("key","opensource");
                startActivity(intent);
            }
        });
        androidauthority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("key","androidauthority");
                startActivity(intent);
            }
        });

    }


}
