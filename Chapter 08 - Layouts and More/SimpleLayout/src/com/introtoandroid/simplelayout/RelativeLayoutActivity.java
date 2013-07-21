package com.introtoandroid.simplelayout;

import com.androidbook.simplelayout.R;

import android.os.Bundle;

public class RelativeLayoutActivity extends MenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative_layout);
		this.getActionBar().setTitle("Relative Layout");
	}

}
