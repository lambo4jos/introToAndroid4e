package com.androidbook.simplescrolling;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public abstract class MenuActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.layout_menu, menu);	
		menu.findItem(R.id.noscroll_menu_item).setIntent(new Intent(this, NoScrollActivity.class));
		menu.findItem(R.id.verticalscroll_menu_item).setIntent(new Intent(this, VerticalScrollActivity.class));
		menu.findItem(R.id.horizontalscroll_menu_item).setIntent(new Intent(this, HorizontalScrollActivity.class));
		menu.findItem(R.id.bothscroll_menu_item).setIntent(new Intent(this, BothScrollActivity.class));
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
