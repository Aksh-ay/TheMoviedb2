package com.example.asus.themoviedb.NowPlaying_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.themoviedb.NowPlaying_list.network.NowPlayingInterface;
import com.example.asus.themoviedb.NowPlaying_list.network.NowPlayingResponse;
import com.example.asus.themoviedb.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {

    public RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<NowPlayingMovieList> movieListThumblain;
    private  int totalPages;





    public NowPlayingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.now_playing_fragment, container, false);

        movieListThumblain = new ArrayList<>();

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter= new RecyclerAdapter(movieListThumblain,getContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);


         fetchNowPlaying();
        return v;

    }

    private void fetchNowPlaying() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/movie/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            final NowPlayingInterface nowPlayingInterface =  retrofit.create(NowPlayingInterface.class);
//
            Call<NowPlayingResponse> call  =  nowPlayingInterface.getNowPlaying("06d7dd44f460db5a7ba23188c8bc64b2");

             call.enqueue(new Callback<NowPlayingResponse>() {
                 @Override
                 public void onResponse(Call<NowPlayingResponse> call, Response<NowPlayingResponse> response) {

                     NowPlayingResponse nowPlayingResponse = response.body();
                     ArrayList<NowPlayingMovieList> nowPlayingList = nowPlayingResponse.getResults();
                       totalPages= nowPlayingResponse.getTotal_pages();
                     Log.i("Pagetotal",totalPages+"");
                     onDownloadComplete(nowPlayingList);


                 }

                 @Override
                 public void onFailure(Call<NowPlayingResponse> call, Throwable t) {

                 }
             });
    }

    private void onDownloadComplete(ArrayList<NowPlayingMovieList> nowPlayingList) {
        movieListThumblain.clear();
        movieListThumblain.addAll(nowPlayingList);
        adapter.notifyDataSetChanged();

    }


}
