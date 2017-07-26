package com.example.asus.themoviedb.TopRated_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.themoviedb.NowPlaying_list.NowPlayingMovieList;
import com.example.asus.themoviedb.NowPlaying_list.network.NowPlayingInterface;
import com.example.asus.themoviedb.NowPlaying_list.network.NowPlayingResponse;
import com.example.asus.themoviedb.R;
import com.example.asus.themoviedb.TopRated_list.network.TopRatedInterface;
import com.example.asus.themoviedb.TopRated_list.network.TopRatedResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<TopRatedMovieList> topRatedMovieLists;


    public TopRatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.top_rated_fragment, container, false);

        topRatedMovieLists = new ArrayList<>();

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        adapter = new RecyclerAdapter(topRatedMovieLists,getContext());
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(adapter);


        fetchTopRated();

        return v;
    }

    private void fetchTopRated() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final TopRatedInterface topRatedInterface =  retrofit.create(TopRatedInterface.class);
//
        Call<TopRatedResponse> call  =  topRatedInterface.getTopRated("06d7dd44f460db5a7ba23188c8bc64b2");

        call.enqueue(new Callback<TopRatedResponse>() {
            @Override
            public void onResponse(Call<TopRatedResponse> call, Response<TopRatedResponse> response) {

                TopRatedResponse topRatedResponse = response.body();
                ArrayList<TopRatedMovieList> topRatedList = topRatedResponse.getResults();
                onDownloadComplete(topRatedList);


            }

            @Override
            public void onFailure(Call<TopRatedResponse> call, Throwable t) {

            }
        });
    }

    private void onDownloadComplete(ArrayList<TopRatedMovieList> topRatedList) {
        topRatedMovieLists.clear();
        topRatedMovieLists.addAll(topRatedList);
        adapter.notifyDataSetChanged();

    }

}
