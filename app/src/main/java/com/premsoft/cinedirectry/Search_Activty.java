package com.premsoft.cinedirectry;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.BetterSpinner;

/**
 * Created by Admin on 2/22/2018.
 */

public class Search_Activty extends Fragment {
    View rootView;
    //   @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activty_search);
 private static final String[] COUNTRIES = new String[] {
         "All Categories", "Actor", "Actor-TV", "Actress", "Actress-TV","Advertising Agency","Advt. Film Makers","Anchor / V J / R J","Art Director","Artiste Agents","Associate Director","Audiographers","Beauticians & Saloon","Camera & Lights Hire","Censor Script Writers","Child Artistes","Cinematographer","Cini Equipment Suppliers","Costume Designers","Dance Schools","Dialogue Writers","Director","Distributors","Drama Artistes","Dubbing Artistes","Dubbing Theaters","Edit , CG , DI & VFX Studios","Editing Studios","Editor","Event Managements","Fashion Designers","Fighters & Stunt Men","Film School","Freelance Workers","Hotels & Resorts","Junior Artistes","Location Managers","Lyric Writers","Makeup Men & Women","Mediators","Model coordinators","Modeling Studios","Models Male & Female","Music Schools","Musicians","New Face Female","New Face Male",
               "Outdoor Unit","Playback Singers","Press & Media People","Preview Theaters","PRO's","Producers","Production Executives","Production Managers","Publicity Designers","Shooting Co-Ordinaters","Shooting Floors","Shooting Houses","Sound Effects","Sound Studios","Still Photographers","Story Writers","Storyboard Writers / Artists","Stunt Masters","Theatres","Travels & Cabs","TV Serial Producers"
 };
 private static final String[] CAT = new String[]{
         "--Select--", "Bollywood", "Sandalwood", "Tollywood", "Mollywood","Hollywood"
 };
    public Search_Activty() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         rootView = inflater.inflate(R.layout.activty_search, container, false);

//        MaterialSpinner spinner = (MaterialSpinner) rootView.findViewById(R.id.cat_spinner);
//        spinner.setItems("--Select--", "Bollywood", "Sandalwood", "Tollywood", "Mollywood","Hollywood");
//        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
//
//            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
//                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
//            }
//        });

        BetterSpinner spinner =  rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> catadapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, CAT);
        BetterSpinner cattextView = (BetterSpinner)
                rootView.findViewById(R.id.cat_spinner);
        cattextView.setAdapter(catadapter);



        BetterSpinner catspinner =  rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        BetterSpinner textView = (BetterSpinner)
                rootView.findViewById(R.id.spinner);
        textView.setAdapter(adapter);


    // catspinner.setItems("All Categories", "Actor", "Actor-TV", "Actress", "Actress-TV","Advertising Agency","Advt. Film Makers","Anchor / V J / R J","Art Director","Artiste Agents","Associate Director","Audiographers","Beauticians & Saloon","Camera & Lights Hire","Censor Script Writers","Child Artistes","Cinematographer","Cini Equipment Suppliers","Costume Designers","Dance Schools","Dialogue Writers","Director","Distributors","Drama Artistes","Dubbing Artistes","Dubbing Theaters","Edit , CG , DI & VFX Studios","Editing Studios","Editor","Event Managements","Fashion Designers","Fighters & Stunt Men","Film School","Freelance Workers","Hotels & Resorts","Junior Artistes","Location Managers","Lyric Writers","Makeup Men & Women","Mediators","Model coordinators","Modeling Studios","Models Male & Female","Music Schools","Musicians","New Face Female","New Face Male",
        //        "Outdoor Unit","Playback Singers","Press & Media People","Preview Theaters","PRO's","Producers","Production Executives","Production Managers","Publicity Designers","Shooting Co-Ordinaters","Shooting Floors","Shooting Houses","Sound Effects","Sound Studios","Still Photographers","Story Writers","Storyboard Writers / Artists","Stunt Masters","Theatres","Travels & Cabs","TV Serial Producers");
//        catspinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
//
//            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
//                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
//            }
//        });

        return rootView;
    }




}
