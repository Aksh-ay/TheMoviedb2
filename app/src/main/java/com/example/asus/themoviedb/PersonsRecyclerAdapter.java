package com.example.asus.themoviedb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ASUS on 7/28/2017.
 */

public class PersonsRecyclerAdapter extends RecyclerView.Adapter<PersonsRecyclerAdapter.MyViewHolder>{

    ArrayList<PersonsList> personsLists;
    Context context;

    public PersonsRecyclerAdapter(ArrayList<PersonsList> personsLists , Context context){
        this.personsLists=personsLists;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.persons_recycler_root_element,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.nameTextView.setText(personsLists.get(position).getName());
        Picasso.with(context).load("http://image.tmdb.org/t/p/w500"+personsLists.get(position).getProfileImage_path()).into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return personsLists.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView circleImageView;
        TextView nameTextView;

        public MyViewHolder(View itemView) {
            super(itemView);

            circleImageView = (CircleImageView)itemView.findViewById(R.id.profile_image);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        }
    }
}
