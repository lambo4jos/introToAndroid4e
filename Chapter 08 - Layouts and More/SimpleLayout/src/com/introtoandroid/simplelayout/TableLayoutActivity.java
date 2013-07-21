package com.introtoandroid.simplelayout;

import com.androidbook.simplelayout.R;

import android.os.Bundle;

public class TableLayoutActivity extends MenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table_layout);
		this.getActionBar().setTitle("Table Layout");
	}

}