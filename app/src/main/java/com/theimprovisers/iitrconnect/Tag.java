package com.theimprovisers.iitrconnect;

public class Tag
{
    public String name;
    public boolean value;

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
