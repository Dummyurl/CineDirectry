package com.premsoft.cinedirectry;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.BetterSpinner;

/**
 * Created by Admin on 3/14/2018.
 */

public class Paynow_Activity extends Fragment{

    View rootView;
    private static final String[] COUNTRI = new String[] {
            "Golden Package","Diamond Package","Portait Package"
    };
    public Paynow_Activity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         rootView = inflater.inflate(R.layout.activity_paynow, container, false);

        ArrayAdapter<String> catadapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, COUNTRI);
        BetterSpinner cattextView = (BetterSpinner)
                rootView.findViewById(R.id.spinner);
        cattextView.setAdapter(catadapter);



        return rootView;
    }
    }
