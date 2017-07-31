package com.example.asus.themoviedb.movies_tvs;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.themoviedb.MainActivity;
import com.example.asus.themoviedb.R;
import com.example.asus.themoviedb.ViewPagerAdapter;
import com.example.asus.themoviedb.network.ApiClient;
import com.example.asus.themoviedb.network.ApiInterface;
import com.example.asus.themoviedb.network.DetailsResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemDetailActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    String directedBy="";
    String createdBy="";
    String releaseDate;
    int budget = 0;
    int revenue = 0;
    String overview="";

    TextView runtimeTextView;
    TextView genreTextView;

    DetailViewPagerAdapter detailViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        Intent i = getIntent();

        int id = i.getIntExtra("id",-1);
        final String title =i.getStringExtra("title");
        String imagePath = i.getStringExtra("Iconpath");
        String backDropPath = i.getStringExtra("BackDrop");
        releaseDate = i.getStringExtra("releaseDate");
        String[] year = releaseDate.split("-");


        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(title);
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        ImageView backdropView = (ImageView)findViewById(R.id.backdropView);
        TextView nametextView =(TextView)findViewById(R.id.title);
        TextView yearTextView =(TextView)findViewById(R.id.yearTextView);
        genreTextView =(TextView)findViewById(R.id.genreTextView);
        runtimeTextView =(TextView)findViewById(R.id.runtimeTextView);

        Picasso.with(this).load("http://image.tmdb.org/t/p/w185"+imagePath)
                .into(imageView);
        Picasso.with(this).load("http://image.tmdb.org/t/p/w500"+backDropPath)
                .into(backdropView);

        nametextView.setText(title);
        yearTextView.setText(year[0]);


        detailViewPagerAdapter = new DetailViewPagerAdapter(getSupportFragmentManager());
        detailViewPagerAdapter.addFragments(new DetailFragment(),"INFO");
        detailViewPagerAdapter.addFragments(new CastFragment(),"CAST");


        viewPager.setAdapter(detailViewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        fetchData(id);


    }

    private void fetchData(int id) {

        if(MoviesFragment.movieFlag)
        {
            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

            Call<DetailsResponse> call = null;
            call = apiInterface.getMovieDetails(id,MainActivity.API_KEY,"credits");

            call.enqueue(new Callback<DetailsResponse>() {
                @Override
                public void onResponse(Call<DetailsResponse> call, Response<DetailsResponse> response) {
                    DetailsResponse detailResponse = response.body();
                    ArrayList<GenreList> crew = detailResponse.credits.getCrew();
                    ArrayList<GenreList> genre = detailResponse.getGenres();
                    String genreList ="";
                    int runtime = detailResponse.getMovieRuntime();
                    int hr = 0; int min = 0;

                    if(runtime>60)
                    {  hr = runtime/60;
                       min = runtime - 60*hr;
                       runtimeTextView.setText(" -- "+hr+" hr "+min+" mins"); }
                    else
                    {   min = runtime;
                        runtimeTextView.setText(" -- "+min+" mins"); }

                    budget = detailResponse.getBudget();
                    revenue = detailResponse.getRevenue();
                    overview = detailResponse.getOverview();

                    Log.i("budget",budget+"");
                    Log.i("overview",overview);


                    for(int i=0;i<crew.size();i++)
                    {
                        if(crew.get(i).getJob()=="Director")
                            directedBy = directedBy+", "+crew.get(i).getName();
                    }

                    for (int i =0 ; i < genre.size() ; i++)
                    {

                        if (i!=genre.size()-1)
                        {  genreList = genreList+ genre.get(i).getName()+", ";
                        }
                        else
                        {
                            genreList = genreList+ genre.get(i).getName();
                        }
                    } genreTextView.setText(genreList);

                    Bundle bundle = new Bundle();
                    bundle.putString("releaseDate",releaseDate);
                    bundle.putInt("budget",budget);
                    bundle.putInt("revenue",revenue);
                    bundle.putString("overview",overview);
                    bundle.putString("directedBy",directedBy);
                    DetailFragment fragobj = new DetailFragment();
                    fragobj.setArguments(bundle);

                }

                @Override
                public void onFailure(Call<DetailsResponse> call, Throwable t) {

                }
            });





        }
        if(TvShowsFragment.tvFlag)
        {   Log.i("Id",id+"");
            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

            Call<DetailsResponse> call = null;
            call = apiInterface.getTvDetails(id,MainActivity.API_KEY);

            call.enqueue(new Callback<DetailsResponse>() {
                @Override
                public void onResponse(Call<DetailsResponse> call, Response<DetailsResponse> response) {
                    DetailsResponse detailResponse = response.body();
                    ArrayList<GenreList> createdByList = detailResponse.getCreated_by();
                    ArrayList<GenreList> genre = detailResponse.getGenres();
                    Log.i("GENRES",genre.get(0).getName()+" "+genre.get(1).getName());
                    String genreList ="";
                    ArrayList<Integer> runtime = detailResponse.getTvRuntime();
                    Log.i("Runtime",runtime.get(0)+"");
                    int hr = 0; int min = 0;

                    String network = detailResponse.getNetworks();


                    if(runtime.get(0)>60)
                    {  hr = runtime.get(0)/60;
                        min = runtime.get(0) - 60*hr;
                        runtimeTextView.setText(" -- "+hr+" hr "+min+" mins"); }
                    else
                    {   min = runtime.get(0);
                        runtimeTextView.setText(" -- "+min+" mins"); }

                    for(int i = 0 ; i<createdByList.size() ; i++)
                    { createdBy = createdBy+", "+ createdByList.get(i).getName(); }


                    for (int i =0 ; i < genre.size() ; i++)
                    {

                        if (i!=genre.size()-1)
                        {  genreList = genreList+ genre.get(i).getName()+", ";
                        }
                        else
                        {
                            genreList = genreList+ genre.get(i).getName();
                        }
                    } genreTextView.setText(genreList);

                }

                @Override
                public void onFailure(Call<DetailsResponse> call, Throwable t) {

                }
            });





        }





    }


}
