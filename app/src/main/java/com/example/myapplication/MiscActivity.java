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
                imageView.setImageResource(R.drawable.kokos);
                textView.setText(R.string.kokos_txt);
            }
            if (position == 1) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.povrce_txt);
            }
            if (position == 2) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.zacini_txt);
            }
            if (position == 3) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.cajevi_txt);
            }
            if (position == 4) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.bilje_txt);
            }
            if (position == 5) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.voda_txt);
            }
        });
    }
}
