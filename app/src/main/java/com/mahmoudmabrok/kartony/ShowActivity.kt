package com.mahmoudmabrok.kartony

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mahmoudmabrok.kartony.databinding.ActivityShowBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


class ShowActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val title = intent.getStringExtra("title")

        val id = intent.getStringExtra("id") ?: ""
        mBinding.textViewTitle.text = title

        lifecycle.addObserver(mBinding.youtubePlayerView)

        mBinding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(id, 0f)
            }
        })


    }

}