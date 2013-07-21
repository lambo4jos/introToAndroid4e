package com.introtoandroid.simplelayout;

import com.androidbook.simplelayout.R;

import android.os.Bundle;

public class LinearLayoutActivity extends MenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_layout);
		this.getActionBar().setTitle("Linear Layout");
	}

}
