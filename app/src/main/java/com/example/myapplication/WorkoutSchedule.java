package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Objects;

public class WorkoutSchedule extends AppCompatActivity {

    ArrayList<Integer> playlist = new ArrayList<>();
    ArrayList<String> lista = new ArrayList<>();
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_workout_schedule);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        NumberPicker zagrijavanjePrsa = findViewById(R.id.zagrijavanje_prsa);
        String[] zagrijavanjePrsaList = getResources().getStringArray(R.array.zagrijavanje_ruke);
        zagrijavanjePrsa.setMinValue(0);
        zagrijavanjePrsa.setMaxValue(zagrijavanjePrsaList.length - 1);
        zagrijavanjePrsa.setDisplayedValues(zagrijavanjePrsaList);

        NumberPicker sklekovi = findViewById(R.id.sklekovi);
        String[] sklekoviList = getResources().getStringArray(R.array.sklekovi);
        sklekovi.setMinValue(0);
        sklekovi.setMaxValue(sklekoviList.length - 1);
        sklekovi.setDisplayedValues(sklekoviList);

        NumberPicker stangaPrsa = findViewById(R.id.prsa_stanga);
        String[] stangaPrsaList = getResources().getStringArray(R.array.stanga_ruke);
        stangaPrsa.setMinValue(0);
        stangaPrsa.setMaxValue(stangaPrsaList.length - 1);
        stangaPrsa.setDisplayedValues(stangaPrsaList);

        NumberPicker prsaVjestine = findViewById(R.id.prsa_vjestine);
        String[] prsaVjestineList = getResources().getStringArray(R.array.sklek_vjestine);
        prsaVjestine.setMinValue(0);
        prsaVjestine.setMaxValue(prsaVjestineList.length - 1);
        prsaVjestine.setDisplayedValues(prsaVjestineList);

        NumberPicker prsaStabilnost = findViewById(R.id.prsa_stabilnost);
        String[] prsaStabilnostList = getResources().getStringArray(R.array.sklek_stabilnost);
        prsaStabilnost.setMinValue(0);
        prsaStabilnost.setMaxValue(prsaStabilnostList.length - 1);
        prsaStabilnost.setDisplayedValues(prsaStabilnostList);

        NumberPicker ruke = findViewById(R.id.ruke);
        String[] rukeList = getResources().getStringArray(R.array.ruke);
        ruke.setMinValue(0);
        ruke.setMaxValue(rukeList.length - 1);
        ruke.setDisplayedValues(rukeList);

        NumberPicker sklekKretanje = findViewById(R.id.prsa_kretanje);
        String[] sklekKretanjeList = getResources().getStringArray(R.array.sklek_kretanje);
        sklekKretanje.setMinValue(0);
        sklekKretanje.setMaxValue(sklekKretanjeList.length - 1);
        sklekKretanje.setDisplayedValues(sklekKretanjeList);

        NumberPicker prsaRastezanje = findViewById(R.id.prsa_rastezanje);
        String[] prsaRastezanjeList = getResources().getStringArray(R.array.rastezanje_ruke);
        prsaRastezanje.setMinValue(0);
        prsaRastezanje.setMaxValue(prsaRastezanjeList.length - 1);
        prsaRastezanje.setDisplayedValues(prsaRastezanjeList);

        Button prsaPlusOne = findViewById(R.id.prsaPlusOne);
        prsaPlusOne.setOnClickListener(v -> {
            sklekovi.setValue(sklekovi.getValue() + 1);
            stangaPrsa.setValue(stangaPrsa.getValue() + 1);
            prsaVjestine.setValue(prsaVjestine.getValue() + 1);
            prsaStabilnost.setValue(prsaStabilnost.getValue() + 1);
            ruke.setValue(ruke.getValue() + 1);
            sklekKretanje.setValue(sklekKretanje.getValue() + 1);

            editor.putInt("sklekoviNumber", sklekovi.getValue());
            editor.putInt("stangaPrsaNumber", stangaPrsa.getValue());
            editor.putInt("prsaVjestineNumber", prsaVjestine.getValue());
            editor.putInt("prsaStabilnostNumber", prsaStabilnost.getValue());
            editor.putInt("rukeNumber", ruke.getValue());
            editor.putInt("sklekKretanjeNumber", sklekKretanje.getValue());
            editor.apply();
        });

        NumberPicker zagrijavanjeNoge = findViewById(R.id.zagrijavanje_noge);
        String[] zagrijavanjeNogeList = getResources().getStringArray(R.array.zagrijavanje_noge);
        String[] razgibavanjeNogeList = getResources().getStringArray(R.array.razgibavanje_noge);
        String[] objeNoge = ArrayUtils.concat(zagrijavanjeNogeList, razgibavanjeNogeList);
        zagrijavanjeNoge.setMinValue(0);
        zagrijavanjeNoge.setMaxValue(objeNoge.length - 1);
        zagrijavanjeNoge.setDisplayedValues(objeNoge);

        NumberPicker cucnjevi = findViewById(R.id.cucnjevi);
        String[] cucnjeviList = getResources().getStringArray(R.array.cucnjevi);
        cucnjevi.setMinValue(0);
        cucnjevi.setMaxValue(cucnjeviList.length - 1);
        cucnjevi.setDisplayedValues(cucnjeviList);

        NumberPicker rudari = findViewById(R.id.rudari);
        String[] rudariList = getResources().getStringArray(R.array.rudari);
        rudari.setMinValue(0);
        rudari.setMaxValue(rudariList.length - 1);
        rudari.setDisplayedValues(rudariList);

        NumberPicker raznoNoge = findViewById(R.id.razno_noge);
        String[] raznoNogeList = getResources().getStringArray(R.array.razno_noge);
        raznoNoge.setMinValue(0);
        raznoNoge.setMaxValue(raznoNogeList.length - 1);
        raznoNoge.setDisplayedValues(raznoNogeList);

        NumberPicker stabilnostNoge = findViewById(R.id.stabilnost_noge);
        String[] stabilnostNogeList = getResources().getStringArray(R.array.stabilnost_noge);
        stabilnostNoge.setMinValue(0);
        stabilnostNoge.setMaxValue(stabilnostNogeList.length - 1);
        stabilnostNoge.setDisplayedValues(stabilnostNogeList);

        NumberPicker noge = findViewById(R.id.noge);
        String[] nogeList = getResources().getStringArray(R.array.noge);
        noge.setMinValue(0);
        noge.setMaxValue(nogeList.length - 1);
        noge.setDisplayedValues(nogeList);

        NumberPicker kretanjeNoge = findViewById(R.id.kretanje_noge);
        String[] kretanjeNogeList = getResources().getStringArray(R.array.kretanje_noge);
        kretanjeNoge.setMinValue(0);
        kretanjeNoge.setMaxValue(kretanjeNogeList.length - 1);
        kretanjeNoge.setDisplayedValues(kretanjeNogeList);

        NumberPicker rastezanjeNoge = findViewById(R.id.rastezanje_noge);
        String[] rastezanjeNogeList = getResources().getStringArray(R.array.rastezanje_noge);
        rastezanjeNoge.setMinValue(0);
        rastezanjeNoge.setMaxValue(rastezanjeNogeList.length - 1);
        rastezanjeNoge.setDisplayedValues(rastezanjeNogeList);

        Button nogePlusOne = findViewById(R.id.nogePlusOne);
        nogePlusOne.setOnClickListener(v -> {
            cucnjevi.setValue(cucnjevi.getValue() + 1);
            rudari.setValue(rudari.getValue() + 1);
            raznoNoge.setValue(raznoNoge.getValue() + 1);
            stabilnostNoge.setValue(stabilnostNoge.getValue() + 1);
            noge.setValue(noge.getValue() + 1);
            kretanjeNoge.setValue(kretanjeNoge.getValue() + 1);

            editor.putInt("cucnjeviNumber", cucnjevi.getValue());
            editor.putInt("rudariNumber", rudari.getValue());
            editor.putInt("raznoNogeNumber", raznoNoge.getValue());
            editor.putInt("stabilnostNogeNumber", stabilnostNoge.getValue());
            editor.putInt("nogeNumber", noge.getValue());
            editor.putInt("kretanjeNogeNumber", kretanjeNoge.getValue());
            editor.apply();
        });

        NumberPicker zagrijavanjeTrbuh = findViewById(R.id.zagrijavanje_trbuh);
        String[] zagrijavanjeTrbuhList = getResources().getStringArray(R.array.zagrijavanje_trbuh);
        zagrijavanjeTrbuh.setMinValue(0);
        zagrijavanjeTrbuh.setMaxValue(zagrijavanjeTrbuhList.length - 1);
        zagrijavanjeTrbuh.setDisplayedValues(zagrijavanjeTrbuhList);

        NumberPicker trbuhStrana = findViewById(R.id.trbuh_strana);
        String[] trbuhStranaList = getResources().getStringArray(R.array.trbuh_strana);
        trbuhStrana.setMinValue(0);
        trbuhStrana.setMaxValue(trbuhStranaList.length - 1);
        trbuhStrana.setDisplayedValues(trbuhStranaList);

        NumberPicker trbuhDolje = findViewById(R.id.trbuh_dolje);
        String[] trbuhDoljeList = getResources().getStringArray(R.array.trbuh_dolje);
        trbuhDolje.setMinValue(0);
        trbuhDolje.setMaxValue(trbuhDoljeList.length - 1);
        trbuhDolje.setDisplayedValues(trbuhDoljeList);

        NumberPicker trbuhGore = findViewById(R.id.trbuh_gore);
        String[] trbuhGoreList = getResources().getStringArray(R.array.trbuh_gore);
        trbuhGore.setMinValue(0);
        trbuhGore.setMaxValue(trbuhGoreList.length - 1);
        trbuhGore.setDisplayedValues(trbuhGoreList);

        NumberPicker plank = findViewById(R.id.plank);
        String[] plankList = getResources().getStringArray(R.array.plank);
        plank.setMinValue(0);
        plank.setMaxValue(plankList.length - 1);
        plank.setDisplayedValues(plankList);

        NumberPicker trbuhStanga = findViewById(R.id.trbuh_stanga);
        String[] trbuhStangaList = getResources().getStringArray(R.array.trbuh_stanga);
        trbuhStanga.setMinValue(0);
        trbuhStanga.setMaxValue(trbuhStangaList.length - 1);
        trbuhStanga.setDisplayedValues(trbuhStangaList);

        NumberPicker trbuhRazno = findViewById(R.id.trbuh_razno);
        String[] trbuhRaznoList = getResources().getStringArray(R.array.trbuh_razno);
        trbuhRazno.setMinValue(0);
        trbuhRazno.setMaxValue(trbuhRaznoList.length - 1);
        trbuhRazno.setDisplayedValues(trbuhRaznoList);

        NumberPicker rastezanjeTrbuh = findViewById(R.id.rastezanje_trbuh);
        String[] rastezanjeTrbuhList = getResources().getStringArray(R.array.rastezanje_trbuh);
        rastezanjeTrbuh.setMinValue(0);
        rastezanjeTrbuh.setMaxValue(rastezanjeTrbuhList.length - 1);
        rastezanjeTrbuh.setDisplayedValues(rastezanjeTrbuhList);

        Button trbuhPlusOne = findViewById(R.id.trbuhPlusOne);
        trbuhPlusOne.setOnClickListener(v -> {
            trbuhStrana.setValue(trbuhStrana.getValue() + 1);
            trbuhDolje.setValue(trbuhDolje.getValue() + 1);
            trbuhGore.setValue(trbuhGore.getValue() + 1);
            plank.setValue(plank.getValue() + 1);
            trbuhStanga.setValue(trbuhStanga.getValue() + 1);
            trbuhRazno.setValue(trbuhRazno.getValue() + 1);

            editor.putInt("trbuhStranaNumber", trbuhStrana.getValue());
            editor.putInt("trbuhDoljeNumber", trbuhDolje.getValue());
            editor.putInt("trbuhGoreNumber", trbuhGore.getValue());
            editor.putInt("plankNumber", plank.getValue());
            editor.putInt("trbuhStangaNumber", trbuhStanga.getValue());
            editor.putInt("trbuhRaznoNumber", trbuhRazno.getValue());
            editor.apply();
        });

        sklekovi.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("sklekoviNumber", sklekovi.getValue());
            editor.apply();
        });
        stangaPrsa.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("stangaPrsaNumber", stangaPrsa.getValue());
            editor.apply();
        });
        prsaVjestine.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("prsaVjestineNumber", prsaVjestine.getValue());
            editor.apply();
        });
        prsaStabilnost.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("prsaStabilnostNumber", prsaStabilnost.getValue());
            editor.apply();
        });
        ruke.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("rukeNumber", ruke.getValue());
            editor.apply();
        });
        sklekKretanje.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("sklekKretanjeNumber", sklekKretanje.getValue());
            editor.apply();
        });

        cucnjevi.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("cucnjeviNumber", cucnjevi.getValue());
            editor.apply();
        });
        rudari.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("rudariNumber", rudari.getValue());
            editor.apply();
        });
        raznoNoge.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("raznoNogeNumber", raznoNoge.getValue());
            editor.apply();
        });
        stabilnostNoge.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("stabilnostNogeNumber", stabilnostNoge.getValue());
            editor.apply();
        });
        noge.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("nogeNumber", noge.getValue());
            editor.apply();
        });
        kretanjeNoge.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("kretanjeNogeNumber", kretanjeNoge.getValue());
            editor.apply();
        });

        trbuhStrana.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("trbuhStranaNumber", trbuhStrana.getValue());
            editor.apply();
        });
        trbuhDolje.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("trbuhDoljeNumber", trbuhDolje.getValue());
            editor.apply();
        });
        trbuhGore.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("trbuhGoreNumber", trbuhGore.getValue());
            editor.apply();
        });
        plank.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("plankNumber", plank.getValue());
            editor.apply();
        });
        trbuhStanga.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("trbuhStangaNumber", trbuhStanga.getValue());
            editor.apply();
        });
        trbuhRazno.setOnValueChangedListener((numberPicker, oldValue, newValue) -> {
            editor.putInt("trbuhRaznoNumber", trbuhRazno.getValue());
            editor.apply();
        });

        SharedPreferences sp2 = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        sklekovi.setValue(sp2.getInt("sklekoviNumber", 0));
        stangaPrsa.setValue(sp2.getInt("stangaPrsaNumber", 0));
        prsaVjestine.setValue(sp2.getInt("prsaVjestineNumber", 0));
        prsaStabilnost.setValue(sp2.getInt("prsaStabilnostNumber", 0));
        ruke.setValue(sp2.getInt("rukeNumber", 0));
        sklekKretanje.setValue(sp2.getInt("sklekKretanjeNumber", 0));

        cucnjevi.setValue(sp2.getInt("cucnjeviNumber", 0));
        rudari.setValue(sp2.getInt("rudariNumber", 0));
        raznoNoge.setValue(sp2.getInt("raznoNogeNumber", 0));
        stabilnostNoge.setValue(sp2.getInt("stabilnostNogeNumber", 0));
        noge.setValue(sp2.getInt("nogeNumber", 0));
        kretanjeNoge.setValue(sp2.getInt("kretanjeNogeNumber", 0));

        trbuhStrana.setValue(sp2.getInt("trbuhStranaNumber", 0));
        trbuhDolje.setValue(sp2.getInt("trbuhDoljeNumber", 0));
        trbuhGore.setValue(sp2.getInt("trbuhGoreNumber", 0));
        plank.setValue(sp2.getInt("plankNumber", 0));
        trbuhStanga.setValue(sp2.getInt("trbuhStangaNumber", 0));
        trbuhRazno.setValue(sp2.getInt("trbuhRaznoNumber", 0));

        Button generatePrsa = findViewById(R.id.generatePrsa);
        generatePrsa.setOnClickListener(v -> {
            lista.clear();
            lista.add("prsa_zagrijavanje");
            lista.add(sklekoviList[sklekovi.getValue()]);
            lista.add(stangaPrsaList[stangaPrsa.getValue()]);
            lista.add(prsaVjestineList[prsaVjestine.getValue()]);
            lista.add(prsaStabilnostList[prsaStabilnost.getValue()]);
            lista.add(rukeList[ruke.getValue()]);
            lista.add(sklekKretanjeList[sklekKretanje.getValue()]);
            lista.add("prsa_rastezanje");
        });

        Button generateNoge = findViewById(R.id.generateNoge);
        generateNoge.setOnClickListener(v -> {
            lista.clear();
            lista.add("noge_zagrijavanje");
            lista.add(cucnjeviList[cucnjevi.getValue()]);
            lista.add(rudariList[rudari.getValue()]);
            lista.add(raznoNogeList[raznoNoge.getValue()]);
            lista.add(stabilnostNogeList[stabilnostNoge.getValue()]);
            lista.add(nogeList[noge.getValue()]);
            lista.add(kretanjeNogeList[kretanjeNoge.getValue()]);
            lista.add("noge_rastezanje");
        });

        Button generateTrbuh = findViewById(R.id.generateTrbuh);
        generateTrbuh.setOnClickListener(v -> {
            lista.clear();
            lista.add("trbuh_zagrijavanje");
            lista.add(trbuhStranaList[trbuhStrana.getValue()]);
            lista.add(trbuhDoljeList[trbuhDolje.getValue()]);
            lista.add(trbuhGoreList[trbuhGore.getValue()]);
            lista.add(plankList[plank.getValue()]);
            lista.add(trbuhStangaList[trbuhStanga.getValue()]);
            lista.add(trbuhRaznoList[trbuhRazno.getValue()]);
            lista.add("trbuh_rastezanje");
        });

        Button start = findViewById(R.id.start);
        start.setOnClickListener(v -> {
            Intent startIntent = new Intent(getApplicationContext(), WorkoutDisplay.class);
            startIntent.putStringArrayListExtra("lista", lista);
            startActivity(startIntent);
        });

    }
}