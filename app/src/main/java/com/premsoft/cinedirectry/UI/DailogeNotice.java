package com.premsoft.cinedirectry.UI;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.premsoft.cinedirectry.R;


public class DailogeNotice extends Activity {
   
	TextView date,code,msg,flink,title;
	Button readmore,close;
	ImageView image;
	private DisplayImageOptions options;

	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.gcm_dialog);
    	
    	date=(TextView)findViewById(R.id.date);
		image=(ImageView)findViewById(R.id.image);
		msg=(TextView)findViewById(R.id.msg);
		readmore=(Button)findViewById(R.id.readmore);
		
		final Bundle b=getIntent().getExtras();
		
		date.setText(b.getString("title"));
		msg.setText(b.getString("msg"));
		Linkify.addLinks(msg, Linkify.ALL);

		options = new DisplayImageOptions.Builder().cacheInMemory(true)
				.cacheOnDisc(true).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this).defaultDisplayImageOptions(options).build();
		ImageLoader.getInstance().init(config);

		try {
			ImageLoader.getInstance().displayImage(b.getString("image"),image);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(b.getString("link").equalsIgnoreCase("http://")){
			readmore.setVisibility(View.GONE);
		}else{
			readmore.setVisibility(View.VISIBLE);
			readmore.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getApplicationContext(), CustomeWebView.class);
					
					intent.putExtra("link", b.getString("link"));
				    startActivity(intent);
				}
			});
			
		}
		
		close=(Button)findViewById(R.id.close);
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
	
		
    }


}