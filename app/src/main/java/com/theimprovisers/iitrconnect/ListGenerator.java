package com.theimprovisers.iitrconnect;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.theimprovisers.iitrconnect.NetworkMethods;
import com.theimprovisers.iitrconnect.ResultTrigger;

public class ListGenerator
{
    public ResultTrigger trigger;
    public boolean taskComplete;
    public String tag;
    public ListGenerator(String nameTag,ResultTrigger resultTrigger)
    {
        this.trigger = resultTrigger;
        this.tag = nameTag;
        taskComplete = false;
        Print.print(tag+"FK");
        Print.print(NetworkMethods.COLLECTION_KEY+"FK");
        Query query = NetworkMethods.database.collection(NetworkMethods.COLLECTION_KEY).whereEqualTo(tag,true);
        Task<QuerySnapshot> snap = query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if (task.isSuccessful())
                {
                    Print.print("Big query success for "+tag+"no of element = "+task.getResult().size());
                    taskComplete = true;
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
