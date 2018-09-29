package com.theimprovisers.iitrconnect;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddAdapter extends  RecyclerView.Adapter<AddAdapter.PersonViewHolder> {

    public static Profile[] profileArray;
    private LayoutInflater inflater;
    // private static AppCompatActivity home;

    public Context context;

    public  AddAdapter(Context context, Profile[] profileArray)
    {
        this.context = context;
        inflater= LayoutInflater.from(context);
        this.profileArray = profileArray;

//home = appCompatActivity;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        View v= inflater.inflate(R.layout.item_profile, viewGroup,false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        personViewHolder.profileName.setText(profileArray[i].name);
        personViewHolder.profileBranch.setText(profileArray[i].branch);
        personViewHolder.profileYear.setText(profileArray[i].year + "Year");
        personViewHolder.profileImage.setImageResource(R.drawable.default_user);

    }
    @Override
    public int getItemCount() {
        return profileArray.length;
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {



        TextView profileName;
        TextView profileBranch;
        TextView profileYear;
        ImageView profileImage;

        PersonViewHolder(View itemView) {
            super(itemView);

            profileName = (TextView)itemView.findViewById(R.id.profile_name);
            profileBranch = (TextView)itemView.findViewById(R.id.profile_branch);
            profileYear = (TextView)itemView.findViewById(R.id.profile_year);
            profileImage = (ImageView)itemView.findViewById(R.id.profile_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Opening View Profile",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), ViewProfileActivity.class);
                    v.getContext().startActivity(intent);
                }


            });
        }



    }








}