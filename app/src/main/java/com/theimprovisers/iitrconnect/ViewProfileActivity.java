package com.theimprovisers.iitrconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewProfileActivity extends AppCompatActivity {
    public static Profile profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
    }
}