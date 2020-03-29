package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class NutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_nuts);

        final ListView listView = findViewById(R.id.fruit_list);

        String[] values = getResources().getStringArray(R.array.nuts);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ImageView imageView = findViewById(R.id.fruit_img);
            TextView textView = findViewById(R.id.fruit_txt);
            if (position == 0) {
                imageView.setImageResource(R.drawable.orah);
                textView.setText(R.string.orasi_txt);
            }
            if (position == 1) {
                imageView.setImageResource(R.drawable.badem);
                textView.setText(R.string.bademi_txt);
            }
            if (position == 2) {
                imageView.setImageResource(R.drawable.brazilski);
                textView.setText(R.string.brazilski_txt);
            }
            if (position == 3) {
                imageView.setImageResource(R.drawable.pistacija);
                textView.setText(R.string.pistacije_txt);
            }
            if (position == 4) {
                imageView.setImageResource(R.drawable.pecan);
                textView.setText(R.string.pekan_txt);
            }
            if (position == 5) {
                imageView.setImageResource(R.drawable.ljesnjak);
                textView.setText(R.string.lješnjak_txt);
            }
            if (position == 6) {
                imageView.setImageResource(R.drawable.jpg_ph);
                textView.setText(R.string.makadamia_txt);
            }
        });
    }
}
