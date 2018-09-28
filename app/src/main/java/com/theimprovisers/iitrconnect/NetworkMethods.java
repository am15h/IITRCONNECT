package com.theimprovisers.iitrconnect;

import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;

public class NetworkMethods
{
    private static FirebaseFirestore database;
    private static boolean initialised = false;

    public static void Initialise(FirebaseFirestore database)
    {
        NetworkMethods.database = database;
        initialised = true;
        Log.d("NetworkMethods","Database initialised");
    }
}
