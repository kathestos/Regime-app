package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class BerriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_berries);

        final ListView listView = findViewById(R.id.fruit_list);
        String[] values = getResources().getStringArray(R.array.bobice);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ImageView imageView = findViewById(R.id.fruit_img);
            TextView textView = findViewById(R.id.fruit_txt);
            if (position == 0) {
                imageView.setImageResource(R.drawable.borovnice);
                textView.setText(R.string.borovnice_txt);
            }
            if (position == 1) {
                imageView.setImageResource(R.drawable.kupine);
                textView.setText(R.string.kupine_txt);
            }
            if (position == 2) {
                imageView.setImageResource(R.drawable.maline);
                textView.setText(R.string.maline_txt);
            }
            if (position == 3) {
                imageView.setImageResource(R.drawable.ribiz);
                textView.setText(R.string.ribizle_txt);
            }
            if (position == 4) {
                imageView.setImageResource(R.drawable.visnje);
                textView.setText(R.string.visnje_txt);
            }
            if (position == 5) {
                imageView.setImageResource(R.drawable.tresnje);
                textView.setText(R.string.tresnje_txt);
            }
            if (position == 6) {
                imageView.setImageResource(R.drawable.brusnice);
                textView.setText(R.string.brusnice_txt);
            }
            if (position == 7) {
                imageView.setImageResource(R.drawable.goji);
                textView.setText(R.string.goji_txt);
            }
            if (position == 8) {
                imageView.setImageResource(R.drawable.aronija);
                textView.setText(R.string.aronija_txt);
            }
            if (position == 9) {
                imageView.setImageResource(R.drawable.bijela_murva);
                textView.setText(R.string.bijela_murva_txt);
            }
        });
    }
}
