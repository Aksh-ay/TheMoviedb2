package com.example.asus.themoviedb.movies_tvs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.themoviedb.MainActivity;
import com.example.asus.themoviedb.R;
import com.example.asus.themoviedb.network.ApiClient;
import com.example.asus.themoviedb.network.ApiInterface;
import com.example.asus.themoviedb.network.GenresResponse;
import com.example.asus.themoviedb.network.ItemsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsListFragment extends Fragment {

    public RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemsList> itemsLists;
    private ArrayList<GenreList> genreLists;



    public ItemsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.item_root_fragment, container, false);

        itemsLists = new ArrayList<>();
        genreLists = new ArrayList<>();

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(itemsLists, getContext(),genreLists);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        if (getArguments()!=null)
        fetchMovies(getArguments().getInt("position"));
        return v;

    }

    private void fetchMovies(int type) {

        final ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<ItemsResponse> call=null;
        Call<GenresResponse> genreCall = null;

        if (MoviesFragment.movieFlag)
        {  genreCall = apiInterface.getMoviesGenre(MainActivity.API_KEY);

            switch (type) {
                case 0:
                    call = apiInterface.getNowPlaying(MainActivity.API_KEY);
                    break;
                case 1:
                    call = apiInterface.getUpcomingList(MainActivity.API_KEY);
                    break;
                case 2:
                    call = apiInterface.getPopular(MainActivity.API_KEY);
                    break;
                case 3:
                    call = apiInterface.getTopRated(MainActivity.API_KEY);
                    break;

                default:
                    return;
            }
        }

        if (TvShowsFragment.tvFlag)
        {   genreCall = apiInterface.getTvShowsGenre(MainActivity.API_KEY);

            switch (type) {
                case 0:
                    call = apiInterface.getAiringToday(MainActivity.API_KEY);
                    break;
                case 1:
                    call = apiInterface.getTvOnAir(MainActivity.API_KEY);
                    break;
                case 2:
                    call = apiInterface.getTvPopular(MainActivity.API_KEY);
                    break;
                case 3:
                    call = apiInterface.getTvTopRated(MainActivity.API_KEY);
                    break;

                default:
                    return;
            }
        }

        call.enqueue(new Callback<ItemsResponse>() {
            @Override
            public void onResponse(Call<ItemsResponse> call, Response<ItemsResponse> response) {

                ItemsResponse itemResponse = response.body();
                ArrayList<ItemsList> itemsListResponse = itemResponse.getResults();
                onDownloadComplete(itemsListResponse);


            }

            @Override
            public void onFailure(Call<ItemsResponse> call, Throwable t) {

            }
        });

        genreCall.enqueue(new Callback<GenresResponse>() {
            @Override
            public void onResponse(Call<GenresResponse> call, Response<GenresResponse> response) {
                GenresResponse genreResponse = response.body();
                ArrayList<GenreList> genreListResponse = genreResponse.getGenres();
                Log.i("GENRES",genreListResponse.get(0).getName()+genreListResponse.get(1).getName()+genreListResponse.get(2).getName());
                onGenresDownloadComplete(genreListResponse);
            }

            @Override
            public void onFailure(Call<GenresResponse> call, Throwable t) {

            }
        });
    }

    private void onGenresDownloadComplete(ArrayList<GenreList> genreListResponse) {
        genreLists.clear();
        genreLists.addAll(genreListResponse);


    }

    private void onDownloadComplete(ArrayList<ItemsList> itemsListResponse) {
        itemsLists.clear();
        itemsLists.addAll(itemsListResponse);
        adapter.notifyDataSetChanged();

    }


}
