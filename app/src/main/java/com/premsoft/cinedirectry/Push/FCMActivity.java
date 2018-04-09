package com.premsoft.cinedirectry.Push;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.premsoft.cinedirectry.R;
import com.premsoft.cinedirectry.Server.Server;
import com.premsoft.cinedirectry.Server.ServerConfig;

import org.json.JSONObject;
import java.util.Calendar;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;


public class FCMActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    public static String REG_EMAIL = "user_email";
    public static String NEW_NOTIFICATION = "NEW_NOTIFICATION";
    String possibleEmail;
    Context context;
    int MY_PERMISSIONS_REQUEST = 8888;
    int MY_PERMISSIONS_EMAIL = 8889;
    private double latPoint;
    private double lngPoint;
    private LocationGooglePlayServicesProvider provider;
    private io.nlopez.smartlocation.SmartLocation smartLocation;

    public static boolean isNetworkAvailable(Context c) {
        ConnectivityManager connectivityManager = (ConnectivityManager) c
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String getRegistrationEmail(Context c) {
        final SharedPreferences prefs = c.getSharedPreferences("GCM",
                c.MODE_PRIVATE);
        return prefs.getString(REG_EMAIL, "");
    }

    public static String getToken(Context c) {
        final SharedPreferences prefs = c.getSharedPreferences("GCM",
                c.MODE_PRIVATE);
        return prefs.getString(PushUser.TOKEN, "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isNetworkAvailable(getApplicationContext())) {

            provider = new LocationGooglePlayServicesProvider();
            provider.setCheckLocationSettings(true);

            smartLocation = new SmartLocation.Builder(this).logging(true).build();


            int status = GooglePlayServicesUtil
                    .isGooglePlayServicesAvailable(getBaseContext());

            // Showing status
            if (status == ConnectionResult.SUCCESS) {

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.GET_ACCOUNTS},
                            MY_PERMISSIONS_EMAIL);
                } else {
                    Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
                    Account[] accounts = AccountManager.get(FCMActivity.this).getAccounts();
                    for (Account account : accounts) {
                        if (emailPattern.matcher(account.name).matches()) {
                            possibleEmail = account.name;
                        }
                    }
                    final SharedPreferences prefs = this.getSharedPreferences("GCM",
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString(REG_EMAIL, possibleEmail);
                    editor.commit();
                    getLocationPermission();

                }


            } else {
                int requestCode = 10;
                Dialog dialog = GooglePlayServicesUtil.getErrorDialog(
                        status, this, requestCode);
                dialog.show();
            }
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setCancelable(true);
            alert.setTitle("Oops!!!");
            alert.setNeutralButton("Okay!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    // MainActivity.this.finish();
                }
            });
            alert.setMessage("You  are not connected to Internet right now! Please check your internet connection");
            alert.show();
        }

    }

    private void getLocationPermission() {
        if (getResources().getBoolean(R.bool.is_location_enabled)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    Toast.makeText(FCMActivity.this, "You must provide access to use this app!", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                            MY_PERMISSIONS_REQUEST);

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                            MY_PERMISSIONS_REQUEST);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            } else {
                smartLocation.location(provider).oneFix().start(new OnLocationUpdatedListener() {
                    @Override
                    public void onLocationUpdated(Location location) {
                        latPoint = location.getLatitude();
                        lngPoint = location.getLongitude();

                        final SharedPreferences prefs = FCMActivity.this.getSharedPreferences("GCM",
                                Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString(PushUser.LAST_LAT, latPoint + "");
                        editor.putString(PushUser.LAST_LONG, lngPoint + "");
                        editor.commit();
                    }
                });
            }

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent intent = new Intent(FCMActivity.this, AlarmBrodcastReceiver.class);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(FCMActivity.this, 0, intent, 0);
            Calendar cal = Calendar.getInstance();
            // start 30 seconds after boot completed
            cal.add(Calendar.SECOND, 30);
            try {
                alarmManager.cancel(pendingIntent);
            } catch (Exception e) {
                Log.e("Alarm", "AlarmManager update was not canceled. " + e.toString());
            }
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 30 * 60 * 1000,
                    pendingIntent);

        }
    }

    private void updateToken(String token) {
        RequestParams params = new RequestParams();
        params.put(PushUser.EMAIL, getRegistrationEmail(this));
        params.put(PushUser.APP_TYPE, ServerConfig.APP_TYPE);
        params.put(PushUser.TOKEN, token);
        params.put(PushUser.DEVICE_MODEL, DeviceUtils.getDeviceModel());
        params.put(PushUser.DEVICE_API, DeviceUtils.getDeviceAPILevel());
        params.put(PushUser.DEVICE_OS, DeviceUtils.getDeviceOS());
        params.put(PushUser.DEVICE_NAME, DeviceUtils.getDeviceName());
        params.put(PushUser.TIMEZONE, DeviceUtils.getDeviceTimeZone());
        params.put(PushUser.LAST_LAT, DeviceUtils.getLastlat(this) + "");
        params.put(PushUser.LAST_LONG, DeviceUtils.getLastLng(this) + "");
        params.put(PushUser.MEMORY, DeviceUtils.getDeviceMemory(this) + "");
        params.put(PushUser.DEVICE_ID, DeviceUtils.getDeviceId(this) + "");
        params.put(PushUser.PIN_CODE, DeviceUtils.getPinCode(this) + "");

        Server.post(ServerConfig.REGISTRATION_URL, params,
                new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, (cz.msebera.android.httpclient.Header[]) headers, response);
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 8888: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    smartLocation.location(provider).oneFix().start(new OnLocationUpdatedListener() {
                        @Override
                        public void onLocationUpdated(Location location) {
                            latPoint = location.getLatitude();
                            lngPoint = location.getLongitude();

                            final SharedPreferences prefs = FCMActivity.this.getSharedPreferences("GCM",
                                    Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString(PushUser.LAST_LAT, latPoint + "");
                            editor.putString(PushUser.LAST_LONG, lngPoint + "");
                            editor.commit();
                        }
                    });

                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                    Intent intent = new Intent(FCMActivity.this, AlarmBrodcastReceiver.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(FCMActivity.this, 0, intent, 0);
                    Calendar cal = Calendar.getInstance();
                    // start 30 seconds after boot completed
                    cal.add(Calendar.SECOND, 5);
                    try {
                        alarmManager.cancel(pendingIntent);
                    } catch (Exception e) {
                        Log.e("Alarm", "AlarmManager update was not canceled. " + e.toString());
                    }
                    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 30 * 60 * 1000,
                            pendingIntent);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            case 8889: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
                    Account[] accounts = AccountManager.get(FCMActivity.this).getAccounts();
                    for (Account account : accounts) {
                        if (emailPattern.matcher(account.name).matches()) {
                            possibleEmail = account.name;
                        }
                    }
                    final SharedPreferences prefs = this.getSharedPreferences("GCM",
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString(REG_EMAIL, possibleEmail);
                    editor.commit();
                }
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        FirebaseInstanceId instanceId = FirebaseInstanceId.getInstance();
                        String token = instanceId.getToken();
                        final SharedPreferences prefs = FCMActivity.this.getSharedPreferences("GCM",
                                Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString(PushUser.TOKEN, token);
                        editor.commit();
                        updateToken(token);
                        return null;
                    }
                }.execute();
                getLocationPermission();
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
