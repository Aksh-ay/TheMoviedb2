package com.example.asus.themoviedb.Popular_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.themoviedb.Popular_list.network.PopularInterface;
import com.example.asus.themoviedb.Popular_list.network.PopularMoviesResponse;
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
public class PopularFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<PopularMovieList> popularMovieLists;


    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.popular_fragment, container, false);

        popularMovieLists = new ArrayList<>();

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerAdapter(popularMovieLists,getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);


        fetchPopularList();
        return  v;
    }

    private void fetchPopularList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final PopularInterface popularInterface =  retrofit.create(PopularInterface.class);

        Call <PopularMoviesResponse> call = popularInterface.getPopular("06d7dd44f460db5a7ba23188c8bc64b2");

        call.enqueue(new Callback<PopularMoviesResponse>() {
            @Override
            public void onResponse(Call<PopularMoviesResponse> call, Response<PopularMoviesResponse> response) {

                PopularMoviesResponse popularMovieResponse = response.body();
                ArrayList<PopularMovieList> popularList = popularMovieResponse.getResults();
                onDownLoadComplete(popularList);
            }

            @Override
            public void onFailure(Call<PopularMoviesResponse> call, Throwable t) {

            }
        });
    }

    private void onDownLoadComplete(ArrayList<PopularMovieList> popularList) {

        popularMovieLists.clear();
        popularMovieLists.addAll(popularList);
        adapter.notifyDataSetChanged();

    }

}
