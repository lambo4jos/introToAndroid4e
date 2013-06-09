package com.androidbook.simplescrolling;

import android.os.Bundle;

public class NoScrollActivity extends MenuActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("No Scrolling");
        setContentView(R.layout.noscroll);
    }
}