package com.theimprovisers.iitrconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Loading extends AppCompatActivity implements ResultTrigger {


    public static FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Log.i("App","Sign in success");
        NetworkMethods.Initialise(FirebaseFirestore.getInstance());
        Log.i("App","Email is "+user.getEmail());
        NetworkMethods.ReadProfile(user.getEmail(), this);
    }

    @Override
    public void OnSuccess()
    {
        Profile profile = NetworkMethods.profileCache;
        if (profile != null)
        {
            PersonalInfoAnctivity.profile = profile;
            Intent intent = new Intent(this,PersonalInfoAnctivity.class);
            startActivity(intent);
        }
        else
        {
            ProfileActivity.profile = profile;
            Intent intent = new Intent(this,Profile.class);
            startActivity(intent);
        }
    }

    @Override
    public void OnFailure()
    {

    }
}
