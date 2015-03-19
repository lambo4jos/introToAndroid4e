package com.introtoandroid.simplelayout;


import android.os.Bundle;

public class MultipleLayoutActivity extends MenuActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.multiple_layout);
		
		this.getActionBar().setTitle("Multiple Layout");
	}
}
