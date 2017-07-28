package com.example.asus.themoviedb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/26/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder> {

      private ArrayList<ItemsList> itemList;
      private Context context;
      String[] year;


      public RecyclerAdapter(ArrayList<ItemsList> topRatedItemsLists, Context context){
          this.itemList = topRatedItemsLists;
          this.context = context;

      }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler_root_element,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String releaseDate = itemList.get(position).getMovieDate();
        String firstAirDate = itemList.get(position).getTvDate();
        String movieTitle = itemList.get(position).getMovieTitle();
        String tvTitle = itemList.get(position).getTvTitle();
        float frating = itemList.get(position).getRating();

        if(releaseDate!=null)
        { year = releaseDate.split("-");}
        else
        { year = firstAirDate.split("-");}

        String rating = Float.toString(frating);

        if(movieTitle!=null)
        { holder.nameTextView.setText(movieTitle); }
        else
        { holder.nameTextView.setText(tvTitle); }


        holder.yearTextView.setText(year[0]);
        holder.ratingTextView.setText(rating);
        Picasso.with(context).load("http://image.tmdb.org/t/p/w500"+ itemList.get(position).getImagePath())
                .into(holder.poster);


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView poster;
        TextView yearTextView;
        TextView nameTextView;
        TextView genreTextView;
        TextView ratingTextView;

        public MyViewHolder(View itemView) {
            super(itemView);

            poster = (ImageView) itemView.findViewById(R.id.mainImageView);
            yearTextView = (TextView) itemView.findViewById(R.id.yearTextView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            genreTextView = (TextView) itemView.findViewById(R.id.genreTextView);
            ratingTextView = (TextView) itemView.findViewById(R.id.ratingTextView);
        }
    }

}
