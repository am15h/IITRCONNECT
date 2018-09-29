package com.theimprovisers.iitrconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ResultTrigger
{
    public static Profile profile;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
/*
        setContentView(R.layout.activity_main);
        NetworkMethods.Initialise(FirebaseFirestore.getInstance());
        Random rnd = new Random();

        Profile sampleProfile = new Profile("Random"+rnd.nextInt(),"cse"+rnd.nextInt(),rnd.nextInt()+"email@gmail",rnd.nextInt(5));
        for (int i = 0;i < sampleProfile.tags.length;i++)
        {
            sampleProfile.tags[i].value = rnd.nextBoolean();
        }
        NetworkMethods.WriteProfile(sampleProfile,this);
        //NetworkMethods.ReadProfile("default",this);
*/
    Profile p1 = new Profile("sdgk","awojf","saf",2);
    Profile p2 = new Profile("aflsal","sfsf","sfkhn",3);
        //ArrayList<Profile> list = new ArrayList<Profile>();
        //ArrayList<Profile> list = StorageClass.Read(getPreferences(MODE_PRIVATE));

        /*list.add(p1);
        list.add(p2);
        StorageClass.Write(list,getPreferences(MODE_PRIVATE));
*/
        /*
        for (int i = 0;i < list.size();i++)
        {
            list.get(i).Print();
        }*/
    }

    @Override
    public void OnFailure()
    {
        Log.i("Main","FAilure");
    }

    @Override
    public void OnSuccess()
    {/*
        Random rnd = new Random();
        Profile sampleProfile = new Profile("Random"+rnd.nextInt(),"cse"+rnd.nextInt(),rnd.nextInt()+"email@gmail",rnd.nextInt(5));
        for (int i = 0;i < sampleProfile.tags.length;i++)
        {
            sampleProfile.tags[i].value = rnd.nextBoolean();
        }
        NetworkMethods.WriteProfile(sampleProfile,this);
        Log.i("Main","Success");*/
    }
}
