package com.theimprovisers.iitrconnect;

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
        profileListGenerator = new ProfileListGenerator(profile);

    }

    @Override
    public void OnSuccess()
    {

    }

    @Override
    public void OnFailure()
    {

    }
}
