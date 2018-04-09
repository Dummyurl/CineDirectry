package com.premsoft.cinedirectry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weiwangcn.betterspinner.library.BetterSpinner;

/**
 * Created by Admin on 2/22/2018.
 */

public class Category_Activity extends Fragment {

    CardView card_artist,card_technician,card_studio,card_hotel,card_film,card_thedar,card_trailer,new_face,model_co_ordinate,fashion_cat,travel_operator;
    BetterSpinner cat_spinner;
    private static final String[] CATEGORIES = new String[] {"Bollywood","Kollywood","Sandalwood","TollyWood","MollyWood","HollyWood"};
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_category);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("Hi Cinema Directory");

    public Category_Activity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_category, container, false);

//card view
        card_artist = rootView.findViewById(R.id.artist_cat);
        card_technician = rootView.findViewById(R.id.cat_technician);
        card_studio = rootView.findViewById(R.id.cat_studios);
        card_hotel = rootView.findViewById(R.id.cat_hotel);
        card_film = rootView.findViewById(R.id.cat_film);
        card_thedar = rootView.findViewById(R.id.cat_thedar);
        card_trailer = rootView.findViewById(R.id.cat_trailer);
        new_face = rootView.findViewById(R.id.new_face);
        model_co_ordinate = rootView.findViewById(R.id.model_co_ordinate);
        fashion_cat = rootView.findViewById(R.id.fashion_cat);
        travel_operator = rootView.findViewById(R.id.travel_operator);


        card_artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Subcat_Activity.class);
                startActivity(intent);
            }
        });

        card_technician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Techinician_activity.class);
                startActivity(intent);
            }
        });

        card_studio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        card_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Hotel_subcat.class);
                startActivity(intent);
            }
        });
        card_film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        card_thedar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        card_trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Teailer_activity.class);
                startActivity(intent);
            }
        });

        fashion_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        new_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Fashion_subcat.class );
                startActivity(intent);
            }
        });

        model_co_ordinate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        travel_operator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
