package com.theimprovisers.iitrconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements ResultTrigger
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkMethods.Initialise(FirebaseFirestore.getInstance());
        Profile sampleProfile = new Profile("alpha","cse","beta@gmail",1);
        //NetworkMethods.WriteProfile(sampleProfile,this);
        //NetworkMethods.ReadProfile("default",this);

    }

    @Override
    public void OnFailure()
    {
        Log.i("Main","FAilure");
    }

    @Override
    public void OnSuccess()
    {
        Log.i("Main","Success");
    }
}
