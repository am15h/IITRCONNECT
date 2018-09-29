package com.theimprovisers.iitrconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalInfoAnctivity extends AppCompatActivity {

    public static  Profile profile;
    TextView textEmail;
    Button nextButton;
    EditText inputName;
    EditText inputBranch;
    EditText inputYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_anctivity);
        Log.i("App","reached"+profile.email);
        textEmail = (TextView)findViewById(R.id.text_email);
        nextButton  = (Button)findViewById(R.id.next_button);
        inputName = (EditText)findViewById(R.id.input_name);
        inputBranch = (EditText)findViewById(R.id.input_branch);
        inputYear = (EditText)findViewById((R.id.input_year));

        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onNextClick();
            }
        });
        textEmail.setText("hello");
    }


    public void onNextClick()
    {
        profile.name = inputName.getText().toString();
        profile.branch = inputBranch.getText().toString();
        profile.year = Integer.parseInt(inputYear.getText().toString());
        nextButton.setVisibility(View.GONE);
    }

}
