package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import pl.droidsonroids.gif.GifImageView;

public class PushupActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_pushup);

        expandableListView = findViewById(R.id.expandableListView);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this, listGroup, listItem);
        expandableListView.setAdapter(adapter);
        initListData();

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                GifImageView gif = findViewById(R.id.gif_pushup);
                TextView txt = findViewById(R.id.text);
                if (childPosition == 0 && groupPosition == 0) {
                    gif.setImageResource(R.drawable.gif_zglob);
                    txt.setText(getString(R.string.text_zglobovi));
                }
                if (childPosition == 1 && groupPosition == 0) {
                    gif.setImageResource(R.drawable.gif_lakat);
                    txt.setText(getString(R.string.text_laktovi));
                }
                if (childPosition == 2 && groupPosition == 0) {
                    gif.setImageResource(R.drawable.gif_rame);
                    txt.setText(getString(R.string.text_ramena));
                }
                if (childPosition == 3 && groupPosition == 0) {
                    gif.setImageResource(R.drawable.gif_ruka);
                    txt.setText(getString(R.string.text_ruke));
                }
                return true;
            }
        });
    }

    private void initListData() {
        listGroup.add(getString(R.string.zagrijavanje_ruke));
        listGroup.add(getString(R.string.set1_prsa));
        listGroup.add(getString(R.string.set2_prsa));
        listGroup.add(getString(R.string.set3_prsa));
        listGroup.add(getString(R.string.rastezanje_ruke));

        String[] array;
        array = getResources().getStringArray(R.array.zagrijavanje_ruke);
        List<String> list1 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.set1_prsa);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.set2_prsa);
        List<String> list3 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.set3_prsa);
        List<String> list4 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.rastezanje_ruke);
        List<String> list5 = new ArrayList<>(Arrays.asList(array));

        listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);
        listItem.put(listGroup.get(3), list4);
        listItem.put(listGroup.get(4), list5);
        adapter.notifyDataSetChanged();

    }

}
