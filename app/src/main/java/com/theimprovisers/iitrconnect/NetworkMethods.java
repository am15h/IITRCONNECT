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
    public static ResultTrigger trigger;

    public static void Initialise(FirebaseFirestore database)
    {
        NetworkMethods.database = database;
        initialised = true;
        Log.i("App", "Database initialised"+database.toString());
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
        NetworkMethods.trigger = trigger;
        DocumentReference user = database.collection(COLLECTION_KEY).document(index);
        Log.i("App","Step 1"+index);
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                Log.i("App","Complete"+task.isSuccessful());
                if (task.isSuccessful())
                {
                    DocumentSnapshot doc = task.getResult();
                    Object name = doc.get(Profile.NAME_KEY);
                    Object email = doc.get(Profile.EMAIL_KEY);
                    Object branch = doc.get(Profile.BRANCH_KEY);
                    Object year = doc.get(Profile.YEAR_KEY);

                    Log.i("App","REF2"+(name != null && email != null && branch != null && year != null));
                    if (name != null && email != null && branch != null && year != null)
                    {
                        Log.i("App","IFFFFFF");
                        Profile profile = new Profile((String)name,(String)email,(String)branch,(int)((long)year));
                        boolean validTags = true;
                        for (int i = 0;i < profile.tags.length;i++)
                        {
                            Object tagObj = doc.get(profile.tags[i].name);
                            if (tagObj != null)
                            {
                                profile.tags[i].value = (Boolean)(tagObj);
                            }
                            else
                            {
                                validTags = false;
                                break;
                            }
                        }
                        if (validTags)
                        {
                            profileCache = profile;
                            profile.Print();
                            Log.i("App", "Profile loading success");
                            NetworkMethods.trigger.OnSuccess();
                        }
                        else
                        {
                            profileCache = null;
                            NetworkMethods.trigger.OnSuccess();
                            Log.i("App", "Profile loading failed");
                        }
                    }
                    else
                    {
                        Log.i("App", "Profile loading failed");
                        profileCache = null;
                        NetworkMethods.trigger.OnSuccess();
                    }

                }
                else
                {
                    Log.i("App","FAiled");
                    Exception e = task.getException();
                    NetworkMethods.trigger.OnFailure();
                }
            }
        });
    }
}
