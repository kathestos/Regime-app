package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        getSupportActionBar().hide();
        setContentView(R.layout.activity_situp);

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
                    txt.setText(getString(R.string.zagrijavanje));
                }
                if (childPosition == 1) {
                    img.setImageResource(R.drawable.apple);
                    txt.setText(getString(R.string.rastezanje));
                }


//                Toast.makeText(getApplicationContext(), getString(R.string.zagrijavanje), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void initListData() {
        listGroup.add(getString(R.string.zagrijavanje_trbuh));
        listGroup.add(getString(R.string.set1_trbuh));
        listGroup.add(getString(R.string.set2_trbuh));
        listGroup.add(getString(R.string.set3_trbuh));
        listGroup.add(getString(R.string.rastezanje_trbuh));
        listGroup.add(getString(R.string.plankovi));

        String[] array;
        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.zagrijavanje_trbuh);
        for (String item : array)
            list1.add(item);
        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.set1_trbuh);
        for (String item : array)
            list2.add(item);
        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.set2_trbuh);
        for (String item : array)
            list3.add(item);
        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.set3_trbuh);
        for (String item : array)
            list4.add(item);
        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.rastezanje_trbuh);
        for (String item : array)
            list5.add(item);
        List<String> list6 = new ArrayList<>();
        array = getResources().getStringArray(R.array.plankovi);
        for (String item : array)
            list6.add(item);

        listItem.put(listGroup.get(0), list1);
        listItem.put(listGroup.get(1), list2);
        listItem.put(listGroup.get(2), list3);
        listItem.put(listGroup.get(3), list4);
        listItem.put(listGroup.get(4), list5);
        listItem.put(listGroup.get(5), list6);
        adapter.notifyDataSetChanged();

    }

}
