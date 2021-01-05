package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SeedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_seeds);

        final ListView listView = findViewById(R.id.fruit_list);

        String[] values = getResources().getStringArray(R.array.seeds);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            ImageView imageView = findViewById(R.id.fruit_img);
            TextView textView = findViewById(R.id.fruit_txt);
            if (position == 0) {
                imageView.setImageResource(R.drawable.chia);
                textView.setText(R.string.chia_txt);
            }
            if (position == 1) {
                imageView.setImageResource(R.drawable.konoplja);
                textView.setText(R.string.konoplja_txt);
            }
            if (position == 2) {
                imageView.setImageResource(R.drawable.sezam);
                textView.setText(R.string.sezam_txt);
            }
            if (position == 3) {
                imageView.setImageResource(R.drawable.lan);
                textView.setText(R.string.lan_txt);
            }
            if (position == 4) {
                imageView.setImageResource(R.drawable.bundeva);
                textView.setText(R.string.bundeva_txt);
            }
            if (position == 5) {
                imageView.setImageResource(R.drawable.suncokret);
                textView.setText(R.string.suncokret_txt);
            }
            if (position == 6) {
                imageView.setImageResource(R.drawable.crni_kim);
                textView.setText(R.string.crni_kim_txt);
            }
            if (position == 7) {
                imageView.setImageResource(R.drawable.new_seed);
                textView.setText(R.string.mak_txt);
            }
        });
    }
}
