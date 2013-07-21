package com.introtoandroid.simplelayout;

import com.androidbook.simplelayout.R;

import android.os.Bundle;

public class FrameLayoutActivity extends MenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_layout);
		this.getActionBar().setTitle("Frame Layout");
	}

}
