package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class DriedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_dried);

        final ListView listView = findViewById(R.id.fruit_list);

        String[] values = getResources().getStringArray(R.array.dried);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ImageView imageView = findViewById(R.id.fruit_img);
            TextView textView = findViewById(R.id.fruit_txt);
            if (position == 0) {
                imageView.setImageResource(R.drawable.datulje);
                textView.setText(R.string.datulje_suhe_txt);
            }
            if (position == 1) {
                imageView.setImageResource(R.drawable.marelice);
                textView.setText(R.string.marelice_suhe_txt);
            }
            if (position == 2) {
                imageView.setImageResource(R.drawable.suhe_sljive);
                textView.setText(R.string.sljive_suhe_txt);
            }
            if (position == 3) {
                imageView.setImageResource(R.drawable.suhe_smokve);
                textView.setText(R.string.smokve_suhe_txt);
            }
            if (position == 4) {
                imageView.setImageResource(R.drawable.grozdice);
                textView.setText(R.string.grozdice_txt);
            }
        });
    }
}
