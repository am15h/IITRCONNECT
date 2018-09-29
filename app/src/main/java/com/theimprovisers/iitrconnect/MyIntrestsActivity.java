package com.theimprovisers.iitrconnect;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MyIntrestsActivity extends AppCompatActivity {
    public static Profile profile;

private Button buttonProgrammingLanguage;
private Button buttonCulturalInterest;
private Button buttonSportsInterest;
private Button buttonClubs;
private Button buttonFinish;


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

        buttonFinish = (Button) findViewById(R.id.finish_button);
        for(int i = 0; i < mProfile.tags.length; i++) {
            tagsArray[i] = mProfile.tags[i].name;
        }
        buttonProgrammingLanguage = (Button) findViewById(R.id.button_ProgrammingLaguage);

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

        listItemsCulturalInterest = Arrays.copyOfRange(tagsArray,5,10);
        buttonCulturalInterest =(Button) findViewById(R.id.button_CulturalIntrest);
        checkedItemsCulturalInterest = new boolean[listItemsCulturalInterest.length];

        buttonCulturalInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MyIntrestsActivity.this);
                mBuilder.setTitle("Select Cultural Interests");
                mBuilder.setMultiChoiceItems(listItemsCulturalInterest, checkedItemsCulturalInterest, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        //Operation here
                        if(isChecked){
                            //here i m adding in array list
                            if (!userItemsCulturalInterest.contains(position)){
                                userItemsCulturalInterest.add(position);
                            }else{
                                userItemsCulturalInterest.remove(position);
                            }
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for(int i = 0;i<userItemsCulturalInterest.size();i++){
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
                        for(int i =0;i<checkedItemsCulturalInterest.length; i++ ){
                            checkedItemsCulturalInterest[i] = false;
                            userItemsCulturalInterest.clear();
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });


        listItemsSportsInterest = Arrays.copyOfRange(tagsArray,10,15);
        buttonSportsInterest = (Button) findViewById(R.id.button_SportsIntrest);
        checkedItemsSportsInterest = new boolean[listItemsSportsInterest.length];

        buttonSportsInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MyIntrestsActivity.this);
                mBuilder.setTitle("Select your sport.");
                mBuilder.setMultiChoiceItems(listItemsSportsInterest, checkedItemsSportsInterest, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        //Operation here
                        if(isChecked){
                            //here i m adding in array list
                            if (!userItemsSportsInterest.contains(position)){
                                userItemsSportsInterest.add(position);
                            }else{
                                userItemsSportsInterest.remove(position);
                            }
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for(int i = 0;i<userItemsSportsInterest.size();i++){
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
                        for(int i =0;i<checkedItemsSportsInterest.length; i++ ){
                            checkedItemsSportsInterest[i] = false;
                            userItemsSportsInterest.clear();
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });


        listItemsClubs = Arrays.copyOfRange(tagsArray,15,20);
        buttonClubs = (Button) findViewById(R.id.button_Clubs);
        checkedItemsClubs = new boolean[listItemsClubs.length];
        buttonClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MyIntrestsActivity.this);
                mBuilder.setTitle("Select your Clubs.");
                mBuilder.setMultiChoiceItems(listItemsClubs, checkedItemsClubs, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        //Operation here
                        if(isChecked){
                            //here i m adding in array list
                            if (!userItemsClubs.contains(position)){
                                userItemsClubs.add(position);
                            }else{
                                userItemsClubs.remove(position);
                            }
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for(int i = 0;i<userItemsClubs.size();i++){
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
                        for(int i =0;i<checkedItemsClubs.length; i++ ){
                            checkedItemsClubs[i] = false;
                            userItemsClubs.clear();
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });


        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFinishClick();
            }
        });

    }

    public void onFinishClick()
    {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

}
