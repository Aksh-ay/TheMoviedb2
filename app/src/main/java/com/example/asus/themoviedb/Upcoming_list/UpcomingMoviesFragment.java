package com.example.asus.themoviedb.Upcoming_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.themoviedb.R;
import com.example.asus.themoviedb.Upcoming_list.network.UpcomingMoviesInterface;
import com.example.asus.themoviedb.Upcoming_list.network.UpcomingMoviesResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingMoviesFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<UpcomingMoviesList> upcomingMoviesLists;


    public UpcomingMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.upcoming_movies_fragment, container, false);

        upcomingMoviesLists = new ArrayList<>();

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerAdapter(upcomingMoviesLists,getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);


        fetchUpcomingList();

        return v;
    }

    private void fetchUpcomingList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final UpcomingMoviesInterface upComingMovieInterface = retrofit.create(UpcomingMoviesInterface.class);

        Call<UpcomingMoviesResponse> call = upComingMovieInterface.getUpcomingList("06d7dd44f460db5a7ba23188c8bc64b2");

        call.enqueue(new Callback<UpcomingMoviesResponse>() {
            @Override
            public void onResponse(Call<UpcomingMoviesResponse> call, Response<UpcomingMoviesResponse> response) {
                UpcomingMoviesResponse upComingMovieResponse = response.body();
                ArrayList<UpcomingMoviesList> UpcomingList = upComingMovieResponse.getResults();
                onDownLoadComplete(UpcomingList);
            }

            @Override
            public void onFailure(Call<UpcomingMoviesResponse> call, Throwable t) {

            }
        });
    }

    private void onDownLoadComplete(ArrayList<UpcomingMoviesList> upcomingList) {
        upcomingMoviesLists.clear();
        upcomingMoviesLists.addAll(upcomingList);
        adapter.notifyDataSetChanged();
    }

}
