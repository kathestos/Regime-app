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
        getSupportActionBar().hide();
        setContentView(R.layout.activity_legs);

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
