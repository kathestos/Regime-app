package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class TodoActivity extends AppCompatActivity {

    SharedPreferences sp;

    ArrayList<Integer> playlist = new ArrayList<>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_todo);

        final ListView listView = findViewById(R.id.fruit_list);
        TextView txt = findViewById(R.id.txt);

        String[] values = getResources().getStringArray(R.array.todo);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String itemValue = (String) listView.getItemAtPosition(position);
            txt.setText(itemValue);
        });

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        NumberPicker orahPick = findViewById(R.id.pickerOrah);
        TextView orahText = findViewById(R.id.textOrah);
        String[] orasi = getResources().getStringArray(R.array.nuts);
        orahPick.setMinValue(0);
        orahPick.setMaxValue(orasi.length - 1);
        orahPick.setDisplayedValues(orasi);

        orahPick.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            int foodNumber = orahPick.getValue();
            orahText.setText(orasi[foodNumber]);
            editor.putInt("orah", foodNumber);
            editor.apply();
        });

        NumberPicker sjemenkePick = findViewById(R.id.pickerSjemenke);
        TextView sjemenkeText = findViewById(R.id.textSjemenke);
        String[] sjemenke = getResources().getStringArray(R.array.seeds);
        sjemenkePick.setMinValue(0);
        sjemenkePick.setMaxValue(sjemenke.length - 1);
        sjemenkePick.setDisplayedValues(sjemenke);

        sjemenkePick.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            int foodNumber = sjemenkePick.getValue();
            sjemenkeText.setText(sjemenke[foodNumber]);
            editor.putInt("sjemenke", foodNumber);
            editor.apply();
        });

        NumberPicker suhoPick = findViewById(R.id.pickerSuho);
        TextView suhoText = findViewById(R.id.textSuho);
        String[] suho = getResources().getStringArray(R.array.dried);
        suhoPick.setMinValue(0);
        suhoPick.setMaxValue(suho.length - 1);
        suhoPick.setDisplayedValues(suho);

        suhoPick.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            int foodNumber = suhoPick.getValue();
            suhoText.setText(suho[foodNumber]);
            editor.putInt("suho", foodNumber);
            editor.apply();
        });

        SharedPreferences sp2 = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        int orahNum = sp2.getInt("orah", 0);
        String savedOrah = orasi[orahNum];
        orahText.setText(savedOrah);
        orahPick.setValue(orahNum);

        int sjemenkeNum = sp2.getInt("sjemenke", 0);
        String savedSjemenke = sjemenke[sjemenkeNum];
        sjemenkeText.setText(savedSjemenke);
        sjemenkePick.setValue(sjemenkeNum);

        int suhoNum = sp2.getInt("suho", 0);
        String savedSuho = suho[suhoNum];
        suhoText.setText(savedSuho);
        suhoPick.setValue(suhoNum);

//        SOUNDS EXPERIMENT

        Button generate = findViewById(R.id.generateMp3);
        Button play = findViewById(R.id.playMp3);
        Button pause = findViewById(R.id.pauseMp3);

        playlist.add(R.raw.norm_sklek);
        playlist.add(R.raw.prvi);
        playlist.add(R.raw.drugi);
        playlist.add(R.raw.treci);
        playlist.add(R.raw.norm_sklek);

        play.setOnClickListener(v -> playNext(pause));

    }

    void playNext(Button pause) {
        if (i < playlist.size()) {
            MediaPlayer mp = MediaPlayer.create(this, playlist.get(i++));
            mp.start();
            mp.setOnCompletionListener(vv -> playNext(pause));
            pausePlay(pause, mp);
        }
    }

    void pausePlay(Button pause, MediaPlayer mp) {
        pause.setOnClickListener(vv -> {
            mp.pause();
            pause.setText("cont");
            pause.setOnClickListener(vvv -> {
                mp.start();
                pause.setText("pause");
                pausePlay(pause, mp);
            });
        });
    }

}
