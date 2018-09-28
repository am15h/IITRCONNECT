package com.theimprovisers.iitrconnect;

import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.android.gms.tasks.*;

import android.widget.Toast;

import java.util.Map;

public class NetworkMethods
{
    public String COLLECTION_KEY = "Users";
    private static FirebaseFirestore database;
    private static boolean initialised = false;

    public static void Initialise(FirebaseFirestore database)
    {
        NetworkMethods.database = database;
        initialised = true;
        Log.i("NetworkMethods", "Database initialised");
    }

    public static void WriteProfile(Profile profile)
    {
        Map<String, Object> map = profile.GetMap();
        database.collection("Users").document("default").set(map).addOnSuccessListener(new OnSuccessListener<Void>()
        {
            @Override
            public void onSuccess(Void aVoid)
            {
                OnProfileWriteSuccess();
            }
        })
                .addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(Exception e)
                    {
                        OnProfileWriteFailed();
                    }
                });
    }

    public static void OnProfileWriteFailed()
    {
        Log.i("Network","Profile write Success");
    }
    public static void OnProfileWriteSuccess()
    {
        Log.i("Network","Profile write Success");
    }
}
