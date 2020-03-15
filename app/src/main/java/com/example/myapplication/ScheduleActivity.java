package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ScheduleActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_schedule);

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

//                ShowItem(CatList.get(childPosition).getId());
//                String text = Integer.toString(parent.getChildAt(childPosition).get());

                ImageView img = (ImageView) findViewById(R.id.img1);
                TextView txt = (TextView) findViewById(R.id.txt1);
                if (childPosition == 0) {
                    img.setImageResource(R.drawable.narrow_grip_push_ups);
                    txt.setText(getString(R.string.zagrijavanje_ruke));
                }
                if (childPosition == 1) {
                    img.setImageResource(R.drawable.new_apple);
                    txt.setText(getString(R.string.rastezanje_ruke));
                }


//                Toast.makeText(getApplicationContext(), getString(R.string.zagrijavanje), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void initListData() {
        listGroup.add(getString(R.string.svaki_dan));
        listGroup.add(getString(R.string.dvaput_tjedno));
        listGroup.add(getString(R.string.jednom_tjedno));
        listGroup.add(getString(R.string.svaka_dva_tjedna));
        listGroup.add(getString(R.string.svaka_tri_tjedna));
        listGroup.add(getString(R.string.jednom_mjesecno));
        listGroup.add(getString(R.string.svaka_tri_mjeseca));
        listGroup.add(getString(R.string.jednom_godisnje));

        String[] array;
        array = getResources().getStringArray(R.array.svaki_dan);
        List<String> list1 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.dvaput_tjedno);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.jednom_tjedno);
        List<String> list3 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.svaka_dva_tjedna);
        List<String> list4 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.svaka_tri_tjedna);
        List<String> list5 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.jednom_mjesecno);
        List<String> list6 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.svaka_tri_mjeseca);
        List<String> list7 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.jednom_godisnje);
        List<String> list8 = new ArrayList<>(Arrays.asList(array));

        listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);
        listItem.put(listGroup.get(3), list4);
        listItem.put(listGroup.get(4), list5);
        listItem.put(listGroup.get(5), list6);
        listItem.put(listGroup.get(6), list7);
        listItem.put(listGroup.get(7), list8);
        adapter.notifyDataSetChanged();

    }

}
