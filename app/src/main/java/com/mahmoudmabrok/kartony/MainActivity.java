package com.mahmoudmabrok.kartony;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickList {
    
    String Tag = MainActivity.class.getSimpleName().toString();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;
    private ArrayList<VideoModel> modelList = new ArrayList<>();
    private VideoModel mVideoModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        modelList = VideoModel.getList();
        mAdapter = new RecyclerViewAdapter(MainActivity.this, modelList, this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onClick(int position) {
        mVideoModel = modelList.get(position);

        if (mVideoModel != null) {
            String url = mVideoModel.getMessage();
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            intent.putExtra("url", url);
            intent.putExtra("title", mVideoModel.getTitle());
            startActivity(intent);

        }
    }
}
