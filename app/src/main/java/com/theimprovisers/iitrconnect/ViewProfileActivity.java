package com.theimprovisers.iitrconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

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
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0;i < currentProfile.tags.length;i++)
        {
            if (currentProfile.tags[i].value)
            {
                if (profile.tags[i].value)
                {
                    list.add("#Common# "+currentProfile.tags[i].name);
                }
                else
                {
                    list.add("    "+currentProfile.tags[i].name);
                }
            }
        }
        ((TextView)findViewById(R.id.textView_name)).setText(currentProfile.name);
        ((TextView)findViewById(R.id.textView_Year)).setText(currentProfile.year+" YEAR");
        ((TextView)findViewById(R.id.textView_Branch)).setText(currentProfile.branch);

        tagsArray = list.toArray(new String[list.size()]);
        mProfileRecycler = (RecyclerView)findViewById(R.id.recyclerMy);

        Log.i("Recycle", "reached there");

        mAdapter = new ViewProfileAdapter(this, tagsArray);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mProfileRecycler.setLayoutManager(layoutManager);
        mProfileRecycler.setAdapter(mAdapter);


    }
}
