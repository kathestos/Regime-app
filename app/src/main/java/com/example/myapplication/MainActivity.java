package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        ImageView pushupImg = (ImageView) findViewById(R.id.pushup);
        pushupImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), PushupActivity.class);
//                startIntent.putExtra("org.example.myapplication.SOMETHING", "WORKOUT");
                startActivity(startIntent);
            }
        });

        ImageView legsImg = (ImageView) findViewById(R.id.legs);
        legsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), LegsActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView situpImg = (ImageView) findViewById(R.id.situp);
        situpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SitupActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView apple = (ImageView) findViewById(R.id.apple);
        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), FruitActivity.class);
                startIntent.putExtra("org.example.myapplication.SOMETHING", "FRUIT");
                startActivity(startIntent);
            }
        });

        ImageView dried = findViewById(R.id.date);
        dried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), DriedActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView nuts = findViewById(R.id.nut);
        nuts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), NutsActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView seeds = findViewById(R.id.seed);
        seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SeedsActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView berries = findViewById(R.id.berry);
        berries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), BerriesActivity.class);
                startActivity(startIntent);
            }
        });

    }

}
