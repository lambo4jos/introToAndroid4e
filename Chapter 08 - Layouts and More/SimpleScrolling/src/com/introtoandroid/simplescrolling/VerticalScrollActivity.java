package com.introtoandroid.simplescrolling;

import com.androidbook.simplescrolling.R;

import android.os.Bundle;

public class VerticalScrollActivity extends MenuActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verticalscroll);
    }
}