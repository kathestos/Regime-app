package com.example.myapplication;

import android.os.Bundle;
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

public class LegsActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_legs);

        expandableListView = findViewById(R.id.expandableListView);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this, listGroup, listItem);
        expandableListView.setAdapter(adapter);
        initListData();

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            GifImageView gif = findViewById(R.id.gif_legs);
            TextView txt = findViewById(R.id.text);
            if (childPosition == 0 && groupPosition == 0) {
                gif.setImageResource(R.drawable.step);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 0) {
                gif.setImageResource(R.drawable.noge_iza);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 0) {
                gif.setImageResource(R.drawable.noge_strana);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 0) {
                gif.setImageResource(R.drawable.noge_ispred);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 4 && groupPosition == 0) {
                gif.setImageResource(R.drawable.visoki_step);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 5 && groupPosition == 0) {
                gif.setImageResource(R.drawable.skok);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 6 && groupPosition == 0) {
                gif.setImageResource(R.drawable.van_unutra);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 7 && groupPosition == 0) {
                gif.setImageResource(R.drawable.naprijed_nazad);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 1) {
                gif.setImageResource(R.drawable.bokovi);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 1) {
                gif.setImageResource(R.drawable.koljena);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 1) {
                gif.setImageResource(R.drawable.zglob_noga);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 2) {
                gif.setImageResource(R.drawable.cucanj);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 2) {
                gif.setImageResource(R.drawable.rudar);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 2) {
                gif.setImageResource(R.drawable.prsti);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 2) {
                gif.setImageResource(R.drawable.joga6);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 3) {
                gif.setImageResource(R.drawable.spartan);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 3) {
                gif.setImageResource(R.drawable.jedna_noga);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 3) {
                gif.setImageResource(R.drawable.noga_gore);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 3) {
                gif.setImageResource(R.drawable.warrior);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 4) {
                gif.setImageResource(R.drawable.cucanj_ruke_gore);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 4) {
                gif.setImageResource(R.drawable.rudar_iza);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 4) {
                gif.setImageResource(R.drawable.noga_strana);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 4) {
                gif.setImageResource(R.drawable.drzanje_noge);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 5) {
                gif.setImageResource(R.drawable.istezanje_strana);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 5) {
                gif.setImageResource(R.drawable.istezanje_naprijed);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 5) {
                gif.setImageResource(R.drawable.zenska_spaga);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 5) {
                gif.setImageResource(R.drawable.muska_spaga);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 6) {
                gif.setImageResource(R.drawable.do_dolje);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 6) {
                gif.setImageResource(R.drawable.joga5);
                txt.setText(getString(R.string.default_txt));
            }
            return true;
        });
    }

    private void initListData() {
        listGroup.add(getString(R.string.zagrijavanje_noge));
        listGroup.add(getString(R.string.razgibavanje_noge));
        listGroup.add(getString(R.string.set1_noge));
        listGroup.add(getString(R.string.set2_noge));
        listGroup.add(getString(R.string.set3_noge));
        listGroup.add(getString(R.string.rastezanje_noge));
        listGroup.add(getString(R.string.varijacije_noge));

        String[] array;
        array = getResources().getStringArray(R.array.zagrijavanje_noge);
        List<String> list1 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.razgibavanje_noge);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.set1_noge);
        List<String> list3 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.set2_noge);
        List<String> list4 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.set3_noge);
        List<String> list5 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.rastezanje_noge);
        List<String> list6 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.varijacije_noge);
        List<String> list7 = new ArrayList<>(Arrays.asList(array));

        listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);
        listItem.put(listGroup.get(3), list4);
        listItem.put(listGroup.get(4), list5);
        listItem.put(listGroup.get(5), list6);
        listItem.put(listGroup.get(6), list7);
        adapter.notifyDataSetChanged();

    }

}
