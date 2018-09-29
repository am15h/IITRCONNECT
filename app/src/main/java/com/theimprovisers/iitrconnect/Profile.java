package com.theimprovisers.iitrconnect;

import com.google.firebase.auth.FirebaseUser;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
