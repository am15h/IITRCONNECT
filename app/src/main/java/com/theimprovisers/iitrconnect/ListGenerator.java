package com.theimprovisers.iitrconnect;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.theimprovisers.iitrconnect.NetworkMethods;
import com.theimprovisers.iitrconnect.ResultTrigger;

import java.util.ArrayList;
import java.util.List;

public class ListGenerator
{
    public ResultTrigger trigger;
    public boolean taskComplete;
    public String tag;
    List<DocumentSnapshot> docs = null;
    ArrayList<Profile> profileList = new ArrayList<Profile>();
    Task<QuerySnapshot> snap;
    public ListGenerator(String nameTag,ResultTrigger resultTrigger)
    {
        this.trigger = resultTrigger;
        this.tag = nameTag;
        taskComplete = false;
        Query query = NetworkMethods.database.collection(NetworkMethods.COLLECTION_KEY).whereEqualTo(tag,true);
        snap = query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if (task.isSuccessful())
                {
                    taskComplete = true;
                    docs = snap.getResult().getDocuments();
                    for (int i = 0;i < docs.size();i++)
                    {
                        Profile p =NetworkMethods.GetFromDoc(docs.get(i));
                        profileList.add(p);
                        p.Print();
                    }
                    trigger.OnSuccess();
                }
                else
                {
                    Log.i("App","Big query failed"+task.getException().getStackTrace());
                    trigger.OnFailure();
                }
            }
        });
    }
}
