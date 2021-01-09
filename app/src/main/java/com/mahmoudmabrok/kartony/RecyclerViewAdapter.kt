package com.mahmoudmabrok.kartony

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import java.util.*

/**
 * A custom adapter to use with the RecyclerView widget.
 */
class RecyclerViewAdapter(private val mContext: Context,
                          private var modelList: ArrayList<VideoModel>, val clickList: ClickList) :
        RecyclerView.Adapter<RecyclerViewAdapter.VideoViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_recycler_list, viewGroup, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) { //Here you can fill your row view

        val model = getItem(position)
        holder.imgUser.setImageResource(R.drawable.cartoon)
        holder.imgUser.load("https://img.youtube.com/vi/${model.message}/default.jpg")

        holder.itemTxtTitle.text = model.title
   //     holder.itemTxtMessage.text = model.message

    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    private fun getItem(position: Int): VideoModel {
        return modelList[position]
    }


    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imgUser: ImageView = itemView.findViewById(R.id.img_user)
        val itemTxtTitle: TextView = itemView.findViewById(R.id.item_txt_title)
        // val itemTxtMessage: TextView = itemView.findViewById(R.id.item_txt_video_url)

        override fun onClick(v: View) {
            clickList.onClick(adapterPosition)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

}