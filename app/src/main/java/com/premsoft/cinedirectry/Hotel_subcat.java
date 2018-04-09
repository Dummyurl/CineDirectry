package com.premsoft.cinedirectry;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.premsoft.cinedirectry.custom_font.MyEditText;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.Calendar;

/**
 * Created by Admin on 3/7/2018.
 */

public class Hotel_subcat extends AppCompatActivity {
    MyEditText et_chkin,et_chkout;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private static final String[] Number = new String[]{
             "1", "2", "3", "4","5","6","7","8","9"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcat_hotel);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Hotel");

        et_chkin = findViewById(R.id.et_chickin);
        et_chkout = findViewById(R.id.et_chickout);

        et_chkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Hotel_subcat.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                et_chkin.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        et_chkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Hotel_subcat.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                et_chkout.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Hotel_subcat.this,
                android.R.layout.simple_dropdown_item_1line, Number);
        BetterSpinner textView = (BetterSpinner)
                findViewById(R.id.sp_room);
        textView.setAdapter(adapter);

        ArrayAdapter<String> adult_adapter = new ArrayAdapter<String>(Hotel_subcat.this,
                android.R.layout.simple_dropdown_item_1line, Number);
        BetterSpinner ad_textView = (BetterSpinner)
                findViewById(R.id.sp_adult);
        ad_textView.setAdapter(adult_adapter);

        ArrayAdapter<String> ch_adapter = new ArrayAdapter<String>(Hotel_subcat.this,
                android.R.layout.simple_dropdown_item_1line, Number);
        BetterSpinner ch_textView = (BetterSpinner)
                findViewById(R.id.sp_child);
        ch_textView.setAdapter(ch_adapter);
    }
}
