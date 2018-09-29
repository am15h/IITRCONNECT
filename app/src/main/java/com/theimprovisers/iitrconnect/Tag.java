package com.theimprovisers.iitrconnect;

public class Tag
{
    public String name;
    public boolean value;
    public static Tag[] predefinedTags = {new Tag("tag0"),new Tag("tag1"),new Tag("tag2"),new Tag("tag3"),new Tag("tag4")};

    public Tag(String name,boolean value)
    {
        this.name = name;
        this.value = value;
    }
    public Tag(String name)
    {
        this.name = name;
        value = false;
    }
}
