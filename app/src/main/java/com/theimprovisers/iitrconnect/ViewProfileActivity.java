package com.theimprovisers.iitrconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class ViewProfileActivity extends AppCompatActivity {
    public static Profile profile;
    public static Profile currentProfile;
    public static String[] tagsArray;
    private ViewProfileAdapter mAdapter;

    private RecyclerView mProfileRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        currentProfile = new Profile("Dummy","dummybranch","email @ dummy",2);
        tagsArray = new String[10];
        for(int i = 0; i < 10;i++)
        {
            tagsArray[i] = "Javaasfsdf";
        }
        mProfileRecycler = (RecyclerView)findViewById(R.id.recyclerView);

        Log.i("Recycle", "reached there");

        mAdapter = new ViewProfileAdapter(this, tagsArray);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mProfileRecycler.setLayoutManager(layoutManager);
        mProfileRecycler.setAdapter(mAdapter);


    }
}
