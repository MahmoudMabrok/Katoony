package com.mahmoudmabrok.kartony

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.mahmoudmabrok.kartony.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), ClickList {

    private lateinit var mBinding: ActivityMainBinding
    private var mAdapter: RecyclerViewAdapter? = null
    private var modelList = ArrayList<VideoModel>()
    private var mVideoModel: VideoModel? = null
    private var isLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        MobileAds.initialize(this)

        modelList = VideoModel.getList()
        mAdapter = RecyclerViewAdapter(this@MainActivity, modelList, this)
        mBinding.rvVideos.adapter = mAdapter


        val adRequest = AdRequest.Builder().build()
        mBinding.adView.loadAd(adRequest)
        mBinding.adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                isLoaded = true
                mBinding.adView.visibility = View.VISIBLE
                Log.d("MainActivity", "onAdLoaded:")
            }
        }

    }


    override fun onResume() {
        super.onResume()
        if (isLoaded)
            mBinding.adView.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        mBinding.adView.visibility = View.GONE
    }

    override fun onClick(position: Int) {
        mVideoModel = modelList[position]
        if (mVideoModel != null) {
            val url = mVideoModel!!.message
            val intent = Intent(this@MainActivity, ShowActivity::class.java)
            intent.putExtra("id", url)
            intent.putExtra("title", mVideoModel!!.title)
            startActivity(intent)
        }
    }
}