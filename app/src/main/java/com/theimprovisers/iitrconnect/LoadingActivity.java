package com.theimprovisers.iitrconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity implements ResultTrigger
{
    public static Profile profile;
    private ProfileListGenerator profileListGenerator;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        profile.Print();
        profileListGenerator = new ProfileListGenerator(profile,this);
    }

    @Override
    public void OnSuccess()
    {
        Intent i = new Intent(this,HomeActivity.class);
        startActivity(i);
    }

    @Override
    public void OnFailure()
    {

    }
}
