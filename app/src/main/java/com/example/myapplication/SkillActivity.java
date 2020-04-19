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

public class SkillActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_skill);

        expandableListView = findViewById(R.id.expandableListView);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this, listGroup, listItem);
        expandableListView.setAdapter(adapter);
        initListData();

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            TextView txt = findViewById(R.id.txt1);
            String text = Objects.requireNonNull(listItem.get(listGroup.get(groupPosition))).get(childPosition);
            txt.setText(text);
            if (childPosition == 0 && groupPosition == 0) {
//                txt.setText(getString(R.string.text_zglobovi));
            } else if (childPosition == 1 && groupPosition == 0) {
//                txt.setText(getString(R.string.text_laktovi));
            } else if (childPosition == 2 && groupPosition == 0) {
//                txt.setText(getString(R.string.text_ramena));
            }
            return true;
        });
    }

    private void initListData() {
        listGroup.add(getString(R.string.osjetila));
        listGroup.add(getString(R.string.meditacije));
        listGroup.add(getString(R.string.sjedenje_na_podu));
        listGroup.add(getString(R.string.disanje));
        listGroup.add(getString(R.string.mentalne));

        String[] array;
        array = getResources().getStringArray(R.array.osjetila);
        List<String> list1 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.meditacije);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.sjedenje_na_podu);
        List<String> list3 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.disanje);
        List<String> list4 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.mentalne);
        List<String> list5 = new ArrayList<>(Arrays.asList(array));

        listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);
        listItem.put(listGroup.get(3), list4);
        listItem.put(listGroup.get(4), list5);
        adapter.notifyDataSetChanged();
    }
}
