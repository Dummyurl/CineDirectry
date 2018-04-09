package com.premsoft.cinedirectry;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Hi Cinema Directory");
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.flContent, new HomeFragment());
        tx.commit();


        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);
        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

//    public void selectDrawerItem(MenuItem menuItem) {
//        // Create a new fragment and specify the fragment to show based on nav item clicked
//        Fragment fragment = null;
//        Class fragmentClass;
//        switch (menuItem.getItemId()) {
//            case R.id.nav_home:
//               // Intent intent = new Intent(MainActivity.this,Home_Activity.class);
//              //  startActivity(intent);
//                fragmentClass = FirstFragment.class;
//                break;
//            case R.id.nav_category:
//                Intent catIntent = new Intent(MainActivity.this,Category_Activity.class);
//                startActivity(catIntent);
//                break;
//            case R.id.nav_search:
//                Intent searcIntent = new Intent(MainActivity.this,Search_Activty.class);
//                startActivity(searcIntent);
//                break;
//
//            case R.id.nav_news:
//                Intent newsIntent = new Intent(MainActivity.this,NewsActivity.class);
//                startActivity(newsIntent);
//                break;
//
//            case R.id.nav_share:
//                try {
//                    Intent i = new Intent(Intent.ACTION_SEND);
//                    i.setType("text/plain");
//                    i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
//                    String sAux = "\nLet me recommend you this application\n\n";
//                    sAux = sAux + "https://play.google.com/store/apps/details?id=com.prem.cinedirectory \n\n";
//                    i.putExtra(Intent.EXTRA_TEXT, sAux);
//                    startActivity(Intent.createChooser(i, "choose one"));
//                } catch(Exception e) {
//                    //e.toString();
//                }
//                break;
//
//            case R.id.nav_about:
//                Intent aboutIntent = new Intent(MainActivity.this,About_Activity.class);
//                startActivity(aboutIntent);
//                break;
//
//            case R.id.nav_faq:
//                Intent faqIntent = new Intent(MainActivity.this,Faq_Activity.class);
//                startActivity(faqIntent);
//                break;
//
//            case R.id.nav_logout:
//                Intent logIntent = new Intent(MainActivity.this,Login_Activity.class);
//                startActivity(logIntent);
//                break;
//
//            default:
//                Intent inte = new Intent(MainActivity.this,Home_Activity.class);
//                startActivity(inte);
//        }
//
//        try {
//            fragment = (Fragment) fragmentClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//          //    Insert the fragment by replacing any existing fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
//
//        // Highlight the selected item has been done by NavigationView
//        menuItem.setChecked(true);
//        // Set action bar title
//        setTitle(menuItem.getTitle());
//        // Close the navigation drawer
//        mDrawer.closeDrawers();
//    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                fragmentClass = Home_Activity.class;
                break;

            case R.id.nav_category:
                fragmentClass = Category_Activity.class;
                break;

            case R.id.nav_search:
                fragmentClass = Search_Activty.class;
                break;

            case R.id.nav_paynow:
                fragmentClass = Paynow_Activity.class;
                break;

            case R.id.nav_profile:
                fragmentClass = Profile_Fragmnet.class;
                break;

            case R.id.nav_news:
                fragmentClass = NewsActivity.class;
                break;

            case R.id.nav_share:
                fragmentClass = Home_Activity.class;
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "Hi Cinema Directory");
                    String sAux = "\nLet me recommend you this application\n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=com.premsoft.cinedirectry \n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "choose one"));
                } catch(Exception e) {
                    e.toString();
                }
                break;

            case R.id.nav_about:
                fragmentClass = About_Activity.class;
                break;

            case R.id.nav_contact:
                fragmentClass = Contact_us.class;
                break;

            case R.id.nav_faq:
                //   Intent faqIntent = new Intent(MainActivity.this,Faq_Activity.class);
                //  startActivity(faqIntent);
                fragmentClass = Faq_Activity.class;
                break;

            case R.id.nav_logout:
                //  Intent logIntent = new Intent(MainActivity.this,Login_Activity.class);
                //  startActivity(logIntent);
               fragmentClass = Login_Fragment.class;

                break;

            default:
                fragmentClass = Home_Activity.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }



    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
