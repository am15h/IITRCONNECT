package com.theimprovisers.iitrconnect;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MyIntrestsActivity extends AppCompatActivity {
private Button buttonProgrammingLanguage;
private Button buttonCulturalInterest;
private Button buttonSportsInterest;
private Button buttonClubs;
private String[] listItems;
private String[] listItemsProgrammingLanguage;
private String[] listItemsCulturalInterest;
private String[] listItemsSportsInterest;
private String[] listItemsClubs;

private boolean[] checkedItems;
private boolean[] checkedItemsProrgrammingLanguage;
private boolean[] checkedItemsSportsInterest;
private boolean[] checkedItemsCulturalInterest;
private boolean[] checkedItemsClubs;

private ArrayList<Integer>userItems = new ArrayList<>();
private ArrayList<Integer>userItemsProgrammingLanguage = new ArrayList<>();
private ArrayList<Integer>userItemsCulturalInterest = new ArrayList<>();
private ArrayList<Integer>userItemsSportsInterest = new ArrayList<>();
private ArrayList<Integer>userItemsClubs = new ArrayList<>();

    Profile mProfile = new Profile();
    Tag mTag;
    String[] tagsArray  = new String[mProfile.tags.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intrests);

        buttonProgrammingLanguage = (Button) findViewById(R.id.button_ProgrammingLaguage);

        for(int i = 0; i < mProfile.tags.length; i++) {
            tagsArray[i] = mProfile.tags[i].name;
        }
        //list
        listItemsProgrammingLanguage = Arrays.copyOfRange(tagsArray,0,5);
        checkedItemsProrgrammingLanguage = new boolean[listItemsProgrammingLanguage.length];

        buttonProgrammingLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MyIntrestsActivity.this);
                mBuilder.setTitle("Select Programming Language");
                mBuilder.setMultiChoiceItems(listItemsProgrammingLanguage, checkedItemsProrgrammingLanguage, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        //Operation here
                        if(isChecked){
                            //here i m adding in array list
                            if (!userItemsProgrammingLanguage.contains(position)){
                                userItemsProgrammingLanguage.add(position);
                            }else{
                                userItemsProgrammingLanguage.remove(position);
                            }
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for(int i = 0;i<userItemsProgrammingLanguage.size();i++){
                            //listItemsProgrammingLanguage[userItems.get(i)] gives the tags

                            //Code for Uploading goes here.

                        }
                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i =0;i<checkedItemsProrgrammingLanguage.length; i++ ){
                        checkedItemsProrgrammingLanguage[i] = false;
                        userItemsProgrammingLanguage.clear();
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });

        buttonCulturalInterest =(Button) findViewById(R.id.button_CulturalIntrest);



        buttonSportsInterest = (Button) findViewById(R.id.button_SportsIntrest);



        buttonClubs = (Button) findViewById(R.id.button_Clubs);



    }


}
