package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class AboutActivity extends AppCompatActivity {

    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        requestPermission();
        client = LocationServices.getFusedLocationProviderClient(this);

        Button button = findViewById(R.id.getLocation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(AboutActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                client.getLastLocation().addOnSuccessListener(AboutActivity.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            TextView textView = findViewById(R.id.location);
                            double lat = location.getLatitude();
                            double lon = location.getLongitude();
                            double alt = location.getAltitude();
                            long stmp = location.getTime();
                            java.util.Date time = new java.util.Date(stmp);
                            textView.setText(lat + "\n" + lon + "\n" + alt+ "\n" + time);
                        }
                    }
                });
            }
        });

        ImageView imageView6 = findViewById(R.id.imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), AiActivity.class);
                startActivity(startIntent);
            }
        });

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }

}
