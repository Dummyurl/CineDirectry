package com.premsoft.cinedirectry;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Admin on 3/1/2018.
 */

public class Details_Activity extends AppCompatActivity {

//    public Details_Activity() {
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.details_activity, container, false);
//
//        return rootView;
//    }
final Context context = this;

    Button send_request;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        send_request = findViewById(R.id.edit_proile);

        send_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               alertDialogbox();
            }
        });
    }

    public void alertDialogbox(){
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.call_popup, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText username = (EditText) promptsView
                .findViewById(R.id.etname);
        final EditText useremail = (EditText) promptsView
                .findViewById(R.id.etEmail);
        final EditText usermobile = (EditText) promptsView
                .findViewById(R.id.etmobile);
        final EditText userstate = (EditText) promptsView
                .findViewById(R.id.etstate);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                //  result.setText(userInput.getText());

//                                String strname = username.getText().toString();
//                                String stremail = useremail.getText().toString();
//                                String strmobile = usermobile.getText().toString();
//                                String strstate = userstate.getText().toString();
//
//                                BackgroundMail.newBuilder(context)
//                                        .withUsername("babu.preamsoft@gmail.com")
//                                        .withPassword("Prem@123")
//                                        .withMailto("babuparaman@gmail.com")
//                                        .withType(BackgroundMail.TYPE_PLAIN)
//                                        .withSubject("Enquiry for sevakan")
//                                        .withBody("Name :"+strname+"\n Mobile"+strmobile+"\n Email:"+stremail+"\n State :"+strstate)
//                                        .withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
//                                            @Override
//                                            public void onSuccess() {
//                                                //do some magic
//                                                new MaterialDialog.Builder(getApplicationContext())
//                                                        .title("Success...")
//                                                        .content("Thank you for contacting sevakan front end team.Our repersentative will shortly reach you our with your query")
//                                                        .positiveText("Done")
//                                                        .showListener(new DialogInterface.OnShowListener() {
//                                                            @Override
//                                                            public void onShow(DialogInterface dialog) {
//                                                            }
//                                                        })
//                                                        .cancelListener(new DialogInterface.OnCancelListener() {
//                                                            @Override
//                                                            public void onCancel(DialogInterface dialog) {
//                                                            }
//                                                        })
//                                                        .dismissListener(new DialogInterface.OnDismissListener() {
//                                                            @Override
//                                                            public void onDismiss(DialogInterface dialog) {
//                                                            }
//                                                        })
//                                                        .show();
//
//                                            }
//                                        })
//                                        .withOnFailCallback(new BackgroundMail.OnFailCallback() {
//                                            @Override
//                                            public void onFail() {
//                                                //do some magic
//                                            }
//                                        })
//                                        .send();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
