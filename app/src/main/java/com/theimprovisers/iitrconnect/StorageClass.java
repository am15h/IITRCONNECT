package com.theimprovisers.iitrconnect;

import android.content.Context;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Constant with a file name
class StorageClass
{
    public static String fileName = "storageCache.bsdk";
    public Profile[] arrayProfile;

    // Serializes an object and saves it to a file
    public void saveToFile(Context context)
    {
        try
        {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void Write(ArrayList<Profile> list,Context context)
    {
        StorageClass s = new StorageClass();
        s.arrayProfile = list.toArray(new Profile[list.size()]);
        s.saveToFile(context);
    }
    public static ArrayList<Profile> Read(Context context)
    {
        StorageClass s = readFromFile(context);
        ArrayList<Profile> l = new ArrayList<Profile>();
        if (s.arrayProfile == null)
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
