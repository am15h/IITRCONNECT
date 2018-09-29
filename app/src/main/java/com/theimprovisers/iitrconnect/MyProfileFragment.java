package com.theimprovisers.iitrconnect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {
    public static Profile profile;

    private ViewProfileAdapter mAdapter;

    private RecyclerView mProfileRecycler;

    public TextView nameTextView;
    public TextView branchTextView;
    public TextView yearTextView;
    public static String[] tagsArray;
    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout= inflater.inflate(R.layout.fragment_my_profile, container, false);
        mProfileRecycler = (RecyclerView)layout.findViewById(R.id.recyclerMy);

        Log.i("Recycle", "reached there");
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0;i < profile.tags.length;i++)
        {
            if (profile.tags[i].value)
            {
                arr.add(profile.tags[i].name);
            }
        }
        tagsArray = arr.toArray(new String[arr.size()]);
        mAdapter = new ViewProfileAdapter(getActivity(), tagsArray);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mProfileRecycler.setLayoutManager(layoutManager);
        mProfileRecycler.setAdapter(mAdapter);

        return layout;

       // return inflater.inflate(R.layout.fragment_my_profile, container, false);

    }

    @Override
    public void onResume()
    {
        super.onResume();
        Print.print("Resume");
        nameTextView = (TextView)getView().findViewById(R.id.textView_name);
        branchTextView = (TextView)getView().findViewById(R.id.textView_Branch);
        yearTextView = (TextView)getView().findViewById(R.id.textView_Year);

        nameTextView.setText(profile.name);
        branchTextView.setText(profile.branch);
        yearTextView.setText(profile.year+" Year");
    }
}
