package com.theimprovisers.iitrconnect;

import android.content.Intent;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProfileListGenerator implements ResultTrigger
{
    public static Profile profile;
    public ResultTrigger resultTrigger;
    ArrayList<ListGenerator> listGenerators;
    ArrayList<Profile> profileArrayList;
    public ProfileListGenerator(Profile profile,ResultTrigger rTrig)
    {
        resultTrigger = rTrig;
        int tagSize = profile.tags.length;
        listGenerators = new ArrayList<ListGenerator>();

        for (int i = 0;i < tagSize;i++)
        {
            if (profile.tags[i].value)
            {
                listGenerators.add(new ListGenerator(profile.tags[i].name, this));
            }
        }
        profileArrayList = new ArrayList<Profile>();
        OnSuccess();
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
                listGenerators.get(i).Trigger();
                return;
            }
        }
        Print.print("Got all");
        for (int i = 0;i < listGenerators.size();i++)
        {
            Print.print("List has "+listGenerators.get(i).profileList.size());
            for (int x = 0;x < listGenerators.get(i).profileList.size();x++)
            {
                if (!listGenerators.get(i).profileList.get(x).email.equals(profile.email))
                {
                    int f = (Contains(listGenerators.get(i).profileList.get(x).email));
                    if (f != -1)
                    {
                        profileArrayList.get(f).count += 1;
                    }
                    else
                    {
                        profileArrayList.add(listGenerators.get(i).profileList.get(x));
                        profileArrayList.get(profileArrayList.size()-1).count++;
                    }
                }
            }
        }
        boolean sort = false;
        Profile[] p = new Profile[profileArrayList.size()];
        for (int i = 0;i < profileArrayList.size();i++)
        {
            p[i] = profileArrayList.get(i);
        }
        for (int i = 0;i < p.length;i++)
        {
            if (p[i].branch.toLowerCase().equals(profile.branch.toLowerCase()))
            {
                p[i].count += 2;
            }

            if (p[i].year == profile.year)
            {
                p[i].count += 2;
            }
        }
        for (int i = 0;i < p.length;i++)
        {
            p[i].count*= 10000;
            int sum = 0;
            for (int j = 0;j < p[i].tags.length;j++)
            {
                if (p[i].tags[j].value == true)
                {
                    sum += 1;
                }
            }
            if (sum > 0)
            {
                p[i].count /= sum;
            }
        }
        while (!sort)
        {
            sort = true;
            for (int i = 0;i+1 < p.length;i++)
            {
                if (p[i].count < p[i+1].count)
                {
                    Profile pp = p[i];
                    p[i] = p[i+1];
                    p[i+1] = pp;
                    sort = false;
                }
            }
        }
        for (int i = 0;i < p.length;i++)
        {
            Print.print("Common email "+p[i].email+"has no :"+p[i].count);
        }
        Print.print("Generated Final");
        AddConnectionsFragment.profiles = p;
        resultTrigger.OnSuccess();

    }

    int Contains(String email)
    {
        if (profileArrayList == null)
        {
            return  -1;
        }
        for (int i = 0;i < profileArrayList.size();i++)
        {
            if (profileArrayList.get(i).email.equals(email))
            {
                return i;
            }
        }
        return  -1;
    }
    boolean SecondContains(String email)
    {
        for (int i = 0;i < MyConnectionsFragment.profileArrayList.size();i++)
        {
            if (email.equals(MyConnectionsFragment.profileArrayList.get(i)))
            {
                return  true;
            }
        }
        return false;
    }
}
