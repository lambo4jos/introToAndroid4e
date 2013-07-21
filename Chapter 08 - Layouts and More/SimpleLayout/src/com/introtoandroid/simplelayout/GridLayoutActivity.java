package com.introtoandroid.simplelayout;


import android.os.Bundle;

public class GridLayoutActivity extends MenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_layout);
		this.getActionBar().setTitle("Grid Layout");
	}

}