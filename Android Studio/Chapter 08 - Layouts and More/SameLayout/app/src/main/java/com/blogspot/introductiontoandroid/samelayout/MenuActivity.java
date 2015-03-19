package com.blogspot.introductiontoandroid.samelayout;


import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public abstract class MenuActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.layout_menu, menu);	
		menu.findItem(R.id.program_menu_item).setIntent(new Intent(this, ProgrammaticLayoutActivity.class));
		menu.findItem(R.id.resource_menu_item).setIntent(new Intent(this, ResourceLayoutActivity.class));
		super.onCreateOptionsMenu(menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		startActivity(item.getIntent());
		super.onOptionsItemSelected(item);
		return true;
	}

}