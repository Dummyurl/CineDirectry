package com.premsoft.cinedirectry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Admin on 3/1/2018.
 */

public class Subcat_Activity extends AppCompatActivity{

    CardView actress_cat,actor,child_male,child_female,comedy_artist,junior_art,supporting_art,model_art,fmodel_art,new_face_male,tv_art_male,tv_art_female;
    CardView new_face_fmale,villan,anchor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Artist");

        actress_cat = findViewById(R.id.actress_cat);
        actor = findViewById(R.id.actor);
        child_male = findViewById(R.id.child_male);
        child_female = findViewById(R.id.child_female);
        comedy_artist = findViewById(R.id.comedy_artist);
        junior_art = findViewById(R.id.junior_art);
        supporting_art = findViewById(R.id.supporting_art);
        model_art = findViewById(R.id.model_art);
        fmodel_art = findViewById(R.id.fmodel_art);
        new_face_male = findViewById(R.id.new_face_male);
        tv_art_male = findViewById(R.id.tv_art_male);
        tv_art_female = findViewById(R.id.tv_art_female);
        new_face_fmale = findViewById(R.id.new_face_fmale);
        villan = findViewById(R.id.villan_artist);
        anchor = findViewById(R.id.anchor);


        actress_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        actor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        child_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        child_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        comedy_artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        junior_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        supporting_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        model_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        fmodel_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        new_face_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        tv_art_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        tv_art_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        new_face_fmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Subcat_Activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        villan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        anchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Offerpage_Activity.class);
                startActivity(intent);
            }
        });
    }
}
