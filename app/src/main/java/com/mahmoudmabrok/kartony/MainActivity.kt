package com.mahmoudmabrok.kartony

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.mahmoudmabrok.kartony.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), ClickList {

    private var mAdapter: RecyclerViewAdapter? = null
    private var modelList = ArrayList<VideoModel>()
    private var mVideoModel: VideoModel? = null
    private var isLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this)

        modelList = VideoModel.getList()
        mAdapter = RecyclerViewAdapter(this@MainActivity, modelList, this)
        rvVideos.adapter = mAdapter


        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                isLoaded = true
                adView.visibility = View.VISIBLE
                Log.d("MainActivity", "onAdLoaded:")
            }
        }

    }


    override fun onResume() {
        super.onResume()
        if (isLoaded)
            adView.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        adView.visibility = View.GONE
    }

    override fun onClick(position: Int) {
        mVideoModel = modelList[position]
        if (mVideoModel != null) {
            val url = mVideoModel!!.message
            val intent = Intent(this@MainActivity, ShowActivity::class.java)
            intent.putExtra("url", url)
            intent.putExtra("title", mVideoModel!!.title)
            startActivity(intent)
        }
    }
}