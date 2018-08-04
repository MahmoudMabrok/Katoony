package com.mahmoudmabrok.kartony;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickList {


    String Tag = MainActivity.class.getSimpleName().toString();
    private AdView mAdView;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;
    private ArrayList<VideoModel> modelList = new ArrayList<>();
    private InterstitialAd mInterstitialAd;
    private VideoModel mVideoModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log.v(Tag, "onCreate1");

/*

        MobileAds.initialize(this,
                "ca-app-pub-8802187210935584~6180842695");
*/


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        modelList = VideoModel.getList();
        mAdapter = new RecyclerViewAdapter(MainActivity.this, modelList, this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8802187210935584/8192379047");


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                if (mVideoModel != null) {
                    String url = mVideoModel.getMessage();
                    Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("title", mVideoModel.getTitle());
                    startActivity(intent);
                }
                if (isNetworkAvailable()) {
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }
            }

            @Override
            public void onAdLoaded() {
            }
        });

        if (isNetworkAvailable()) {
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onClick(int position) {
        mVideoModel = modelList.get(position);

        if (mInterstitialAd.isLoaded())
            mInterstitialAd.show();

        else {
            if (mVideoModel != null) {
                String url = mVideoModel.getMessage();
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("title", mVideoModel.getTitle());
                startActivity(intent);

            }
            //     Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
