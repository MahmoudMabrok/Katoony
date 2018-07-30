package com.mahmoudmabrok.kartony;

import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ShowActivity extends YouTubeBaseActivity {

    static final String API_KEY = "AIzaSyDE_Bc3qQe7TZCICNPKbJVJ_6gbxd9aRyg";
    private static final String Video_URL = "wnNA94tOmGw";


    YouTubePlayerView playerView;
    YouTubePlayer mYouTubePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        playerView = findViewById(R.id.player1);
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                mYouTubePlayer = youTubePlayer;
                String url = getIntent().getStringExtra("url");
                youTubePlayer.loadVideo(url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                /*if (youTubeInitializationResult.isUserRecoverableError()) {

                    youTubeInitializationResult.getErrorDialog(ShowActivity.this, R.string.app_name, new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            System.exit(0);
                        }
                    }).show();
                }*/
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mYouTubePlayer != null) {
            mYouTubePlayer.play();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mYouTubePlayer != null) {

            mYouTubePlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (mYouTubePlayer != null &&
                getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT) {
            mYouTubePlayer.setFullscreen(false);  //it works
        } else {
            super.onBackPressed();
        }
    }


}
