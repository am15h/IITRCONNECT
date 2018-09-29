package com.theimprovisers.iitrconnect;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.content.Context.MODE_PRIVATE;

// Constant with a file name
class StorageClass
{
    public static String fileName = "storageCache.ser";
    public static SharedPreferences mPref;
    public Profile[] arrayProfile;

    // Serializes an object and saves it to a file
    public void saveToFile(Context context)
    {
        try
        {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
            Print.print("Saved");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Print.print("Error");
        }
    }
    public static void Write(ArrayList<Profile> list)
    {
        StorageClass s = new StorageClass();
        s.arrayProfile = list.toArray(new Profile[list.size()]);
        SharedPreferences.Editor prefsEditor = StorageClass.mPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(s);
        prefsEditor.putString("MyObject", json);
        prefsEditor.commit();
        Print.print("SAved"+json);
    }
    public static ArrayList<Profile> Read()
    {

        Gson gson = new Gson();
        String json = StorageClass.mPref.getString("MyObject", "");
        Print.print(json);
        StorageClass s = gson.fromJson(json, StorageClass.class);
        ArrayList<Profile> l = new ArrayList<Profile>();
        Print.print("Read");
        if (s == null)
        {
            return  l;
        }
        for (int i = 0;i < s.arrayProfile.length;i++)
        {
            l.add(s.arrayProfile[i]);
        }
        return l;
    }


    // Creates an object by reading it from a file
    public static StorageClass readFromFile(Context context)
    {
        StorageClass createResumeForm = null;
        try
        {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            createResumeForm = (StorageClass) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return createResumeForm;
    }
}
