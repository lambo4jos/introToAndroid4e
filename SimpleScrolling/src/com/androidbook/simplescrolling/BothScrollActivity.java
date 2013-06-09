package com.androidbook.simplescrolling;

import android.os.Bundle;

public class BothScrollActivity extends MenuActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("ScrollView");
        setContentView(R.layout.allscroll);
    }
}