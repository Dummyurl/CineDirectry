package com.premsoft.cinedirectry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Admin on 3/6/2018.
 */

public class Techinician_activity extends AppCompatActivity {

    CardView art_cat,associations,maket_agency,flim_corp,audiographer,auditorium,cinematographer,singer,cine_banner,cine_designer,cine_lab,director;
    CardView cine_equipment,costumer,dance_director,dubbing_theater,dubbing_artist,editing_room,event_manager,edittors,graphics_designer,flim_distributors;
    CardView hair,journal,journalist,lyrics_writter,lyt_muc,music_director,magic,mediater,music_incharge,modeling,outtoor,press,playback,producction;
    CardView project_exe,shunt_director,script,shooting_house,photographers,story_writter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Technicians");



        art_cat = findViewById(R.id.art_cat);
        associations = findViewById(R.id.association);
        maket_agency = findViewById(R.id.maket_agency);
        flim_corp = findViewById(R.id.flim_corp);
        audiographer = findViewById(R.id.audiographer);
        auditorium = findViewById(R.id.auditorium);
        cinematographer = findViewById(R.id.cinematographer);
        singer = findViewById(R.id.singer);
        cine_banner =findViewById(R.id.cine_banner);
        cine_lab =findViewById(R.id.cine_lab);
        director =findViewById(R.id.director);
        cine_designer = findViewById(R.id.cine_designer);
        cine_equipment = findViewById(R.id.cine_equipment);
        costumer = findViewById(R.id.costumer);
        dance_director = findViewById(R.id.dance_director);
        dubbing_theater = findViewById(R.id.dubbing_theater);
        dubbing_artist = findViewById(R.id.dubbing_artist);
        editing_room = findViewById(R.id.editing_room);
        event_manager = findViewById(R.id.event_manager);
        edittors = findViewById(R.id.edittors);
        graphics_designer = findViewById(R.id.graphics_designer);
        flim_distributors = findViewById(R.id.flim_distributors);
        hair = findViewById(R.id.hair);
        journal = findViewById(R.id.journal);
        journalist = findViewById(R.id.journalist);
        lyrics_writter = findViewById(R.id.lyrics_writter);
        lyt_muc = findViewById(R.id.lyt_muc);
        music_director = findViewById(R.id.music_director);
        magic = findViewById(R.id.magic);
        mediater = findViewById(R.id.mediater);
        music_incharge = findViewById(R.id.music_incharge);
        modeling = findViewById(R.id.modeling);
        outtoor = findViewById(R.id.outtoor);
        press = findViewById(R.id.press);
        playback = findViewById(R.id.playback);
        producction = findViewById(R.id.producction);
        project_exe = findViewById(R.id.project_exe);
        shunt_director = findViewById(R.id.shunt_director);
        script = findViewById(R.id.script);
        shooting_house = findViewById(R.id.shooting_house);
        photographers = findViewById(R.id.photographers);
        story_writter = findViewById(R.id.story_writter);

        art_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        associations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        maket_agency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        flim_corp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        audiographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        auditorium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        cinematographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        singer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        cine_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        cine_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        director.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        cine_designer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        cine_equipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        costumer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        dance_director.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        dubbing_theater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        dubbing_artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        editing_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        event_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        edittors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        graphics_designer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });

        flim_distributors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        hair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        journalist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        lyrics_writter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        lyt_muc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        music_director.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        magic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        mediater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        music_incharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        modeling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        outtoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        playback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        producction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        project_exe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        }); shunt_director.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        }); script.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });
        shooting_house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });


        photographers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });


        story_writter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Techinician_activity.this,Offerpage_Activity.class);
                startActivity(intent);
            }
        });





    }
}
