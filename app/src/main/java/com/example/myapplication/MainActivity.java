package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_main);

        ImageView pushupImg = findViewById(R.id.pushup);
        pushupImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), PushupActivity.class);
//                startIntent.putExtra("org.example.myapplication.SOMETHING", "WORKOUT");
                startActivity(startIntent);
            }
        });

        ImageView legsImg = findViewById(R.id.legs);
        legsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), LegsActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView situpImg = findViewById(R.id.situp);
        situpImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SitupActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView apple = findViewById(R.id.apple);
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

        ImageView about = findViewById(R.id.logo);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView misc = findViewById(R.id.misc);
        misc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MiscActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView phi = findViewById(R.id.phi);
        phi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), PhilosophyActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView cloth = findViewById(R.id.clothes);
        cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ClothesActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView todo = findViewById(R.id.todo);
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), TodoActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView schedule = findViewById(R.id.schedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ScheduleActivity.class);
                startActivity(startIntent);
            }
        });

        ImageView skills = findViewById(R.id.skill);
        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SkillActivity.class);
                startActivity(startIntent);
            }
        });

    }

}
