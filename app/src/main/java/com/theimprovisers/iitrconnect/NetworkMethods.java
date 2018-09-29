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
    public static FirebaseFirestore database;
    private static boolean initialised = false;
    public static Profile profileCache;
    public static ResultTrigger trigger;

    public static void Initialise(FirebaseFirestore database)
    {
        NetworkMethods.database = database;
        initialised = true;
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
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                Log.i("App", "Complete" + task.isSuccessful());
                if (task.isSuccessful())
                {
                    profileCache = GetFromDoc(task.getResult());
                    NetworkMethods.trigger.OnSuccess();
                }
                else
                {
                    Exception e = task.getException();
                    NetworkMethods.trigger.OnFailure();
                }
            }
        });
    }

    public static Profile GetFromDoc(DocumentSnapshot doc)
    {
        if (!doc.exists())
        {
            return null;
        }
        Object name = doc.get(Profile.NAME_KEY);
        Object email = doc.get(Profile.EMAIL_KEY);
        Object branch = doc.get(Profile.BRANCH_KEY);
        Object year = doc.get(Profile.YEAR_KEY);
        Profile profile = new Profile((String) name, (String) branch, (String) email, (int) ((long) year));
        boolean validTags = true;
        for (int i = 0; i < profile.tags.length; i++)
        {
            Object tagObj = doc.get(profile.tags[i].name);
            profile.tags[i].value = (Boolean) (tagObj);
        }
        return profile;
    }
}
