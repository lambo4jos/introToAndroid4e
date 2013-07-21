package com.introtoandroid.simpleactionbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SimpleActionBarActivity extends Activity {
	Boolean isHidden = false;
	Button hideActionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_action_bar);
		
		hideActionBar = (Button) findViewById(R.id.hide);
		hideActionBar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!isHidden) {
					getActionBar().hide();
					hideActionBar.setText(R.string.show_action_bar);
				} else {
					getActionBar().show();					
					hideActionBar.setText(R.string.hide_action_bar);
				}
				isHidden = !isHidden;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_action_bar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_add:
            Toast.makeText(this, "Add Clicked", Toast.LENGTH_SHORT).show();
			return true;
        case R.id.menu_close:
        	finish();
        	return true;
        case R.id.menu_help:
            Toast.makeText(this, "Help Clicked", Toast.LENGTH_SHORT).show();
        	return true;
        default:
            return super.onOptionsItemSelected(item);
		}
	}
}