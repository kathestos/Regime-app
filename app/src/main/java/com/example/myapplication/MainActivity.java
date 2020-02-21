package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;

                resultTextView.setText(result + "");
            }
        });

        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("org.example.myapplication.SOMETHING", "SOMETHING");
                startActivity(startIntent);
            }
        });

        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webAddress = Uri.parse(google);
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webAddress);
                if (goToGoogle.resolveActivity(getPackageManager()) != null)
                    startActivity(goToGoogle);
            }
        });

        GifImageView workOutGif = (GifImageView) findViewById(R.id.workOutGif);
        workOutGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), WorkoutActivity.class);
//                startIntent.putExtra("org.example.myapplication.SOMETHING", "WORKOUT");
                startActivity(startIntent);
            }
        });

        ImageView pushupImg = (ImageView) findViewById(R.id.pushup);
        pushupImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), WorkoutActivity.class);
//                startIntent.putExtra("org.example.myapplication.SOMETHING", "WORKOUT");
                startActivity(startIntent);
            }
        });

        ImageView legsImg = (ImageView) findViewById(R.id.legs);
        legsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), LegsActivity.class);
//                startIntent.putExtra("org.example.myapplication.SOMETHING", "WORKOUT");
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
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("org.example.myapplication.SOMETHING", "FRUIT");
                startActivity(startIntent);
            }
        });

    }

}
