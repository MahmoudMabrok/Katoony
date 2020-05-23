package com.mahmoudmabrok.kartony

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mahmoudmabrok.kartony.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), ClickList {
    var Tag = MainActivity::class.java.simpleName
    private var mAdapter: RecyclerViewAdapter? = null
    private var modelList = ArrayList<VideoModel>()
    private var mVideoModel: VideoModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        modelList = VideoModel.getList()
        mAdapter = RecyclerViewAdapter(this@MainActivity, modelList, this)
        rvVideos.adapter = mAdapter
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