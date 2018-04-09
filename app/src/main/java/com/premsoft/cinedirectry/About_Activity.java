package com.premsoft.cinedirectry;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * Created by Admin on 2/22/2018.
 */

public class About_Activity extends Fragment {

    WebView webView;

//    @SuppressLint("NewApi")
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.about_activity);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("About");
//
//    }

    public About_Activity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_contact, container, false);
        webView = (WebView) rootView.findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/about.html");
//        TextView text = rootView.findViewById(R.id.text);
//        text.setText(Html.fromHtml("<h3 style=\"text-align: justify;\"><strong>Over 12 combined year&rsquo;s experience</strong></h3>\n" +
//                "<p style=\"text-align: justify;\">PREMSOFT SOFTWARE TECHNLOGIES, a leading software company and also Publishing, web hosting and modeling house is well known in the advertising circle and film environment for more than a decade. In 2002, a relevant website was created and which has evoked great interest from all quarters.</p>\n" +
//                "<p style=\"text-align: justify;\">www.hicinemadirectory.com needs no introduction. It has, today, literally become a hunting ground for both, advertisers and model aspirants alike.</p>\n" +
//                "<p style=\"text-align: justify;\">The website regularly updated its photographs with precise information on personal data. Fresher&rsquo;s or models, being in Mumbai, Chennai, Delhi, Bangalore, Kolkata or any part of the world, they can reach the media industry just by clicking www.hicinemadirectory.com without seeking the help of any model coordinators or mediators.</p>\n" +
//                "<h4 style=\"text-align: justify;\"><strong>Promotional Strategies</strong></h4>\n" +
//                "<p style=\"text-align: justify;\">We are committed to actively promoting this website around the world. We want to make it one of the most widely viewed model data bank on the internet. It is professional. It is easy to access and navigate. Our intention is to make it one of the greatest websites of its kind.</p>\n" +
//                "<p style=\"text-align: justify;\">hicinemadirectory.com is the modeling / acting industry's Number 1 directory service and the only modeling service that guarantees that your photos will be viewed by legitimate media personnel and scouts for over 100 international modeling agencies within 24 hours after your photos are submitted.</p>\n" +
//                "<p style=\"text-align: justify;\">hicinemadirectory.com is a team of the modeling industries most powerful and legitimate international model agents and scouts from around the world working together to help new models begin exciting careers as models / actors.</p>\n" +
//                "<p style=\"text-align: justify;\">The domain reaches the desk of Ad film makers, T and film directors, producers, Ad agency heads, Media Personnel, Event Managers, Fashion Houses, Textile Designers, Camera Professionals, TV Production Companies (Delhi, Mumbai, Chennai, Bangalore, Kolkata, Hyderabad) without payment login.</p>\n" +
//                "<h4 style=\"text-align: justify;\"><strong>Studio</strong></h4>\n" +
//                "<p style=\"text-align: justify;\">PREMSOFT SOFTWARE TECHNLOGIES offers studio with fashionable backdrops and digital special effects lights, making each photo session unique, varied and most importantly fun! We offer a full professional photographic service to businesses and the fashion photography.</p>\n" +
//                "<h4 style=\"text-align: justify;\"><strong>Success stories</strong></h4>\n" +
//                "<p style=\"text-align: justify;\">Success stories speak highly of this website. It&rsquo;s a fact that many of the aspiring models have been selected and have featured in character and lead roles, as heroes and heroines in films and the small screen, and as models for products or services in TV commercial, print and outdoor media. Chennai Modelling Diary.com has hundreds of Success Stories of new models that have gone on to have successful and lucrative careers. We couldn't possibly post them all on our website but we have posted a few of them to give you an idea of the extent of our success.<br />Anyone, with a little desire to make an entry into the world of advertising, comparing, modelling, TV or Films has now got the right \"</p>"));

        return rootView;
    }
}
