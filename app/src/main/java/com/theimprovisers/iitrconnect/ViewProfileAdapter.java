package com.theimprovisers.iitrconnect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewProfileAdapter extends  RecyclerView.Adapter<ViewProfileAdapter.PersonViewHolder>
{
    public  String[] tagsArray;
    private LayoutInflater inflater;

    public  ViewProfileAdapter(Context context, String[] tagsArray)
    {
        inflater= LayoutInflater.from(context);
        this.tagsArray = tagsArray;

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewProfileAdapter.PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        View v= inflater.inflate(R.layout.item_tag, viewGroup,false);
        PersonViewHolder pvh = new ViewProfileAdapter.PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        personViewHolder.tagsText.setText(tagsArray[i]);


    }
    @Override
    public int getItemCount() {
        if (tagsArray != null)
        {
            return tagsArray.length;
        }
        else
        {
            Print.print("Profile array null");
            return 0;
        }
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {


        TextView tagsText;

        PersonViewHolder(View itemView) {
            super(itemView);

            tagsText = (TextView)itemView.findViewById(R.id.tag_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),tagsText.getText(),Toast.LENGTH_LONG).show();

                }
            });
        }
    }
}
