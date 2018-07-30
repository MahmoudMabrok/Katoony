package com.mahmoudmabrok.kartony;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity {


    String Tag = MainActivity.class.getSimpleName().toString();
    private AdView mAdView;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;
    private ArrayList<VideoModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(Tag, "onCreate1");


        MobileAds.initialize(this,
                "ca-app-pub-8802187210935584~6180842695");


        recyclerView = findViewById(R.id.recycler_view);
        modelList = VideoModel.getList();
        mAdapter = new RecyclerViewAdapter(MainActivity.this, modelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdView = findViewById(R.id.adView);
        AdView adView = this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        if (isNetworkAvailable()) {
            adView.loadAd(adRequest);
            Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
