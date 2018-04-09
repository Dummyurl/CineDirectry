package com.premsoft.cinedirectry;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.premsoft.cinedirectry.utils.Const;
import com.valdesekamdem.library.mdtoast.MDToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


/**
 * Created by Admin on 2/13/2018.
 */

public class Register_Activity extends AppCompatActivity {

    private EditText et_email, et_password, et_confirmpass, et_name, et_address, et_country, et_pincode, et_state, et_city;
    private EditText et_phone, et_alternate;

    private EditText et_com_address, et_com_city, et_com_state, et_com_country, et_com_pin;

    private Button btn_choose, btn_choose_video, btn_submit;
    private TextView choose_img_txt;
    private CheckBox com_chkaddress;

    public String strEmail, strPass, strRepass, strName, strAddress, strCountry, strPin, strState, strCity, strPhone, strAlter;
    public String strcomAddress, strcomCountry, strcomPin, strcomState, strcomCity;
    private JSONObject jsonObject;
    ArrayList<Uri> imagesUriList;
    ArrayList<String> encodedImageList;
    String imageURI;
    private Snackbar snackbar;
    private ProgressDialog dialog = null;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String mPhoneNumber;
    TelephonyManager tel;
    String imei_num;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.password);
        et_confirmpass = findViewById(R.id.con_password);
        et_name = findViewById(R.id.et_pname);
        et_address = findViewById(R.id.et_paddress);
        et_country = findViewById(R.id.country);
        et_pincode = findViewById(R.id.pincode);
        et_state = findViewById(R.id.state);
        et_city = findViewById(R.id.city);
        et_phone = findViewById(R.id.ph_number);
        et_alternate = findViewById(R.id.alter_number);
        choose_img_txt = findViewById(R.id.txt_choose_image);
        et_com_address = findViewById(R.id.com_et_paddress);
        et_com_city = findViewById(R.id.com_city);
        et_com_country = findViewById(R.id.com_country);
        et_com_state = findViewById(R.id.com_state);
        et_com_pin = findViewById(R.id.com_pincode);

        //checkbox
        com_chkaddress = findViewById(R.id.chk_address);

        // Button
        btn_choose = findViewById(R.id.btn_choose);
        // btn_choose_video = findViewById(R.id.btn_choose_video);
        btn_submit = findViewById(R.id.submit);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Uploading Image...");
        dialog.setCancelable(false);

        jsonObject = new JSONObject();
        encodedImageList = new ArrayList<>();

        tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        imei_num = tel.getDeviceId().toString();
        Log.d("Imei_no",imei_num);


        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");

                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
              //  intent.putExtra(Constants.INTENT_EXTRA_LIMIT, 10);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Choose application"), Const.REQCODE);
            }
        });

        com_chkaddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                LinearLayout commulayout = findViewById(R.id.commu_address);
                if (com_chkaddress.isChecked()){
                    commulayout.setVisibility(View.VISIBLE);
                }else {
                    commulayout.setVisibility(View.GONE);

                }
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                values();
                validation();
                   // functionSignUp();
            }
        });

    }

    public void functionSignUp(){
        dialog.show();

        JSONArray jsonArray = new JSONArray();

        if (encodedImageList.isEmpty()){
            Toast.makeText(this, "Please select some images first.", Toast.LENGTH_SHORT).show();
            return;
        }

        for (String encoded: encodedImageList){
            jsonArray.put(encoded);
        }

        try {
          //  jsonObject.put(Const.imageName, et_name.getText().toString().trim());
            jsonObject.put("name", et_name.getText().toString().trim());
            jsonObject.put("password", et_password.getText().toString().trim());
            jsonObject.put("email", et_email.getText().toString().trim());
            jsonObject.put("address", et_address.getText().toString().trim());
            jsonObject.put("country", et_country.getText().toString().trim());
            jsonObject.put("pincode", et_pincode.getText().toString().trim());
            jsonObject.put("state", et_state.getText().toString().trim());
            jsonObject.put("city", et_city.getText().toString().trim());
            jsonObject.put("phone", et_phone.getText().toString().trim());
            jsonObject.put("Alternate_number", et_alternate.getText().toString().trim());
            jsonObject.put("com_address", et_com_address.getText().toString().trim());
            jsonObject.put("com_city", et_com_city.getText().toString().trim());
            jsonObject.put("com_country", et_com_country.getText().toString().trim());
            jsonObject.put("com_state", et_com_state.getText().toString().trim());
            jsonObject.put("com_pin", et_com_pin.getText().toString().trim());
            jsonObject.put("sim_slot_no",mPhoneNumber);
            jsonObject.put(Const.imageList, jsonArray);
        } catch (JSONException e) {
            Log.e("JSONObject Here", e.toString());
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Const.urlUpload, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.e("Message from server", jsonObject.toString());
                        dialog.dismiss();
                       // messageText.setText("Images Uploaded Successfully");
                        Toast.makeText(getApplication(), "Images Uploaded Successfully", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("Message from server", volleyError.toString());
                Toast.makeText(getApplication(), "Error Occurred", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy( 200*30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }



    private void values(){

        strEmail = et_email.getText().toString();
        strPass = et_password.getText().toString();
        strRepass = et_confirmpass.getText().toString();
        strName = et_name.getText().toString();
        strAddress = et_address.getText().toString();
        strCountry = et_country.getText().toString();
        strPin = et_pincode.getText().toString();
        strState = et_state.getText().toString();
        strCity = et_city.getText().toString();
        strPhone = et_phone.getText().toString();
        strAlter = et_alternate.getText().toString();
        strcomAddress = et_com_address.getText().toString();
        strcomCity = et_com_city.getText().toString();
        strcomCountry = et_country.getText().toString();
        strcomState = et_com_state.getText().toString();
        strcomPin = et_com_pin.getText().toString();
    }

    public void validation(){
        if (strEmail.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter The Email",Toast.LENGTH_SHORT,MDToast.TYPE_ERROR).show();
        }else if (strPass.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the password",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strRepass.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the Re-type Password",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strPass.equals(strRepass)){
            MDToast.makeText(getApplicationContext(),"Password and re-type password not match",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strRepass.equals(strPass)){
            MDToast.makeText(getApplicationContext(),"Password and re-type password not match",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strName.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the Name",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strAddress.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the Address",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strCountry.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the Country",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strPin.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the Pincode",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strState.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the State",Toast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
        }else if (strCity.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the City",Toast.LENGTH_SHORT,MDToast.TYPE_ERROR).show();
        }else if (strPhone.equals("")){
            MDToast.makeText(getApplicationContext(),"Enter the Phone Number",Toast.LENGTH_SHORT,MDToast.TYPE_ERROR).show();
        }else if (emailPattern.matches(strEmail)){
            MDToast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();

        }
        else{
            MDToast.makeText(getApplicationContext(),"Enter a valid Email",Toast.LENGTH_LONG).show();

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            // When an Image is picked
            if (requestCode == Const.REQCODE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                imagesUriList = new ArrayList<Uri>();
                encodedImageList.clear();
                if(data.getData()!=null){

                    Uri mImageUri=data.getData();

                    // Get the cursor
                    Cursor cursor = getContentResolver().query(mImageUri,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imageURI  = cursor.getString(columnIndex);
                    cursor.close();

                }else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();
                        ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
                        for (int i = 0; i < mClipData.getItemCount(); i++) {

                            ClipData.Item item = mClipData.getItemAt(i);
                            Uri uri = item.getUri();
                            mArrayUri.add(uri);
                            // Get the cursor
                            Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
                            // Move to first row
                            cursor.moveToFirst();

                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            imageURI  = cursor.getString(columnIndex);
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                            String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
                            encodedImageList.add(encodedImage);
                            cursor.close();
                        }
                        if (mArrayUri.isEmpty()){
                            btn_choose.setEnabled(true);
                            choose_img_txt.setText("Choose Image");
                        }else{
                            btn_choose.setEnabled(false);
                            choose_img_txt.setText("Selected Images: " + mArrayUri.size());
                        }
                     //   noImage.setText("Selected Images: " + mArrayUri.size());
                        MDToast.makeText(getApplicationContext(),"Selected Images: " + mArrayUri.size(),MDToast.LENGTH_LONG,MDToast.TYPE_INFO).show();
                    }
                }
            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
