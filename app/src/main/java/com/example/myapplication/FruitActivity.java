package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class FruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_fruit);

        final ListView listView = findViewById(R.id.fruit_list);
        String[] values = getResources().getStringArray(R.array.fruits);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ImageView imageView = findViewById(R.id.fruit_img);
            TextView textView = findViewById(R.id.fruit_txt);
            if (position == 0) {
                imageView.setImageResource(R.drawable.banana);
                textView.setText(R.string.banane_txt);
            }
            if (position == 1) {
                imageView.setImageResource(R.drawable.jabuka);
                textView.setText(R.string.jabuke_txt);
            }
            if (position == 2) {
                imageView.setImageResource(R.drawable.kruska);
                textView.setText(R.string.kruske_txt);
            }
            if (position == 3) {
                imageView.setImageResource(R.drawable.naranca);
                textView.setText(R.string.narance_txt);
            }
            if (position == 4) {
                imageView.setImageResource(R.drawable.mandarina);
                textView.setText(R.string.mandarine_txt);
            }
            if (position == 5) {
                imageView.setImageResource(R.drawable.klementina);
                textView.setText(R.string.klementine_txt);
            }
            if (position == 6) {
                imageView.setImageResource(R.drawable.ananas);
                textView.setText(R.string.ananas_txt);
            }
            if (position == 7) {
                imageView.setImageResource(R.drawable.grozde);
                textView.setText(R.string.grozde_txt);
            }
            if (position == 8) {
                imageView.setImageResource(R.drawable.breskva);
                textView.setText(R.string.breskve_txt);
            }
            if (position == 9) {
                imageView.setImageResource(R.drawable.nektarina);
                textView.setText(R.string.nektarine_txt);
            }
            if (position == 10) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.marelice_txt);
            }
            if (position == 11) {
                imageView.setImageResource(R.drawable.sljiva);
                textView.setText(R.string.sljive_txt);
            }
            if (position == 12) {
                imageView.setImageResource(R.drawable.lubenica);
                textView.setText(R.string.lubenice_txt);
            }
            if (position == 13) {
                imageView.setImageResource(R.drawable.dinja);
                textView.setText(R.string.dinje_txt);
            }
            if (position == 14) {
                imageView.setImageResource(R.drawable.jagoda);
                textView.setText(R.string.jagode_txt);
            }
            if (position == 15) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.smokve_txt);
            }
            if (position == 16) {
                imageView.setImageResource(R.drawable.svjeze_datulje);
                textView.setText(R.string.datulje_txt);
            }
            if (position == 17) {
                imageView.setImageResource(R.drawable.mango);
                textView.setText(R.string.mango_txt);
            }
            if (position == 18) {
                imageView.setImageResource(R.drawable.papaja);
                textView.setText(R.string.papaja_txt);
            }
            if (position == 19) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.kaki_txt);
            }
            if (position == 20) {
                imageView.setImageResource(R.drawable.kivi);
                textView.setText(R.string.kivi_txt);
            }
            if (position == 21) {
                imageView.setImageResource(R.drawable.sipak);
                textView.setText(R.string.sipak_txt);
            }
        });
    }
}
