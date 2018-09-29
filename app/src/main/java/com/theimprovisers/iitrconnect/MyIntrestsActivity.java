package com.theimprovisers.iitrconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyIntrestsActivity extends AppCompatActivity {
private Button buttonProgrammingLanguage;
private Button buttonCulturalIntrest;
private Button buttonSportsIntrest;
private Button buttonClubs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intrests);

        buttonProgrammingLanguage = (Button) findViewById(R.id.button_ProgrammingLaguage);
        buttonCulturalIntrest =(Button) findViewById(R.id.button_CulturalIntrest);
        buttonSportsIntrest = (Button) findViewById(R.id.button_SportsIntrest);
        buttonClubs = (Button) findViewById(R.id.button_Clubs);

        buttonProgrammingLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
    }
}
