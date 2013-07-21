package com.introtoandroid.simplealtresources;

import com.androidintro.simplealtresources.R;

import android.app.Activity;
import android.os.Bundle;

public class SimpleAltResourcesActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}