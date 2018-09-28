package com.theimprovisers.iitrconnect;

public class Profile
{
    public String name;
    public String branch;
    public String email;
    public int year;
    public Tag[] tags;


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
}
