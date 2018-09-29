package com.theimprovisers.iitrconnect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {
    public static Profile profile;

    public TextView nameTextView;
    public TextView branchTextView;
    public TextView yearTextView;

    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_profile, container, false);

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
        yearTextView.setText(profile.year+" year");
    }
}
