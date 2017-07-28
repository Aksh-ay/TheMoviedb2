package com.example.asus.themoviedb.movies_tvs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.themoviedb.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/26/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder> {

      private ArrayList<ItemsList> itemList;
      private ArrayList<GenreList> genreLists;
      private Context context;
      String[] year;


      public RecyclerAdapter(ArrayList<ItemsList> itemsLists, Context context,ArrayList<GenreList> genreLists1){
          this.itemList = itemsLists;
          this.context = context;
          this.genreLists=genreLists1;

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
        int genre[] = itemList.get(position).getGenreIds();
        String genreList="";

        for( int i=0 ; i<genre.length ; i++){
            for ( int j=0 ; j<genreLists.size() ; j++){
                if(genre[i]==genreLists.get(j).getId())
                {   genreList = genreList+ genreLists.get(j).getName()+","+" ";
                    break;}
            }
        }

//        String finalGenreList =genreList.substring(0, genreList.length() - 2) ;

        holder.genreTextView.setText(genreList.substring(0, genreList.length() - 2));

        float frating = itemList.get(position).getRating();
        String rating = Float.toString(frating);

        if(releaseDate!=null)
        { year = releaseDate.split("-");}
        else
        { year = firstAirDate.split("-");}

        if(movieTitle!=null)
        { holder.nameTextView.setText(movieTitle); }
        else
        { holder.nameTextView.setText(tvTitle); }

        if(frating!=0.0)
        {holder.ratingTextView.setText(rating);}


        holder.yearTextView.setText(year[0]);

        Picasso.with(context).load("http://image.tmdb.org/t/p/w185"+ itemList.get(position).getImagePath())
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
