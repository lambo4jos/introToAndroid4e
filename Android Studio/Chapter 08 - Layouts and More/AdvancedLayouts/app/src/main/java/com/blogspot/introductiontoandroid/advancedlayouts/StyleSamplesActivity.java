package com.blogspot.introductiontoandroid.advancedlayouts;


import android.app.Activity;
import android.os.Bundle;

public class StyleSamplesActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTheme(R.style.right);
		setTheme(R.style.ThemeGlow);
		setContentView(R.layout.style_samples);
	}
}