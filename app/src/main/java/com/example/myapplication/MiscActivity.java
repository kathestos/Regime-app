package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MiscActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_misc);

        final ListView listView = findViewById(R.id.fruit_list);
        String[] values = getResources().getStringArray(R.array.misc);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ImageView imageView = findViewById(R.id.img);
            TextView textView = findViewById(R.id.txt);
            if (position == 0) {
                imageView.setImageResource(R.drawable.acai);
                textView.setText(R.string.acai_txt);
            }
            if (position == 1) {
                imageView.setImageResource(R.drawable.guarana);
                textView.setText(R.string.guarana_txt);
            }
            if (position == 2) {
                imageView.setImageResource(R.drawable.chlorella);
                textView.setText(R.string.chlorella_txt);
            }
            if (position == 3) {
                imageView.setImageResource(R.drawable.spirulina);
                textView.setText(R.string.spirulina_txt);
            }
            if (position == 4) {
                imageView.setImageResource(R.drawable.kokos);
                textView.setText(R.string.kokos_txt);
            }
            if (position == 5) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.povrce_txt);
            }
            if (position == 6) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.zacini_txt);
            }
            if (position == 7) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.cajevi_txt);
            }
            if (position == 8) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.bilje_txt);
            }
            if (position == 9) {
                imageView.setImageResource(R.drawable.kakao);
                textView.setText(R.string.kakao_txt);
            }
            if (position == 10) {
                imageView.setImageResource(R.drawable.rogac);
                textView.setText(R.string.rogac_txt);
            }
            if (position == 11) {
                imageView.setImageResource(R.drawable.nori);
                textView.setText(R.string.nori_txt);
            }
            if (position == 12) {
                imageView.setImageResource(R.drawable.wakame);
                textView.setText(R.string.wakame_txt);
            }
            if (position == 13) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.voda_txt);
            }
        });
    }
}
