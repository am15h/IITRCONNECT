package com.theimprovisers.iitrconnect;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.firestore.*;
import com.google.android.gms.tasks.*;

import android.widget.Toast;

import java.util.Map;

public class NetworkMethods
{
    public static String COLLECTION_KEY = "Users";
    private static FirebaseFirestore database;
    private static boolean initialised = false;
    public static Profile profileCache;

    public static void Initialise(FirebaseFirestore database)
    {
        NetworkMethods.database = database;
        initialised = true;
        Log.i("App", "Database initialised");
    }

    public static void WriteProfile(Profile profile, final ResultTrigger trigger)
    {
        Map<String, Object> map = profile.GetMap();
        database.collection(COLLECTION_KEY).document(profile.email).set(map).addOnSuccessListener(new OnSuccessListener<Void>()
        {
            @Override
            public void onSuccess(Void aVoid)
            {
                trigger.OnSuccess();
            }
        })
                .addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Log.e("Network", e.toString());
                        trigger.OnFailure();
                    }
                });
    }

    public static void ReadProfile(String index, final ResultTrigger trigger)
    {
        DocumentReference user = database.collection(COLLECTION_KEY).document(index);
        Log.i("App","Step 1");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if (task.isSuccessful())
                {
                    DocumentSnapshot doc = task.getResult();
                    trigger.OnSuccess();
                    Object name = doc.get(Profile.NAME_KEY);
                    Object email = doc.get(Profile.EMAIL_KEY);
                    Object branch = doc.get(Profile.BRANCH_KEY);
                    Object year = doc.get(Profile.YEAR_KEY);
                    StringBuilder fields = new StringBuilder("");
                    if (name != null && email != null && branch != null && year != null)
                    {
                        Profile profile = new Profile((String)name,(String)email,(String)branch,(int)((long)year));
                        for (int i = 0;i < profile.tags.length;i++)
                        {
                            Object tagObj = doc.get(profile.tags[i].name);
                            if (tagObj != null)
                            {
                                profile.tags[i].value = (Boolean)(tagObj);
                            }
                            else
                            {
                                profileCache = null;
                                trigger.OnSuccess();
                                return;
                            }
                        }
                        profileCache = profile;
                        profile.Print();
                        Log.i("App","Profile loading success");
                        trigger.OnSuccess();
                        return;
                    }
                    profileCache = null;
                    trigger.OnSuccess();
                    Log.i("App","Profile loading failed");
                    //profileCache = profile;

                }
            }
        })
                .addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Log.e("App", e.getStackTrace().toString());
                        trigger.OnFailure();
                    }
                });
    }

    public static void OnProfileWriteFailed()
    {
        Log.i("Network", "Profile write Success");
    }

    public static void OnProfileWriteSuccess()
    {
        Log.i("Network", "Profile write Success");
    }
}
