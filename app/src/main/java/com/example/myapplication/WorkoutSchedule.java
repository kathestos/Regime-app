package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.util.ArrayUtils;

import java.util.Objects;

public class WorkoutSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_workout_schedule);

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

        NumberPicker prsaStabilnost = findViewById(R.id.prsa_stabilnost);
        String[] prsaStabilnostList = getResources().getStringArray(R.array.sklek_stabilnost);
        prsaStabilnost.setMinValue(0);
        prsaStabilnost.setMaxValue(prsaStabilnostList.length - 1);
        prsaStabilnost.setDisplayedValues(prsaStabilnostList);

        NumberPicker prsaVjestine = findViewById(R.id.prsa_vještine);
        String[] prsaVjestineList = getResources().getStringArray(R.array.sklek_vještine);
        prsaVjestine.setMinValue(0);
        prsaVjestine.setMaxValue(prsaVjestineList.length - 1);
        prsaVjestine.setDisplayedValues(prsaVjestineList);

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

        NumberPicker stangaPrsa = findViewById(R.id.prsa_štanga);
        String[] stangaPrsaList = getResources().getStringArray(R.array.štanga_ruke);
        stangaPrsa.setMinValue(0);
        stangaPrsa.setMaxValue(stangaPrsaList.length - 1);
        stangaPrsa.setDisplayedValues(stangaPrsaList);

        NumberPicker prsaRastezanje = findViewById(R.id.prsa_rastezanje);
        String[] prsaRastezanjeList = getResources().getStringArray(R.array.rastezanje_ruke);
        prsaRastezanje.setMinValue(0);
        prsaRastezanje.setMaxValue(prsaRastezanjeList.length - 1);
        prsaRastezanje.setDisplayedValues(prsaRastezanjeList);

        Button prsaPlusOne = findViewById(R.id.prsaPlusOne);
        prsaPlusOne.setOnClickListener(v -> {
            sklekovi.setValue(sklekovi.getValue() + 1);
            prsaStabilnost.setValue(prsaStabilnost.getValue() + 1);
            prsaVjestine.setValue(prsaVjestine.getValue() + 1);
            ruke.setValue(ruke.getValue() + 1);
            sklekKretanje.setValue(sklekKretanje.getValue() + 1);
            stangaPrsa.setValue(stangaPrsa.getValue() + 1);
        });

        NumberPicker zagrijavanjeNoge = findViewById(R.id.zagrijavanje_noge);
        String[] zagrijavanjeNogeList = getResources().getStringArray(R.array.zagrijavanje_noge);
        String[] razgibavanjeNogeList = getResources().getStringArray(R.array.razgibavanje_noge);
        String[] objeNoge = ArrayUtils.concat(zagrijavanjeNogeList, razgibavanjeNogeList);
        zagrijavanjeNoge.setMinValue(0);
        zagrijavanjeNoge.setMaxValue(objeNoge.length - 1);
        zagrijavanjeNoge.setDisplayedValues(objeNoge);

        NumberPicker cucnjevi = findViewById(R.id.čučnjevi);
        String[] cucnjeviList = getResources().getStringArray(R.array.čučnjevi);
        cucnjevi.setMinValue(0);
        cucnjevi.setMaxValue(cucnjeviList.length - 1);
        cucnjevi.setDisplayedValues(cucnjeviList);

        NumberPicker rudari = findViewById(R.id.rudari);
        String[] rudariList = getResources().getStringArray(R.array.rudari);
        rudari.setMinValue(0);
        rudari.setMaxValue(rudariList.length - 1);
        rudari.setDisplayedValues(rudariList);

        NumberPicker stabilnostNoge = findViewById(R.id.stabilnost_noge);
        String[] stabilnostNogeList = getResources().getStringArray(R.array.stabilnost_noge);
        stabilnostNoge.setMinValue(0);
        stabilnostNoge.setMaxValue(stabilnostNogeList.length - 1);
        stabilnostNoge.setDisplayedValues(stabilnostNogeList);

        NumberPicker raznoNoge = findViewById(R.id.razno_noge);
        String[] raznoNogeList = getResources().getStringArray(R.array.razno_noge);
        raznoNoge.setMinValue(0);
        raznoNoge.setMaxValue(raznoNogeList.length - 1);
        raznoNoge.setDisplayedValues(raznoNogeList);

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
            stabilnostNoge.setValue(stabilnostNoge.getValue() + 1);
            raznoNoge.setValue(raznoNoge.getValue() + 1);
            noge.setValue(noge.getValue() + 1);
            kretanjeNoge.setValue(kretanjeNoge.getValue() + 1);
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

        NumberPicker trbuhRazno = findViewById(R.id.trbuh_razno);
        String[] trbuhRaznoList = getResources().getStringArray(R.array.trbuh_razno);
        trbuhRazno.setMinValue(0);
        trbuhRazno.setMaxValue(trbuhRaznoList.length - 1);
        trbuhRazno.setDisplayedValues(trbuhRaznoList);

        NumberPicker trbuhStanga = findViewById(R.id.trbuh_štanga);
        String[] trbuhStangaList = getResources().getStringArray(R.array.trbuh_štanga);
        trbuhStanga.setMinValue(0);
        trbuhStanga.setMaxValue(trbuhStangaList.length - 1);
        trbuhStanga.setDisplayedValues(trbuhStangaList);

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
            trbuhRazno.setValue(trbuhRazno.getValue() + 1);
            trbuhStanga.setValue(trbuhStanga.getValue() + 1);
        });

    }
}