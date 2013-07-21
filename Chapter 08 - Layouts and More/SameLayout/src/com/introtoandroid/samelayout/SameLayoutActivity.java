package com.introtoandroid.samelayout;

import com.introtoandroid.samelayout.MenuActivity;

import android.os.Bundle;

public class SameLayoutActivity extends MenuActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_layout);	
    }
}