package com.theimprovisers.iitrconnect;

import java.util.ArrayList;

public class ProfileListGenerator implements ResultTrigger
{
    public static Profile profile;
    ArrayList<ListGenerator> listGenerators;
    public ProfileListGenerator(Profile profile)
    {

        int tagSize = profile.tags.length;
        Print.print("Ref 1");
        listGenerators = new ArrayList<ListGenerator>();

        for (int i = 0;i < tagSize;i++)
        {
            Print.print("list no "+i);
            listGenerators.add(new ListGenerator(profile.tags[i].name.toString(),this));
        }
    }

    @Override
    public void OnFailure()
    {

    }

    @Override
    public void OnSuccess()
    {
        for (int i = 0;i < listGenerators.size();i++)
        {
            if (listGenerators.get(i).taskComplete == false)
            {
                return;
            }
        }

    }
}
