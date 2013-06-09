package com.androidbook.samelayout;

import android.os.Bundle;

public class ResourceLayoutActivity extends MenuActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resource_based_layout);
    }
}