package com.introtoandroid.simplefragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class FieldNoteViewActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			// If the screen is now in landscape mode, we can show the
			// dialog in-line so we don't need this activity.
			finish();
			return;
		}
		if (savedInstanceState == null) {
			// During initial setup, plug in the field note fragment.
			FieldNoteWebViewFragment details = new FieldNoteWebViewFragment();
			details.setArguments(getIntent().getExtras());

			FragmentManager fm = getFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(android.R.id.content, details);
			ft.commit();
		}
	}
}