package com.mahmoudmabrok.kartony;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final ClickList clickList;
    private Context mContext;
    private ArrayList<VideoModel> modelList;


    public RecyclerViewAdapter(Context context, ArrayList<VideoModel> modelList, ClickList clickList) {
        this.mContext = context;
        this.modelList = modelList;
        this.clickList = clickList;
    }

    public void updateList(ArrayList<VideoModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final VideoModel model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.imgUser.setImageResource(R.drawable.cartoon);
            genericViewHolder.itemTxtTitle.setText(model.getTitle());
            genericViewHolder.itemTxtMessage.setText(model.getMessage());
/*
            genericViewHolder.imgUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickList.onClick(model);
                }
            });

            genericViewHolder.itemTxtTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickList.onClick(model);
                }
            });*/
        }
    }


    @Override
    public int getItemCount() {

        return modelList.size();
    }


    private VideoModel getItem(int position) {
        return modelList.get(position);
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgUser;
        private TextView itemTxtTitle;
        private TextView itemTxtMessage;



        public ViewHolder(final View itemView) {
            super(itemView);

            this.imgUser = itemView.findViewById(R.id.img_user);
            this.itemTxtTitle = itemView.findViewById(R.id.item_txt_title);
            this.itemTxtMessage = itemView.findViewById(R.id.item_txt_video_url);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            clickList.onClick(getAdapterPosition());
        }
    }
}

