package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class WorkoutDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_workout_display);

        ArrayList<String> lista = getIntent().getExtras().getStringArrayList("lista");

        TextView vrijeme = findViewById(R.id.vrijeme);
        for (String temp : lista) {
            vrijeme.append(temp);
            vrijeme.append(", ");
        }
    }
}