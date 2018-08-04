package com.mahmoudmabrok.kartony;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ShowActivity extends YouTubeBaseActivity {

    static final String API_KEY = "AIzaSyDE_Bc3qQe7TZCICNPKbJVJ_6gbxd9aRyg";

    private static final String TAG = "ShowActivity";

    YouTubePlayerView playerView;
    YouTubePlayer mYouTubePlayer;

    private TextView textView;
    private TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        //   Log.v(TAG , "OnCreate") ;

        textView = findViewById(R.id.textViewError);
        textViewTitle = findViewById(R.id.textViewTitle);


        String title = getIntent().getStringExtra("title");
        textViewTitle.setText(title);


        playerView = findViewById(R.id.player1);
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                mYouTubePlayer = youTubePlayer;
                String url = getIntent().getStringExtra("url");
                if (isNetworkAvailable()) {
                    youTubePlayer.loadVideo(url);
                } else {
                    textView.setText(R.string.connect_error);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                if (youTubeInitializationResult.isUserRecoverableError()) {
               /*     youTubeInitializationResult.getErrorDialog(ShowActivity.this, R.string.app_name, new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            System.exit(0);
                        }
                    }).show();

               */

                    textView.setText(getString(R.string.youtube_error));
                }
            }
        });


    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    protected void onResume() {
        super.onResume();

        if (mYouTubePlayer != null) {
            mYouTubePlayer.play();
        }

        //   Log.v(TAG , "onResume");
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
