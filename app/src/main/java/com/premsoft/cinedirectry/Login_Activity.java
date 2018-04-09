package com.premsoft.cinedirectry;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.premsoft.cinedirectry.custom_font.MyEditText;
import com.premsoft.cinedirectry.custom_font.MyTextView;
import com.premsoft.cinedirectry.utils.Const;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2/13/2018.
 */

public class Login_Activity extends AppCompatActivity {

    MyTextView create,forgot,start,guest;
    MyEditText username,password;
    String StrUser,StrPass;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String EmailHolder, PasswordHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = Const.LoginURL;

    Boolean CheckEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Login");

  create = findViewById(R.id.create);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forgot = findViewById(R.id.forgot);
        start = findViewById(R.id.getstarted);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(Login_Activity.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(Login_Activity.this);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this,Forgot_Activity.class);
                startActivity(intent);
            }
        });

//        guest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
//            }
//        });
//

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(Login_Activity.this,Register_Activity.class);
                startActivity(it);
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEditTextIsEmptyOrNot();

//                if (CheckEditText) {
//
//                    UserLogin();
//
//                } else {
//
//                    Toast.makeText(Login_Activity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();
//
//                }

            }
        });
    }



    //    guest = findViewById(R.id.guest);




    public void UserLogin() {

        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Matching server responce message to our text.
                        if(ServerResponse.equalsIgnoreCase("Data Matched")) {

                            // If response matched then show the toast.
                            Toast.makeText(Login_Activity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();

                            // Finish the current Login activity.
                            finish();

                            // Opening the user profile activity using intent.
                            Intent intent = new Intent(Login_Activity.this, MainActivity.class);

                            // Sending User Email to another activity using intent.
                            intent.putExtra("UserEmailTAG", EmailHolder);
                            startActivity(intent);
                        }
                        else {

                            // Showing Echo Response Message Coming From Server.
                            Toast.makeText(Login_Activity.this, ServerResponse, Toast.LENGTH_LONG).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(Login_Activity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
                // The firs argument should be same sa your MySQL database table columns.
                params.put("User_Email", EmailHolder);
                params.put("User_Password", PasswordHolder);

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Login_Activity.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }

    public void CheckEditTextIsEmptyOrNot() {

        // Getting values from EditText.
        StrUser = username.getText().toString().trim();
        StrPass = password.getText().toString().trim();

        // Checking whether EditText value is empty or not.
        if (StrUser.equals("")) {

            // If any of EditText is empty then set variable value as False.
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Please Enter The Username",Toast.LENGTH_SHORT, MDToast.TYPE_ERROR);
            mdToast.show();
            CheckEditText = false;

        } else if(StrPass.equals("")){

            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Please Enter The Password",Toast.LENGTH_SHORT, MDToast.TYPE_ERROR);
            mdToast.show();
            CheckEditText = false;
            // If any of EditText is filled then set variable value as True.
            // CheckEditText = true;
        }else{

            CheckEditText = true;
        }
    }
}
