package com.theimprovisers.iitrconnect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyConnectionsFragment extends Fragment {
    public static Profile profile;
    public static Profile[] myProfiles;
    public static ArrayList<Profile> profileArrayList = new ArrayList<>();

    private MyAdapter mAdapter;

    private RecyclerView mProfileRecycler;

    public MyConnectionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Print.print("RENDER");
        myProfiles = new Profile[15];
        myProfiles[0] = new Profile("Amish","CSE","amish@gmail.com",1);
        myProfiles[1] = new Profile("Manas","CSE","amish@gmail.com",2);
        myProfiles[2] = new Profile("Utka","CSE","amish@gmail.com",3);

        for(int i = 0; i < 15;i++)
        {
            myProfiles[i] = new Profile("Utka","CSE","amish@gmail.com",3);
        }
        // I

        View layout = inflater.inflate(R.layout.fragment_my_connections,container,false);
        mProfileRecycler = (RecyclerView)layout.findViewById(R.id.recycler_my_connection);

        mAdapter = new MyAdapter(getActivity(),myProfiles);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mProfileRecycler.setLayoutManager(layoutManager);
        mProfileRecycler.setAdapter(mAdapter);

        return layout;


        //return inflater.inflate(R.layout.fragment_my_connections, container, false);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        myProfiles = profileArrayList.toArray(new Profile[profileArrayList.size()]);
        mAdapter = new MyAdapter(getActivity(),myProfiles);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mProfileRecycler.setLayoutManager(layoutManager);
        mProfileRecycler.setAdapter(mAdapter);
    }

}
