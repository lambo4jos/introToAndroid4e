package com.introtoandroid.simplelayout;

import com.androidbook.simplelayout.R;

import android.os.Bundle;

public class SimpleLayoutActivity extends MenuActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_layout);
        this.getActionBar().setTitle("Simple Layout");
    	
    }
}