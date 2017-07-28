package com.example.asus.themoviedb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.LoginFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonsFragment extends Fragment {

    public RecyclerView recyclerView;
    private PersonsRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<PersonsList> personsLists;



    public PersonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.item_root_fragment, container, false);

        personsLists = new ArrayList<>();

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonsRecyclerAdapter(personsLists, getContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        fetchPersonsList();

        return v;
    }

    private void fetchPersonsList() {

        final ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<PersonsResponse> call = apiInterface.getPersonPopular(MainActivity.API_KEY);

        call.enqueue(new Callback<PersonsResponse>() {
            @Override
            public void onResponse(Call<PersonsResponse> call, Response<PersonsResponse> response) {
                PersonsResponse personResponse = response.body();
                ArrayList<PersonsList> resultPersons =  personResponse.getResults();
                onDownLoadComplete(resultPersons);
            }

            @Override
            public void onFailure(Call<PersonsResponse> call, Throwable t) {

            }
        });

    }

    private void onDownLoadComplete(ArrayList<PersonsList> resultPersons) {
        personsLists.clear();
        personsLists.addAll(resultPersons);
        adapter.notifyDataSetChanged();
    }

}
