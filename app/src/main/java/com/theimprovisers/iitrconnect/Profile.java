package com.theimprovisers.iitrconnect;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Profile
{
    public String name;
    public String branch;
    public String email;
    public int year;
    public Tag[] tags;

    public static String NAME_KEY = "name";
    public static String BRANCH_KEY = "branch";
    public static String EMAIL_KEY = "email";
    public static String YEAR_KEY = "year";



    // Constructor
    public Profile(String name,String branch,String email,int year)
    {
        this.name = name;
        this.branch = branch;
        this.email = email;
        this.year = year;

        tags = new Tag[5];
        tags[0] = new Tag("tag0");
        tags[1] = new Tag("tag1");
        tags[2] = new Tag("tag2");
        tags[3] = new Tag("tag3");
        tags[4] = new Tag("tag4");
    }
    public Profile()
    {
        this.name = "";
        this.branch = "";
        this.email = "";
        this.year = 0;

        tags = new Tag[5];
        tags[0] = new Tag("tag0");
        tags[1] = new Tag("tag1");
        tags[2] = new Tag("tag2");
        tags[3] = new Tag("tag3");
        tags[4] = new Tag("tag4");
    }

    public Map<String,Object> GetMap()
    {
        Map<String,Object> map = new HashMap<>();
        map.put(NAME_KEY,name);
        map.put(BRANCH_KEY,branch);
        map.put(EMAIL_KEY,email);
        map.put(YEAR_KEY,year);

        for (int i = 0;i < tags.length;i++)
        {
            map.put(tags[i].name,tags[i].value);
        }
        return map;
    }
    public void Print()
    {
        StringBuilder bld = new StringBuilder();
        bld.append(name);
        bld.append(" ");
        bld.append(email);
        bld.append(" ");
        bld.append(branch);
        bld.append(" ");
        bld.append(year);
        bld.append(" ");
        for(int i = 0;i < tags.length;i++)
        {
            bld.append(tags[i].value);
            bld.append(" ");
        }
        Log.i("App",bld.toString());
    }
}
