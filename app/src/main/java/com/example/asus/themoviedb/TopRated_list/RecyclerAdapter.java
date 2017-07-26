package com.example.asus.themoviedb.TopRated_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.themoviedb.NowPlaying_list.NowPlayingMovieList;
import com.example.asus.themoviedb.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/26/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder> {

      private ArrayList<TopRatedMovieList> topRatedMovieLists;
      private Context context;

      public RecyclerAdapter(ArrayList<TopRatedMovieList> topRatedMovieLists , Context context){
          this.topRatedMovieLists = topRatedMovieLists ;
          this.context = context;

      }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.now_playing_recycler_element,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String releaseDate = topRatedMovieLists.get(position).getReleaseDate();
        String[] year = releaseDate.split("-");
        String rating = Float.toString(topRatedMovieLists.get(position).getRating());

        holder.nameTextView.setText(topRatedMovieLists.get(position).getTitle());
        holder.yearTextView.setText(year[0]);
        holder.ratingTextView.setText(rating);
        Picasso.with(context).load("http://image.tmdb.org/t/p/w500"+topRatedMovieLists.get(position).getImagePath())
                .into(holder.poster);


    }

    @Override
    public int getItemCount() {
        return topRatedMovieLists.size();
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
