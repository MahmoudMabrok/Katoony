package com.mahmoudmabrok.kartony;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.danikula.videocache.HttpProxyCacheServer;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity {

    private static final String API_KEY = "AIzaSyDE_Bc3qQe7TZCICNPKbJVJ_6gbxd9aRyg";
    private static final String LIST_ULR = "PL7ZA5t6QDestYCkSzHmYbVI1zjMisbBK1";
    private static final String Video_URL = "wnNA94tOmGw";


    YouTubePlayerView playerView;
    YouTubePlayer mYouTubePlayer;


    private RecyclerView recyclerView;

    // @BindView(R.id.recycler_view)
    // RecyclerView recyclerView;


    private RecyclerViewAdapter mAdapter;

    private ArrayList<VideoModel> modelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playerView = (YouTubePlayerView) findViewById(R.id.player1);

        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                Toast.makeText(MainActivity.this, "intialize ", Toast.LENGTH_SHORT).show();
                mYouTubePlayer = youTubePlayer;
                mYouTubePlayer.loadVideo(Video_URL);

                mAdapter.setYouTubePlayer(youTubePlayer);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


       /* HttpProxyCacheServer proxy = getProxy();
        String proxyUrl = proxy.getProxyUrl(Video_URL);*/
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        modelList = VideoModel.getList();
        mAdapter = new RecyclerViewAdapter(MainActivity.this, modelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);


    }

    private HttpProxyCacheServer getProxy() {
        return App.getProxy(this);
    }

    public void onOne(View view) {
        if (mYouTubePlayer != null) {

            if (mYouTubePlayer.isPlaying()) {
                mYouTubePlayer.pause();
            }
            mYouTubePlayer.loadVideo(Video_URL);
        }
    }

    public void onTwo(View view) {
        if (mYouTubePlayer != null) {

            if (mYouTubePlayer.isPlaying()) {
                mYouTubePlayer.pause();
            }
            mYouTubePlayer.loadVideo(Video_URL);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mYouTubePlayer.release();
    }

    @Override
    public void onBackPressed() {

        if (mYouTubePlayer != null) {
            if (mYouTubePlayer.isPlaying())
                mYouTubePlayer.pause();
            mYouTubePlayer.setFullscreen(false);  //it works
        } else
            super.onBackPressed();
    }

    public void PlayNext(View view) {
        if (mYouTubePlayer != null) {
            if (mYouTubePlayer.hasNext())
                mYouTubePlayer.next();

        }
    }


}
