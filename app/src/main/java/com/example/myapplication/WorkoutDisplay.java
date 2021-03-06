package com.example.myapplication;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;

public class WorkoutDisplay extends AppCompatActivity {

    ArrayList<Integer> playlist = new ArrayList<>();
    int i = 0;
    SeekBar mSeekBar;
    TextView totTime;
    TextView curTime;
    ImageView nextIcon;
    ImageView prevIcon;
    ImageView play;
    ImageView pause;
    boolean stopGifs = false;
    int totalDuration = 0;
    boolean stopProgress = false;
    int startDuration = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_workout_display);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ArrayList<String> lista = getIntent().getExtras().getStringArrayList("lista");

        TextView nazivVjezbe = findViewById(R.id.naziv_vjezbe);
        GifImageView gif = findViewById(R.id.gif);

        String[] sklekovi = getResources().getStringArray(R.array.sklekovi);
        String[] stanga_ruke = getResources().getStringArray(R.array.stanga_ruke);
        String[] sklek_vjestine = getResources().getStringArray(R.array.sklek_vjestine);
        String[] sklek_stabilnost = getResources().getStringArray(R.array.sklek_stabilnost);
        String[] ruke = getResources().getStringArray(R.array.ruke);
        String[] sklek_kretanje = getResources().getStringArray(R.array.sklek_kretanje);

        String[] cucnjevi = getResources().getStringArray(R.array.cucnjevi);
        String[] rudari = getResources().getStringArray(R.array.rudari);
        String[] razno_noge = getResources().getStringArray(R.array.razno_noge);
        String[] stabilnost_noge = getResources().getStringArray(R.array.stabilnost_noge);
        String[] noge = getResources().getStringArray(R.array.noge);
        String[] kretanje_noge = getResources().getStringArray(R.array.kretanje_noge);

        String[] trbuh_strana = getResources().getStringArray(R.array.trbuh_strana);
        String[] trbuh_dolje = getResources().getStringArray(R.array.trbuh_dolje);
        String[] trbuh_gore = getResources().getStringArray(R.array.trbuh_gore);
        String[] plank = getResources().getStringArray(R.array.plank);
        String[] trbuh_stanga = getResources().getStringArray(R.array.trbuh_stanga);
        String[] trbuh_razno = getResources().getStringArray(R.array.trbuh_razno);

        curTime = findViewById(R.id.curTime);
        nextIcon = findViewById(R.id.nextIcon);
        prevIcon = findViewById(R.id.prevIcon);

        TextView listaVjezbi = findViewById(R.id.lista_vjezbi);
        for (String temp : lista) {
            listaVjezbi.append(temp);
            listaVjezbi.append("\n");

            if (temp.equals("prsa zagrijavanje")) {
                playlist.add(R.raw.prsa_zagrijavanje);
                nazivVjezbe.setText("PRSA");
                gif.setImageResource(R.drawable.img2);
            }

            if (temp.equals(sklekovi[0])) {
                playlist.add(R.raw.norm_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[1])) {
                playlist.add(R.raw.uski_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[2])) {
                playlist.add(R.raw.siroki_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[3])) {
                playlist.add(R.raw.krizni_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[4])) {
                playlist.add(R.raw.prednji_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklekovi[5])) {
                playlist.add(R.raw.nagnuti_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(stanga_ruke[0])) {
                playlist.add(R.raw.siroko_90);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[1])) {
                playlist.add(R.raw.usko_80);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[2])) {
                playlist.add(R.raw.siroko_80);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[3])) {
                playlist.add(R.raw.usko_70);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[4])) {
                playlist.add(R.raw.siroko_70);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[5])) {
                playlist.add(R.raw.usko_60);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[6])) {
                playlist.add(R.raw.siroko_60);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[7])) {
                playlist.add(R.raw.usko_50);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stanga_ruke[8])) {
                playlist.add(R.raw.obje_ruke);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(sklek_vjestine[0])) {
                playlist.add(R.raw.stoj);
                playlist.add(R.raw.pauza_10s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(sklek_vjestine[1])) {
                playlist.add(R.raw.uvuceni_planche);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_vjestine[2])) {
                playlist.add(R.raw.hindu);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_vjestine[3])) {
                playlist.add(R.raw.jedna_ruka);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_vjestine[4])) {
                playlist.add(R.raw.nagib);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(sklek_stabilnost[0])) {
                playlist.add(R.raw.ruka_gore);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(sklek_stabilnost[1])) {
                playlist.add(R.raw.ruka_ispred);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(sklek_stabilnost[2])) {
                playlist.add(R.raw.ruka_iza);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(sklek_stabilnost[3])) {
                playlist.add(R.raw.dizanje_ramena);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(ruke[0])) {
                playlist.add(R.raw.ruke_sastrane);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(ruke[1])) {
                playlist.add(R.raw.ruke_iza);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(ruke[2])) {
                playlist.add(R.raw.ruke_iza_tijelo);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(ruke[3])) {
                playlist.add(R.raw.ruke_ispred);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(ruke[4])) {
                playlist.add(R.raw.jedna_ruka_iza);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }

            if (temp.equals(sklek_kretanje[0])) {
                playlist.add(R.raw.sklek_ustranu);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_kretanje[1])) {
                playlist.add(R.raw.gore_dolje_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(sklek_kretanje[2])) {
                playlist.add(R.raw.guster);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(sklek_kretanje[3])) {
                playlist.add(R.raw.spori_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals("dodatni sklek")) {
                playlist.add(R.raw.dodatni_sklek);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals("prsa rastezanje")) playlist.add(R.raw.prsa_rastezanje);

            if (temp.equals("noge zagrijavanje")) {
                playlist.add(R.raw.noge_zagrijavanje);
                nazivVjezbe.setText("NOGE");
                gif.setImageResource(R.drawable.img1);
            }

            if (temp.equals(cucnjevi[0])) {
                playlist.add(R.raw.cucanj);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(cucnjevi[1])) {
                playlist.add(R.raw.cucanj_ruke_iznad);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(cucnjevi[2])) {
                playlist.add(R.raw.cucanj_noge_usko);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(cucnjevi[3])) {
                playlist.add(R.raw.cucanj_noge_siroko);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }

            if (temp.equals(rudari[0])) {
                playlist.add(R.raw.rudar_naprijed);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(rudari[1])) {
                playlist.add(R.raw.rudar_nazad);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(rudari[2])) {
                playlist.add(R.raw.rudar_ustranu);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(rudari[3])) {
                playlist.add(R.raw.rudar_noga_iza);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }

            if (temp.equals(razno_noge[0])) {
                playlist.add(R.raw.spartan);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(razno_noge[1])) {
                playlist.add(R.raw.jedna_noga);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(razno_noge[2])) {
                playlist.add(R.raw.noga_gore);
            }
            if (temp.equals(razno_noge[3])) {
                playlist.add(R.raw.prsti);
            }

            if (temp.equals(stabilnost_noge[0])) {
                playlist.add(R.raw.utkatasana);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(stabilnost_noge[1])) {
                playlist.add(R.raw.virabhadrasana);
            }
            if (temp.equals(stabilnost_noge[2])) {
                playlist.add(R.raw.virabhadrasana_2);
            }
            if (temp.equals(stabilnost_noge[3])) {
                playlist.add(R.raw.virabhadrasana_3);
            }
            if (temp.equals(stabilnost_noge[4])) {
                playlist.add(R.raw.utthita_padangusthasana);
            }
            if (temp.equals(stabilnost_noge[5])) {
                playlist.add(R.raw.utthita_parsvakonasana);
            }
            if (temp.equals(stabilnost_noge[6])) {
                playlist.add(R.raw.natarajasana);
            }

            if (temp.equals(noge[0])) {
                playlist.add(R.raw.noge_ustranu);
            }
            if (temp.equals(noge[1])) {
                playlist.add(R.raw.noge_ispred_iza);
            }
            if (temp.equals(noge[2])) {
                playlist.add(R.raw.spoda_sastrane);
            }
            if (temp.equals(noge[3])) {
                playlist.add(R.raw.spoda_ispred);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(kretanje_noge[0])) {
                playlist.add(R.raw.cucanj_ustranu);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(kretanje_noge[1])) {
                playlist.add(R.raw.spori_cucanj);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(kretanje_noge[2])) {
                playlist.add(R.raw.naprijed_nazad);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(kretanje_noge[3])) {
                playlist.add(R.raw.cucanj_udarac);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals("dodatni cucanj")) {
                playlist.add(R.raw.dodatni_cucanj);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals("noge rastezanje")) playlist.add(R.raw.rastezanje_noge);

            if (temp.equals("trbuh zagrijavanje")) {
                playlist.add(R.raw.zagrijavanje_trbuh);
                nazivVjezbe.setText("TRBUH");
                gif.setImageResource(R.drawable.img3);
            }

            if (temp.equals(trbuh_strana[0])) {
                playlist.add(R.raw.dodir_pete);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_strana[1])) {
                playlist.add(R.raw.lakat_koljeno);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_strana[2])) {
                playlist.add(R.raw.rotacija_ruku);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_strana[3])) {
                playlist.add(R.raw.sa_strane);
            }
            if (temp.equals(trbuh_strana[4])) {
                playlist.add(R.raw.ruka_stopalo);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_strana[5])) {
                playlist.add(R.raw.ustranu);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(trbuh_dolje[0])) {
                playlist.add(R.raw.noge_prsa);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(trbuh_dolje[1])) {
                playlist.add(R.raw.obje_noge_gore);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_dolje[2])) {
                playlist.add(R.raw.naizmjenicno_noga_gore);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_dolje[3])) {
                playlist.add(R.raw.noge_gore_dolje);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_dolje[4])) {
                playlist.add(R.raw.noge_lijevo_desno);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_dolje[5])) {
                playlist.add(R.raw.jedna_noga_gore);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(trbuh_gore[0])) {
                playlist.add(R.raw.sklopka);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_gore[1])) {
                playlist.add(R.raw.puna_sklopka);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_gore[2])) {
                playlist.add(R.raw.noge_gore);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_gore[3])) {
                playlist.add(R.raw.ruke_ispred_trbusnjak);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_gore[4])) {
                playlist.add(R.raw.ispruzene_sklopke);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_gore[5])) {
                playlist.add(R.raw.ruke_gore);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_gore[6])) {
                playlist.add(R.raw.obicni);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_gore[7])) {
                playlist.add(R.raw.dizanje_ruku);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(plank[0])) {
                playlist.add(R.raw.ravni_plank);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }
            if (temp.equals(plank[1])) {
                playlist.add(R.raw.ustranu_plank);
            }
            if (temp.equals(plank[2])) {
                playlist.add(R.raw.drzanje_sklopke);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(plank[3])) {
                playlist.add(R.raw.ukoceno_tijelo);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(plank[4])) {
                playlist.add(R.raw.plank_iza);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec30);
            }

            if (temp.equals(trbuh_stanga[0])) {
                playlist.add(R.raw.skvrcene_usko);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_stanga[1])) {
                playlist.add(R.raw.ispruzene_usko);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_stanga[2])) {
                playlist.add(R.raw.skvrcene_siroko);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_stanga[3])) {
                playlist.add(R.raw.ispruzene_siroko);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_stanga[4])) {
                playlist.add(R.raw.skvrcene_obje);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_stanga[5])) {
                playlist.add(R.raw.ispruzene_obje);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals(trbuh_razno[0])) {
                playlist.add(R.raw.leznjak);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_razno[1])) {
                playlist.add(R.raw.dizanje_kukova);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_razno[2])) {
                playlist.add(R.raw.noge_gore_ustranu);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_razno[3])) {
                playlist.add(R.raw.krugovi_nogama);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }
            if (temp.equals(trbuh_razno[4])) {
                playlist.add(R.raw.buba);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals("dodatni trbusnjak")) {
                playlist.add(R.raw.dodatni_trbusnjak);
                playlist.add(R.raw.pauza_5s);
                playlist.add(R.raw.sec20);
            }

            if (temp.equals("trbuh rastezanje")) playlist.add(R.raw.rastezanje_trbuh);
        }

        TextView trajanje = findViewById(R.id.trajanje);
        for (int i = 0; i < playlist.size(); i++) {
            MediaPlayer mp = MediaPlayer.create(this, playlist.get(i));
            totalDuration += mp.getDuration();
        }
        trajanje.setText(setTrajanjeText(totalDuration, 0));

        play = findViewById(R.id.playMp3);
        pause = findViewById(R.id.pauseMp3);

        play.setOnClickListener(v -> {
            ProgressBar pb = findViewById(R.id.progres);
            pb.setMax(totalDuration);
            startDuration = totalDuration;
            stopProgress = false;
            setProgressBar();
            playNext(pause);
        });
    }

    void playNext(ImageView pause) {
        TextView nazivVjezbe = findViewById(R.id.naziv_vjezbe);
        GifImageView gif = findViewById(R.id.gif);

        String[] sklekovi = getResources().getStringArray(R.array.sklekovi);
        String[] stanga_ruke = getResources().getStringArray(R.array.stanga_ruke);
        String[] sklek_vjestine = getResources().getStringArray(R.array.sklek_vjestine);
        String[] sklek_stabilnost = getResources().getStringArray(R.array.sklek_stabilnost);
        String[] ruke = getResources().getStringArray(R.array.ruke);
        String[] sklek_kretanje = getResources().getStringArray(R.array.sklek_kretanje);

        String[] cucnjevi = getResources().getStringArray(R.array.cucnjevi);
        String[] rudari = getResources().getStringArray(R.array.rudari);
        String[] razno_noge = getResources().getStringArray(R.array.razno_noge);
        String[] stabilnost_noge = getResources().getStringArray(R.array.stabilnost_noge);
        String[] noge = getResources().getStringArray(R.array.noge);
        String[] kretanje_noge = getResources().getStringArray(R.array.kretanje_noge);

        String[] trbuh_strana = getResources().getStringArray(R.array.trbuh_strana);
        String[] trbuh_dolje = getResources().getStringArray(R.array.trbuh_dolje);
        String[] trbuh_gore = getResources().getStringArray(R.array.trbuh_gore);
        String[] plank = getResources().getStringArray(R.array.plank);
        String[] trbuh_stanga = getResources().getStringArray(R.array.trbuh_stanga);
        String[] trbuh_razno = getResources().getStringArray(R.array.trbuh_razno);

        mSeekBar = findViewById(R.id.mSeekBar);
        totTime = findViewById(R.id.totalTime);

        if (i == 0) {
            play.setVisibility(View.INVISIBLE);
            pause.setVisibility(View.VISIBLE);
        }

        if (i < playlist.size()) {
            MediaPlayer mp = MediaPlayer.create(this, playlist.get(i++));

            mp.setOnPreparedListener(mp1 -> {
                String totalTime = createTimeLabel(mp.getDuration());
                totTime.setText(totalTime);
                mSeekBar.setMax(mp.getDuration());
                mp.start();

                if (playlist.get(i - 1).equals(R.raw.prsa_zagrijavanje)) {
                    nazivVjezbe.setText("prsa zagrijavanje");
                    gif.setImageResource(R.drawable.gif_ph);
                    stopGifs = false;
                    setPrsaZagrijavanjeGifs(gif);
                }

                if (playlist.get(i - 1).equals(R.raw.norm_sklek)) {
                    nazivVjezbe.setText(sklekovi[0]);
                    gif.setImageResource(R.drawable.sklek);
                }
                if (playlist.get(i - 1).equals(R.raw.uski_sklek)) {
                    nazivVjezbe.setText(sklekovi[1]);
                    gif.setImageResource(R.drawable.uski_sklek);
                }
                if (playlist.get(i - 1).equals(R.raw.siroki_sklek)) {
                    nazivVjezbe.setText(sklekovi[2]);
                    gif.setImageResource(R.drawable.siroki_sklek);
                }
                if (playlist.get(i - 1).equals(R.raw.krizni_sklek)) {
                    nazivVjezbe.setText(sklekovi[3]);
                    gif.setImageResource(R.drawable.krizni_sklek);
                }
                if (playlist.get(i - 1).equals(R.raw.prednji_sklek)) {
                    nazivVjezbe.setText(sklekovi[4]);
                    gif.setImageResource(R.drawable.prednji_sklek);
                }
                if (playlist.get(i - 1).equals(R.raw.nagnuti_sklek)) {
                    nazivVjezbe.setText(sklekovi[5]);
                    gif.setImageResource(R.drawable.pike_sklek);
                }

                if (playlist.get(i - 1).equals(R.raw.siroko_90)) {
                    nazivVjezbe.setText(stanga_ruke[0]);
                    gif.setImageResource(R.drawable.siroko_90);
                }
                if (playlist.get(i - 1).equals(R.raw.usko_80)) {
                    nazivVjezbe.setText(stanga_ruke[1]);
                    gif.setImageResource(R.drawable.usko_80);
                }
                if (playlist.get(i - 1).equals(R.raw.siroko_80)) {
                    nazivVjezbe.setText(stanga_ruke[2]);
                    gif.setImageResource(R.drawable.siroko_80);
                }
                if (playlist.get(i - 1).equals(R.raw.usko_70)) {
                    nazivVjezbe.setText(stanga_ruke[3]);
                    gif.setImageResource(R.drawable.usko_70);
                }
                if (playlist.get(i - 1).equals(R.raw.siroko_70)) {
                    nazivVjezbe.setText(stanga_ruke[4]);
                    gif.setImageResource(R.drawable.siroko_70);
                }
                if (playlist.get(i - 1).equals(R.raw.usko_60)) {
                    nazivVjezbe.setText(stanga_ruke[5]);
                    gif.setImageResource(R.drawable.usko_60);
                }
                if (playlist.get(i - 1).equals(R.raw.siroko_60)) {
                    nazivVjezbe.setText(stanga_ruke[6]);
                    gif.setImageResource(R.drawable.siroko_60);
                }
                if (playlist.get(i - 1).equals(R.raw.usko_50)) {
                    nazivVjezbe.setText(stanga_ruke[7]);
                    gif.setImageResource(R.drawable.usko_50);
                }
                if (playlist.get(i - 1).equals(R.raw.obje_ruke)) {
                    nazivVjezbe.setText(stanga_ruke[8]);
                    gif.setImageResource(R.drawable.obje_stange);
                }

                if (playlist.get(i - 1).equals(R.raw.stoj)) {
                    nazivVjezbe.setText(sklek_vjestine[0]);
                    gif.setImageResource(R.drawable.stoj);
                }
                if (playlist.get(i - 1).equals(R.raw.uvuceni_planche)) {
                    nazivVjezbe.setText(sklek_vjestine[1]);
                    gif.setImageResource(R.drawable.drzanje);
                }
                if (playlist.get(i - 1).equals(R.raw.hindu)) {
                    nazivVjezbe.setText(sklek_vjestine[2]);
                    gif.setImageResource(R.drawable.hindu);
                }
                if (playlist.get(i - 1).equals(R.raw.jedna_ruka)) {
                    nazivVjezbe.setText(sklek_vjestine[3]);
                    gif.setImageResource(R.drawable.sklek_jedna_ruka);
                }
                if (playlist.get(i - 1).equals(R.raw.nagib)) {
                    nazivVjezbe.setText(sklek_vjestine[4]);
                    gif.setImageResource(R.drawable.nagib_sklek);
                }

                if (playlist.get(i - 1).equals(R.raw.ruka_gore)) {
                    nazivVjezbe.setText(sklek_stabilnost[0]);
                    gif.setImageResource(R.drawable.ruka_gore);
                }
                if (playlist.get(i - 1).equals(R.raw.ruka_ispred)) {
                    nazivVjezbe.setText(sklek_stabilnost[1]);
                    gif.setImageResource(R.drawable.ruka_ispred);
                }
                if (playlist.get(i - 1).equals(R.raw.ruka_iza)) {
                    nazivVjezbe.setText(sklek_stabilnost[2]);
                    gif.setImageResource(R.drawable.ruka_iza);
                }
                if (playlist.get(i - 1).equals(R.raw.dizanje_ramena)) {
                    nazivVjezbe.setText(sklek_stabilnost[3]);
                    gif.setImageResource(R.drawable.sklek_ramena_prsti);
                }

                if (playlist.get(i - 1).equals(R.raw.ruke_sastrane)) {
                    nazivVjezbe.setText(ruke[0]);
                    gif.setImageResource(R.drawable.dizanje_ruku);
                }
                if (playlist.get(i - 1).equals(R.raw.ruke_iza)) {
                    nazivVjezbe.setText(ruke[1]);
                    gif.setImageResource(R.drawable.ruke_iza);
                }
                if (playlist.get(i - 1).equals(R.raw.ruke_iza_tijelo)) {
                    nazivVjezbe.setText(ruke[2]);
                    gif.setImageResource(R.drawable.ruke_iznad);
                }
                if (playlist.get(i - 1).equals(R.raw.ruke_ispred)) {
                    nazivVjezbe.setText(ruke[3]);
                    gif.setImageResource(R.drawable.ruke_ispred);
                }
                if (playlist.get(i - 1).equals(R.raw.jedna_ruka_iza)) {
                    nazivVjezbe.setText(ruke[4]);
                    gif.setImageResource(R.drawable.jedna_ruka_iza);
                }

                if (playlist.get(i - 1).equals(R.raw.sklek_ustranu)) {
                    nazivVjezbe.setText(sklek_kretanje[0]);
                    gif.setImageResource(R.drawable.kretanje_sklek);
                }
                if (playlist.get(i - 1).equals(R.raw.gore_dolje_sklek)) {
                    nazivVjezbe.setText(sklek_kretanje[1]);
                    gif.setImageResource(R.drawable.sklek_dolje_gore);
                }
                if (playlist.get(i - 1).equals(R.raw.guster)) {
                    nazivVjezbe.setText(sklek_kretanje[2]);
                    gif.setImageResource(R.drawable.guster);
                }
                if (playlist.get(i - 1).equals(R.raw.spori_sklek)) {
                    nazivVjezbe.setText(sklek_kretanje[3]);
                    gif.setImageResource(R.drawable.spori_sklek);
                }

                if (playlist.get(i - 1).equals(R.raw.dodatni_sklek)) {
                    nazivVjezbe.setText("dodatni sklek");
                    gif.setImageResource(R.drawable.sklek);
                }

                if (playlist.get(i - 1).equals(R.raw.prsa_rastezanje)) {
                    nazivVjezbe.setText("prsa rastezanje");
                    gif.setImageResource(R.drawable.gif_ph);
                    stopGifs = false;
                    setPrsaRastezanjeGifs(gif);
                }

                if (playlist.get(i - 1).equals(R.raw.noge_zagrijavanje)) {
                    nazivVjezbe.setText("noge zagrijavanje");
                    gif.setImageResource(R.drawable.gif_ph);
                    stopGifs = false;
                    setNogeZagrijavanjeGifs(gif);
                }

                if (playlist.get(i - 1).equals(R.raw.cucanj)) {
                    nazivVjezbe.setText(cucnjevi[0]);
                    gif.setImageResource(R.drawable.cucanj);
                }
                if (playlist.get(i - 1).equals(R.raw.cucanj_ruke_iznad)) {
                    nazivVjezbe.setText(cucnjevi[1]);
                    gif.setImageResource(R.drawable.cucanj_ruke_gore);
                }
                if (playlist.get(i - 1).equals(R.raw.cucanj_noge_usko)) {
                    nazivVjezbe.setText(cucnjevi[2]);
                    gif.setImageResource(R.drawable.uski_cucanj);
                }
                if (playlist.get(i - 1).equals(R.raw.cucanj_noge_siroko)) {
                    nazivVjezbe.setText(cucnjevi[3]);
                    gif.setImageResource(R.drawable.siroki_cucanj);
                }

                if (playlist.get(i - 1).equals(R.raw.rudar_naprijed)) {
                    nazivVjezbe.setText(rudari[0]);
                    gif.setImageResource(R.drawable.rudar);
                }
                if (playlist.get(i - 1).equals(R.raw.rudar_nazad)) {
                    nazivVjezbe.setText(rudari[1]);
                    gif.setImageResource(R.drawable.rudar_iza);
                }
                if (playlist.get(i - 1).equals(R.raw.rudar_ustranu)) {
                    nazivVjezbe.setText(rudari[2]);
                    gif.setImageResource(R.drawable.istezanje_strana);
                }
                if (playlist.get(i - 1).equals(R.raw.rudar_noga_iza)) {
                    nazivVjezbe.setText(rudari[3]);
                    gif.setImageResource(R.drawable.rudar_iza_ustranu);
                }

                if (playlist.get(i - 1).equals(R.raw.spartan)) {
                    nazivVjezbe.setText(razno_noge[0]);
                    gif.setImageResource(R.drawable.spartan);
                }
                if (playlist.get(i - 1).equals(R.raw.jedna_noga)) {
                    nazivVjezbe.setText(razno_noge[1]);
                    gif.setImageResource(R.drawable.jedna_noga);
                }
                if (playlist.get(i - 1).equals(R.raw.noga_gore)) {
                    nazivVjezbe.setText(razno_noge[2]);
                    gif.setImageResource(R.drawable.noga_gore);
                }
                if (playlist.get(i - 1).equals(R.raw.prsti)) {
                    nazivVjezbe.setText(razno_noge[3]);
                    gif.setImageResource(R.drawable.prsti);
                }

                if (playlist.get(i - 1).equals(R.raw.utkatasana)) {
                    nazivVjezbe.setText(stabilnost_noge[0]);
                    gif.setImageResource(R.drawable.joga6);
                }
                if (playlist.get(i - 1).equals(R.raw.virabhadrasana)) {
                    nazivVjezbe.setText(stabilnost_noge[1]);
                    gif.setImageResource(R.drawable.virabhadrasana_1);
                }
                if (playlist.get(i - 1).equals(R.raw.virabhadrasana_2)) {
                    nazivVjezbe.setText(stabilnost_noge[2]);
                    gif.setImageResource(R.drawable.warrior);
                }
                if (playlist.get(i - 1).equals(R.raw.virabhadrasana_3)) {
                    nazivVjezbe.setText(stabilnost_noge[3]);
                    gif.setImageResource(R.drawable.virabhadrasana_3);
                }
                if (playlist.get(i - 1).equals(R.raw.utthita_padangusthasana)) {
                    nazivVjezbe.setText(stabilnost_noge[4]);
                    gif.setImageResource(R.drawable.drzanje_noge);
                }
                if (playlist.get(i - 1).equals(R.raw.utthita_parsvakonasana)) {
                    nazivVjezbe.setText(stabilnost_noge[5]);
                    gif.setImageResource(R.drawable.utthita_parsvakonasana);
                }
                if (playlist.get(i - 1).equals(R.raw.natarajasana)) {
                    nazivVjezbe.setText(stabilnost_noge[6]);
                    gif.setImageResource(R.drawable.natarajasana);
                }

                if (playlist.get(i - 1).equals(R.raw.noge_ustranu)) {
                    nazivVjezbe.setText(noge[0]);
                    gif.setImageResource(R.drawable.noga_strana);
                }
                if (playlist.get(i - 1).equals(R.raw.noge_ispred_iza)) {
                    nazivVjezbe.setText(noge[1]);
                    gif.setImageResource(R.drawable.noga_ispred_iza);
                }
                if (playlist.get(i - 1).equals(R.raw.spoda_sastrane)) {
                    nazivVjezbe.setText(noge[2]);
                    gif.setImageResource(R.drawable.noga_ustranu_spoda);
                }
                if (playlist.get(i - 1).equals(R.raw.spoda_ispred)) {
                    nazivVjezbe.setText(noge[3]);
                    gif.setImageResource(R.drawable.noga_ispred_spoda);
                }

                if (playlist.get(i - 1).equals(R.raw.cucanj_ustranu)) {
                    nazivVjezbe.setText(kretanje_noge[0]);
                    gif.setImageResource(R.drawable.pokret_noge);
                }
                if (playlist.get(i - 1).equals(R.raw.spori_cucanj)) {
                    nazivVjezbe.setText(kretanje_noge[1]);
                    gif.setImageResource(R.drawable.spori_cucanj);
                }
                if (playlist.get(i - 1).equals(R.raw.naprijed_nazad)) {
                    nazivVjezbe.setText(kretanje_noge[2]);
                    gif.setImageResource(R.drawable.cucanj_naprijed_nazad);
                }
                if (playlist.get(i - 1).equals(R.raw.cucanj_udarac)) {
                    nazivVjezbe.setText(kretanje_noge[3]);
                    gif.setImageResource(R.drawable.cucanj_udarac);
                }

                if (playlist.get(i - 1).equals(R.raw.dodatni_cucanj)) {
                    nazivVjezbe.setText("dodatni čučanj");
                    gif.setImageResource(R.drawable.cucanj);
                }

                if (playlist.get(i - 1).equals(R.raw.rastezanje_noge)) {
                    nazivVjezbe.setText("noge rastezanje");
                    gif.setImageResource(R.drawable.gif_ph);
                    stopGifs = false;
                    setNogeRastezanjeGifs(gif);
                }

                if (playlist.get(i - 1).equals(R.raw.zagrijavanje_trbuh)) {
                    nazivVjezbe.setText("trbuh zagrijavanje");
                    gif.setImageResource(R.drawable.gif_ph);
                    stopGifs = false;
                    setTrbuhZagrijavanjeGifs(gif);
                }

                if (playlist.get(i - 1).equals(R.raw.dodir_pete)) {
                    nazivVjezbe.setText(trbuh_strana[0]);
                    gif.setImageResource(R.drawable.stopala);
                }
                if (playlist.get(i - 1).equals(R.raw.lakat_koljeno)) {
                    nazivVjezbe.setText(trbuh_strana[1]);
                    gif.setImageResource(R.drawable.lakat_koljeno);
                }
                if (playlist.get(i - 1).equals(R.raw.rotacija_ruku)) {
                    nazivVjezbe.setText(trbuh_strana[2]);
                    gif.setImageResource(R.drawable.ruke_strana);
                }
                if (playlist.get(i - 1).equals(R.raw.sa_strane)) {
                    nazivVjezbe.setText(trbuh_strana[3]);
                    gif.setImageResource(R.drawable.u_stranu);
                }
                if (playlist.get(i - 1).equals(R.raw.ruka_stopalo)) {
                    nazivVjezbe.setText(trbuh_strana[4]);
                    gif.setImageResource(R.drawable.ruka_stopalo);
                }
                if (playlist.get(i - 1).equals(R.raw.ustranu)) {
                    nazivVjezbe.setText(trbuh_strana[5]);
                    gif.setImageResource(R.drawable.okret_ustranu);
                }

                if (playlist.get(i - 1).equals(R.raw.noge_prsa)) {
                    nazivVjezbe.setText(trbuh_dolje[0]);
                    gif.setImageResource(R.drawable.noge_prsa);
                }
                if (playlist.get(i - 1).equals(R.raw.obje_noge_gore)) {
                    nazivVjezbe.setText(trbuh_dolje[1]);
                    gif.setImageResource(R.drawable.obje_noge);
                }
                if (playlist.get(i - 1).equals(R.raw.naizmjenicno_noga_gore)) {
                    nazivVjezbe.setText(trbuh_dolje[2]);
                    gif.setImageResource(R.drawable.noge_izmjenicno);
                }
                if (playlist.get(i - 1).equals(R.raw.noge_gore_dolje)) {
                    nazivVjezbe.setText(trbuh_dolje[3]);
                    gif.setImageResource(R.drawable.noge_gore_dolje);
                }
                if (playlist.get(i - 1).equals(R.raw.noge_lijevo_desno)) {
                    nazivVjezbe.setText(trbuh_dolje[4]);
                    gif.setImageResource(R.drawable.noge_unakrsno);
                }
                if (playlist.get(i - 1).equals(R.raw.jedna_noga_gore)) {
                    nazivVjezbe.setText(trbuh_dolje[5]);
                    gif.setImageResource(R.drawable.jedna_pojedna_noga);
                }

                if (playlist.get(i - 1).equals(R.raw.sklopka)) {
                    nazivVjezbe.setText(trbuh_gore[0]);
                    gif.setImageResource(R.drawable.sklopka);
                }
                if (playlist.get(i - 1).equals(R.raw.puna_sklopka)) {
                    nazivVjezbe.setText(trbuh_gore[1]);
                    gif.setImageResource(R.drawable.puna_sklopka);
                }
                if (playlist.get(i - 1).equals(R.raw.noge_gore)) {
                    nazivVjezbe.setText(trbuh_gore[2]);
                    gif.setImageResource(R.drawable.noge_gore);
                }
                if (playlist.get(i - 1).equals(R.raw.ruke_ispred_trbusnjak)) {
                    nazivVjezbe.setText(trbuh_gore[3]);
                    gif.setImageResource(R.drawable.ruke_ispred_trbuh);
                }
                if (playlist.get(i - 1).equals(R.raw.ispruzene_sklopke)) {
                    nazivVjezbe.setText(trbuh_gore[4]);
                    gif.setImageResource(R.drawable.ravno_skupa);
                }
                if (playlist.get(i - 1).equals(R.raw.ruke_gore)) {
                    nazivVjezbe.setText(trbuh_gore[5]);
                    gif.setImageResource(R.drawable.ruke_gore);
                }
                if (playlist.get(i - 1).equals(R.raw.obicni)) {
                    nazivVjezbe.setText(trbuh_gore[6]);
                    gif.setImageResource(R.drawable.trbusnjak);
                }
                if (playlist.get(i - 1).equals(R.raw.dizanje_ruku)) {
                    nazivVjezbe.setText(trbuh_gore[7]);
                    gif.setImageResource(R.drawable.ruke_gore_trbuh);
                }

                if (playlist.get(i - 1).equals(R.raw.ravni_plank)) {
                    nazivVjezbe.setText(plank[0]);
                    gif.setImageResource(R.drawable.plank);
                }
                if (playlist.get(i - 1).equals(R.raw.ustranu_plank)) {
                    nazivVjezbe.setText(plank[1]);
                    gif.setImageResource(R.drawable.lijevi_plank);
                }
                if (playlist.get(i - 1).equals(R.raw.drzanje_sklopke)) {
                    nazivVjezbe.setText(plank[2]);
                    gif.setImageResource(R.drawable.v_drzanje);
                }
                if (playlist.get(i - 1).equals(R.raw.ukoceno_tijelo)) {
                    nazivVjezbe.setText(plank[3]);
                    gif.setImageResource(R.drawable.valjanje);
                }
                if (playlist.get(i - 1).equals(R.raw.plank_iza)) {
                    nazivVjezbe.setText(plank[4]);
                    gif.setImageResource(R.drawable.plank_iza);
                }

                if (playlist.get(i - 1).equals(R.raw.skvrcene_usko)) {
                    nazivVjezbe.setText(trbuh_stanga[0]);
                    gif.setImageResource(R.drawable.usko_skvrcene);
                }
                if (playlist.get(i - 1).equals(R.raw.ispruzene_usko)) {
                    nazivVjezbe.setText(trbuh_stanga[1]);
                    gif.setImageResource(R.drawable.usko_ispruzene);
                }
                if (playlist.get(i - 1).equals(R.raw.skvrcene_siroko)) {
                    nazivVjezbe.setText(trbuh_stanga[2]);
                    gif.setImageResource(R.drawable.siroko_skvrcene);
                }
                if (playlist.get(i - 1).equals(R.raw.ispruzene_siroko)) {
                    nazivVjezbe.setText(trbuh_stanga[3]);
                    gif.setImageResource(R.drawable.siroko_ispruzene);
                }
                if (playlist.get(i - 1).equals(R.raw.skvrcene_obje)) {
                    nazivVjezbe.setText(trbuh_stanga[4]);
                    gif.setImageResource(R.drawable.obje_skvrcene);
                }
                if (playlist.get(i - 1).equals(R.raw.ispruzene_obje)) {
                    nazivVjezbe.setText(trbuh_stanga[5]);
                    gif.setImageResource(R.drawable.obje_ispruzene);
                }

                if (playlist.get(i - 1).equals(R.raw.leznjak)) {
                    nazivVjezbe.setText(trbuh_razno[0]);
                    gif.setImageResource(R.drawable.leznjak);
                }
                if (playlist.get(i - 1).equals(R.raw.dizanje_kukova)) {
                    nazivVjezbe.setText(trbuh_razno[1]);
                    gif.setImageResource(R.drawable.dizanje_kukova);
                }
                if (playlist.get(i - 1).equals(R.raw.noge_gore_ustranu)) {
                    nazivVjezbe.setText(trbuh_razno[2]);
                    gif.setImageResource(R.drawable.noge_ustranu);
                }
                if (playlist.get(i - 1).equals(R.raw.krugovi_nogama)) {
                    nazivVjezbe.setText(trbuh_razno[3]);
                    gif.setImageResource(R.drawable.kruzenje_nogu);
                }
                if (playlist.get(i - 1).equals(R.raw.buba)) {
                    nazivVjezbe.setText(trbuh_razno[4]);
                    gif.setImageResource(R.drawable.buba);
                }

                if (playlist.get(i - 1).equals(R.raw.dodatni_trbusnjak)) {
                    nazivVjezbe.setText("dodatni trbušnjak");
                    gif.setImageResource(R.drawable.ruke_gore);
                }

                if (playlist.get(i - 1).equals(R.raw.rastezanje_trbuh)) {
                    nazivVjezbe.setText("trbuh rastezanje");
                    gif.setImageResource(R.drawable.gif_ph);
                    stopGifs = false;
                    setTrbuhRastezanjeGifs(gif);
                }
            });

            mp.setOnCompletionListener(vv -> playNext(pause));

            mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        mp.seekTo(progress);
                        mSeekBar.setProgress(progress);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });

            new Thread(() -> {
                while (mp != null) {
                    try {
                        if (mp.isPlaying()) {
                            Message msg = new Message();
                            msg.what = mp.getCurrentPosition();
                            handler.sendMessage(msg);
                            Thread.sleep(2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            nextIcon.setOnClickListener(v -> {
                if (i < playlist.size()) {
                    mp.stop();
                    int dur = mp.getDuration();
                    int curr = mp.getCurrentPosition();
                    int left = dur - curr;
                    totalDuration -= left;
                    playNext(pause);
                }
                setStopGifs();
            });

            prevIcon.setOnClickListener(v -> {
                mp.stop();
                i -= 2;
                playNext(pause);
            });

            pausePlay(pause, mp);
        }
    }

    void pausePlay(ImageView pause, MediaPlayer mp) {
        pause.setOnClickListener(vv -> {
            mp.pause();
            pause.setImageResource(R.drawable.play);
            pause.setOnClickListener(vvv -> {
                mp.start();
                pause.setImageResource(R.drawable.pause);
                stopProgress = false;
                pausePlay(pause, mp);
            });
            setStopGifs();
            stopProgress = true;
        });
    }

    public String createTimeLabel(int duration) {
        String timeLabel = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;
        timeLabel += min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;
        return timeLabel;
    }

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int current_position = msg.what;
            mSeekBar.setProgress(current_position);
            String cTime = createTimeLabel(current_position);
            curTime.setText(cTime);
        }
    };

    void setPrsaZagrijavanjeGifs(GifImageView gif) {
        new Thread(() -> {
            try {
                gif.setImageResource(R.drawable.gif_zglob);
                Thread.sleep(56576);
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.saka_ispruzena_stisnuta);
                    Thread.sleep(12321);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.gif_lakat);
                    Thread.sleep(44989);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.gif_rame);
                    Thread.sleep(22613);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.gif_ruka);
                    Thread.sleep(23848);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.ruke_stopala);
                    Thread.sleep(11439);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.kruzenje);
                }
            } catch (Exception e) {
                System.out.println("Error with thread");
                System.out.println(e);
            }
        }).start();
    }

    void setPrsaRastezanjeGifs(GifImageView gif) {
        new Thread(() -> {
            try {
                gif.setImageResource(R.drawable.joga);
                Thread.sleep(18204);
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.istezanje_zglob);
                    Thread.sleep(34942);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.istezanje_rame);
                    Thread.sleep(11858);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.istezanje_lakat);
                    Thread.sleep(12475);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.istezanje_ustranu);
                    Thread.sleep(12084);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.skroz_gore_dolje);
                    Thread.sleep(11449);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.vrat);
                }
            } catch (Exception e) {
                System.out.println("Error with thread");
                System.out.println(e);
            }
        }).start();
    }

    void setNogeZagrijavanjeGifs(GifImageView gif) {
        new Thread(() -> {
            try {
                gif.setImageResource(R.drawable.step);
                Thread.sleep(20612);
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.noge_iza);
                    Thread.sleep(20999);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.noge_strana);
                    Thread.sleep(21262);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.noge_ispred);
                    Thread.sleep(21013);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.visoki_step);
                    Thread.sleep(11053);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.skok);
                    Thread.sleep(10820);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.van_unutra);
                    Thread.sleep(11318);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.naprijed_nazad);
                    Thread.sleep(11378);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.kruzenje_koljena);
                    Thread.sleep(11238);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.bokovi);
                    Thread.sleep(35493);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.koljena);
                    Thread.sleep(45100);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.zglob_noga);
                }
            } catch (Exception e) {
                System.out.println("Error with thread");
                System.out.println(e);
            }
        }).start();
    }

    void setNogeRastezanjeGifs(GifImageView gif) {
        new Thread(() -> {
            try {
                gif.setImageResource(R.drawable.istezanje_naprijed);
                Thread.sleep(37713);
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.istezanje_strana);
                    Thread.sleep(37454);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.zenska_spaga);
                    Thread.sleep(43771);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.muska_spaga);
                    Thread.sleep(34603);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.ruke_do_stopala);
                    Thread.sleep(10994);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.joga5);
                }
            } catch (Exception e) {
                System.out.println("Error with thread");
                System.out.println(e);
            }
        }).start();
    }

    void setTrbuhZagrijavanjeGifs(GifImageView gif) {
        new Thread(() -> {
            try {
                gif.setImageResource(R.drawable.penjac);
                Thread.sleep(20623);
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.penjac_unutra);
                    Thread.sleep(20992);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.penjac_strana);
                    Thread.sleep(21086);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.ptica_pas);
                    Thread.sleep(20948);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.bicikl);
                }
            } catch (Exception e) {
                System.out.println("Error with thread");
                System.out.println(e);
            }
        }).start();
    }

    void setTrbuhRastezanjeGifs(GifImageView gif) {
        new Thread(() -> {
            try {
                gif.setImageResource(R.drawable.joga1);
                Thread.sleep(10997);
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.joga2);
                    Thread.sleep(10839);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.joga1);
                    Thread.sleep(10997);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.joga2);
                    Thread.sleep(10839);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.joga3);
                    Thread.sleep(2000);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.joga4);
                    Thread.sleep(2000);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.joga3);
                    Thread.sleep(2000);
                }
                if (!stopGifs) {
                    gif.setImageResource(R.drawable.joga4);
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                System.out.println("Error with thread");
                System.out.println(e);
            }
        }).start();
    }

    void setStopGifs() {
        stopGifs = true;
    }

    void setProgressBar() {
        ProgressBar pb = findViewById(R.id.progres);
        TextView trajanje = findViewById(R.id.trajanje);
        pb.setScaleY(3f);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (!stopProgress) {
                    totalDuration -= 5000;
                }
                pb.setProgress(totalDuration);
                trajanje.setText(setTrajanjeText(startDuration, totalDuration));
            }
        };
        t.schedule(tt, 0, 5000);
    }

    String setTrajanjeText(int startDuration, int totalDuration) {
        int trajanjeMinuteStart = startDuration / 60000;
        int trajanjeSekundeStart = (startDuration / 1000) % 60;
        int trajanjeMinute = totalDuration / 60000;
        int trajanjeSekunde = (totalDuration / 1000) % 60;
        return trajanjeMinute + " m " + trajanjeSekunde + " s / "
                + trajanjeMinuteStart + " m " + trajanjeSekundeStart + " s";
    }

}