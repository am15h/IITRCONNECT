package com.theimprovisers.iitrconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;

public class PersonalInfoAnctivity extends AppCompatActivity {

    public static  Profile profile;
    @BindView(R.id.text_email)
    EditText textEmail;

    @BindView(R.id.input_name)
    EditText inputName;

    @BindView(R.id.input_branch)
    EditText inputBranch;

    @BindView(R.id.input_year)
    EditText inputYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_anctivity);


    }



}
