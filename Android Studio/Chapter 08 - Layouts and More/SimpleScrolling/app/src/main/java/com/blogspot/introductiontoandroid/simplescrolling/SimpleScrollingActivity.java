package com.blogspot.introductiontoandroid.simplescrolling;

import com.blogspot.introductiontoandroid.simplescrolling.MenuActivity;

import android.os.Bundle;

public class SimpleScrollingActivity extends MenuActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);	
    }
}