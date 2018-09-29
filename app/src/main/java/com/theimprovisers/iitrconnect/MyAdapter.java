package com.theimprovisers.iitrconnect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.PersonViewHolder> {

    public static Profile[] profileArray;
    private LayoutInflater inflater;

    public  MyAdapter(Context context, Profile[] profileArray)
    {
        inflater= LayoutInflater.from(context);
        this.profileArray = profileArray;

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
                    Toast.makeText(v.getContext(),profileName.getText(),Toast.LENGTH_LONG).show();

                }
            });
        }
    }
}