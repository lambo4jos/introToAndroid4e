package com.androidintro.myfirstandroidapp;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MyFirstAndroidAppActivity extends Activity {

	private static final String DEBUG_TAG = "MyFirstAppLogging";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first_android_app);
        
        Log.i(DEBUG_TAG, "In the onCreate() method of the MyFirstAndroidAppActivity Class");
    }


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_first_android_app, menu);
        return true;
    }
    
	@Override
	protected void onPause() {
        Log.i(DEBUG_TAG, "In the onPause() method of the MyFirstAndroidAppActivity Class");
	}

    
}
