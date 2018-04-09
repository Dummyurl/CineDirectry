package com.premsoft.cinedirectry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Admin on 3/7/2018.
 */

public class Fashion_subcat extends AppCompatActivity {

    CardView cat_actor,cat_actress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Fashion Designer");

        cat_actor = findViewById(R.id.cat_actor);
        cat_actress = findViewById(R.id.cat_actress);

        cat_actor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fashion_subcat.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        cat_actress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fashion_subcat.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
    }
}