package com.premsoft.cinedirectry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Admin on 3/31/2018.
 */

public class Profile_Fragmnet extends Fragment {
    Button edit_profile;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_profile,container,false);
        edit_profile = v.findViewById(R.id.edit_proile);

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Edit_profile.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
