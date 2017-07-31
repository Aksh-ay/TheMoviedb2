package com.example.asus.themoviedb.movies_tvs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.themoviedb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    String overview;
    String releaseDate;
    int budget;
    int revenue;
    String directedBy;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle bundle = getArguments();
        if(bundle!=null)
        { releaseDate = bundle.getString("releaseDate");
          budget = bundle.getInt("budget");
          revenue = bundle.getInt("revenue");
          overview = bundle.getString("overview");
          directedBy = bundle.getString("directedBy");}

        TextView overviewTextView = (TextView) v.findViewById(R.id.overview);
        TextView dateTextView = (TextView) v.findViewById(R.id.dateTextView);
        TextView directedByTextView = (TextView) v.findViewById(R.id.directedByTextView);
        TextView budgetTextView = (TextView) v.findViewById(R.id.budgetTextView);
        TextView revenueTextView = (TextView) v.findViewById(R.id.revenueTextView);

        overviewTextView.setText(overview);
        dateTextView.setText(releaseDate);
        directedByTextView.setText(directedBy);
        if(budget!=0)
        budgetTextView.setText(budget);
        if (revenue!=0)
        revenueTextView.setText(revenue);





        return  v;

    }

}
