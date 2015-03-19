package com.introtoandroid.viewsamples;

public class FormsActivity extends MenuActivity {
	@Override
	void prepareMenu() {
		addMenuItem("Text Input", TextInputActivity.class);
		addMenuItem("Buttons", ButtonsActivity.class);
		addMenuItem("Pickers", PickersActivity.class);		
	}
}