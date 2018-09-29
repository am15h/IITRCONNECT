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
    public int count = 0;

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

        tags = new Tag[20];
        tags[0] = new Tag("tag0");
        tags[1] = new Tag("tag1");
        tags[2] = new Tag("tag2");
        tags[3] = new Tag("tag3");
        tags[4] = new Tag("tag4");
        tags[5] = new Tag("tag5");
        tags[6] = new Tag("tag6");
        tags[7] = new Tag("tag7");
        tags[8] = new Tag("tag8");
        tags[9] = new Tag("tag9");
        tags[10] = new Tag("tag10");
        tags[11] = new Tag("tag11");
        tags[12] = new Tag("tag12");
        tags[13] = new Tag("tag13");
        tags[14] = new Tag("tag14");
        tags[15] = new Tag("tag15");
        tags[16] = new Tag("tag16");
        tags[17] = new Tag("tag17");
        tags[18] = new Tag("tag18");
        tags[19] = new Tag("tag19");

        count = 0;
    }
    public Profile()
    {
        this.name = "";
        this.branch = "";
        this.email = "";
        this.year = 0;

        tags = new Tag[20];
        tags[0] = new Tag("tag0");
        tags[1] = new Tag("tag1");
        tags[2] = new Tag("tag2");
        tags[3] = new Tag("tag3");
        tags[4] = new Tag("tag4");
        tags[5] = new Tag("tag5");
        tags[6] = new Tag("tag6");
        tags[7] = new Tag("tag7");
        tags[8] = new Tag("tag8");
        tags[9] = new Tag("tag9");
        tags[10] = new Tag("tag10");
        tags[11] = new Tag("tag11");
        tags[12] = new Tag("tag12");
        tags[13] = new Tag("tag13");
        tags[14] = new Tag("tag14");
        tags[15] = new Tag("tag15");
        tags[16] = new Tag("tag16");
        tags[17] = new Tag("tag17");
        tags[18] = new Tag("tag18");
        tags[19] = new Tag("tag19");
        count = 0;
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
