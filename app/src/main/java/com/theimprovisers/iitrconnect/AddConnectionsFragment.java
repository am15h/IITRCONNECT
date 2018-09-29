package com.theimprovisers.iitrconnect;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddConnectionsFragment extends Fragment  {
    public static Profile[] profiles;
    public  static Profile profile;

    private MyAdapter mAdapter;

    private RecyclerView mProfileRecycler;
    private Context context;

    /*  old
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    */

    public AddConnectionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        /*old
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_add);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
        */

        View layout= inflater.inflate(R.layout.fragment_add_connections, container, false);
        mProfileRecycler = (RecyclerView)layout.findViewById(R.id.recycler_add);


        return layout;

        //return inflater.inflate(R.layout.fragment_add_connections, container, false);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        ArrayList<Profile> profileArrayList = new ArrayList<>();
        for (int i = 0;i < AddConnectionsFragment.profiles.length;i++)
        {
            if (!SecondContains(AddConnectionsFragment.profiles[i].email))
            {
                profileArrayList.add(AddConnectionsFragment.profiles[i]);

            }
            else
            {
                Print.print("Remove");
            }
        }
        AddConnectionsFragment.profiles = profileArrayList.toArray(new Profile[profileArrayList.size()]);



        Log.i("Recycle", "reached there");

        mAdapter = new MyAdapter(getActivity(), profiles);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mProfileRecycler.setLayoutManager(layoutManager);
        mProfileRecycler.setAdapter(mAdapter);
    }

    boolean SecondContains(String email)
    {
        for (int i = 0;i < MyConnectionsFragment.profileArrayList.size();i++)
        {
            if (email.equals(MyConnectionsFragment.profileArrayList.get(i).email))
            {
                return  true;
            }
        }
        return false;
    }
}
