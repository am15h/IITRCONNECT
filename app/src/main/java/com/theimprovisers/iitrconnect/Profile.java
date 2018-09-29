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
        tags[0] = new Tag("Web Development");
        tags[1] = new Tag("App Development");
        tags[2] = new Tag("Game Development");
        tags[3] = new Tag("Backend Development");
        tags[4] = new Tag("Competitive Programming");

        tags[5] = new Tag("Dance");
        tags[6] = new Tag("Fine Arts");
        tags[7] = new Tag("Dramatics");
        tags[8] = new Tag("Music");
        tags[9] = new Tag("Culinary");

        tags[10] = new Tag("Football");
        tags[11] = new Tag("Cricket");
        tags[12] = new Tag("Badminton");
        tags[13] = new Tag("Basketball");
        tags[14] = new Tag("Hockey");

        tags[15] = new Tag("SDS");
        tags[16] = new Tag("PAG");
        tags[17] = new Tag("MDG");
        tags[18] = new Tag("InfoSec");
        tags[19] = new Tag("DSG");

        count = 0;
    }
    public Profile()
    {
        this.name = "";
        this.branch = "";
        this.email = "";
        this.year = 0;

        tags = new Tag[20];
        tags[0] = new Tag("Web Development");
        tags[1] = new Tag("App Development");
        tags[2] = new Tag("Game Development");
        tags[3] = new Tag("Backend Development");
        tags[4] = new Tag("COBOL Lovers");

        tags[5] = new Tag("Dance");
        tags[6] = new Tag("Fine Arts");
        tags[7] = new Tag("Dramatics");
        tags[8] = new Tag("Music");
        tags[9] = new Tag("Culinary");

        tags[10] = new Tag("Football");
        tags[11] = new Tag("Cricket");
        tags[12] = new Tag("Badminton");
        tags[13] = new Tag("Basketball");
        tags[14] = new Tag("Hockey");

        tags[15] = new Tag("SDS");
        tags[16] = new Tag("PAG");
        tags[17] = new Tag("MDG");
        tags[18] = new Tag("InfoSec");
        tags[19] = new Tag("DSG");
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
