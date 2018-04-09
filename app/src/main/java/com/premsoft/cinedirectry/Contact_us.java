package com.premsoft.cinedirectry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 3/5/2018.
 */

public class Contact_us extends Fragment {

    CardView complaint;

    public Contact_us() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.about_activity, container, false);
        complaint = rootView.findViewById(R.id.compliant);

        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Complaint_Activity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
