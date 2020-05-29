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

public class SitupActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_situp);

        expandableListView = findViewById(R.id.expandableListView);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this, listGroup, listItem);
        expandableListView.setAdapter(adapter);
        initListData();

        GifImageView gif = findViewById(R.id.gif_situp);
        TextView txt = findViewById(R.id.text);

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            if (childPosition == 0 && groupPosition == 0) {
                gif.setImageResource(R.drawable.penjac);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 0) {
                gif.setImageResource(R.drawable.penjac_unutra);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 0) {
                gif.setImageResource(R.drawable.penjac_strana);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 0) {
                gif.setImageResource(R.drawable.ptica_pas);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 1) {
                gif.setImageResource(R.drawable.stopala);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 1) {
                gif.setImageResource(R.drawable.lakat_koljeno);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 1) {
                gif.setImageResource(R.drawable.ruke_strana);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 1) {
                gif.setImageResource(R.drawable.noge_prsa);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 4 && groupPosition == 1) {
                gif.setImageResource(R.drawable.obje_noge);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 5 && groupPosition == 1) {
                gif.setImageResource(R.drawable.noge_izmjenicno);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 6 && groupPosition == 1) {
                gif.setImageResource(R.drawable.sklopka);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 7 && groupPosition == 1) {
                gif.setImageResource(R.drawable.puna_sklopka);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 8 && groupPosition == 1) {
                gif.setImageResource(R.drawable.noge_gore);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 2) {
                gif.setImageResource(R.drawable.joga1);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 2) {
                gif.setImageResource(R.drawable.joga2);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 2) {
                gif.setImageResource(R.drawable.joga3);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 2) {
                gif.setImageResource(R.drawable.joga4);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 3) {
                gif.setImageResource(R.drawable.u_stranu);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 3) {
                gif.setImageResource(R.drawable.ruka_stopalo);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 3) {
                gif.setImageResource(R.drawable.okret_ustranu);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 3) {
                gif.setImageResource(R.drawable.noge_gore_dolje);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 4 && groupPosition == 3) {
                gif.setImageResource(R.drawable.noge_unakrsno);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 5 && groupPosition == 3) {
                gif.setImageResource(R.drawable.jedna_pojedna_noga);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 6 && groupPosition == 3) {
                gif.setImageResource(R.drawable.ruke_ispred);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 7 && groupPosition == 3) {
                gif.setImageResource(R.drawable.ravno_skupa);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 8 && groupPosition == 3) {
                gif.setImageResource(R.drawable.ruke_gore);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 4) {
                gif.setImageResource(R.drawable.plank);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 4) {
                gif.setImageResource(R.drawable.lijevi_plank);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 4) {
                gif.setImageResource(R.drawable.desni_plank);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 4) {
                gif.setImageResource(R.drawable.leznjak);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 5) {
                gif.setImageResource(R.drawable.v_drzanje);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 5) {
                gif.setImageResource(R.drawable.valjanje);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 2 && groupPosition == 5) {
                gif.setImageResource(R.drawable.buba);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 3 && groupPosition == 5) {
                gif.setImageResource(R.drawable.dizanje_kukova);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 4 && groupPosition == 5) {
                gif.setImageResource(R.drawable.noge_ustranu);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 5 && groupPosition == 5) {
                gif.setImageResource(R.drawable.kruzenje_nogu);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 6 && groupPosition == 5) {
                gif.setImageResource(R.drawable.trbusnjak);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 7 && groupPosition == 5) {
                gif.setImageResource(R.drawable.ruke_gore_trbuh);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 8 && groupPosition == 5) {
                gif.setImageResource(R.drawable.bicikl);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 0 && groupPosition == 6) {
                gif.setImageResource(R.drawable.gif_ph);
                txt.setText(getString(R.string.default_txt));
            } else if (childPosition == 1 && groupPosition == 6) {
                gif.setImageResource(R.drawable.gif_ph);
                txt.setText(getString(R.string.default_txt));
            }
            return true;
        });
    }

    private void initListData() {
        listGroup.add(getString(R.string.zagrijavanje_trbuh));
        listGroup.add(getString(R.string.set1_trbuh));
        listGroup.add(getString(R.string.rastezanje_trbuh));
        listGroup.add(getString(R.string.set2_trbuh));
        listGroup.add(getString(R.string.plankovi));
        listGroup.add(getString(R.string.razno_trbuh));
        listGroup.add(getString(R.string.varijacije_trbuh));

        String[] array;
        array = getResources().getStringArray(R.array.zagrijavanje_trbuh);
        List<String> list1 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.set1_trbuh);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.rastezanje_trbuh);
        List<String> list3 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.set2_trbuh);
        List<String> list4 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.plankovi);
        List<String> list5 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.razno_trbuh);
        List<String> list6 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.varijacije_trbuh);
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
