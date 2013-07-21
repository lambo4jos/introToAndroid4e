package com.introtoandroid.simplelayout;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public abstract class MenuActivity extends Activity {
    private static final String DEBUG_TAG = "MenuActivity";

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.simple_layout, menu);

		setIntentOnMenuItem(menu, R.id.frame_menu_item, new Intent(this, FrameLayoutActivity.class));
		setIntentOnMenuItem(menu, R.id.relative_menu_item, new Intent(this, RelativeLayoutActivity.class));
		setIntentOnMenuItem(menu, R.id.linear_menu_item, new Intent(this, LinearLayoutActivity.class));
		setIntentOnMenuItem(menu, R.id.table_menu_item, new Intent(this, TableLayoutActivity.class));
		setIntentOnMenuItem(menu, R.id.grid_menu_item, new Intent(this, GridLayoutActivity.class));
		setIntentOnMenuItem(menu, R.id.multi_menu_item, new Intent(this, MultipleLayoutActivity.class));
		super.onCreateOptionsMenu(menu);
		return true;
	}


	private void setIntentOnMenuItem(Menu menu, int menuId,
        Intent intent) {
       MenuItem menuItem = menu.findItem(menuId);
       if (menuItem != null) {
           menuItem.setIntent(intent);
       } else {
           Log.w(DEBUG_TAG, "Warning: Can't find menu item: "+menuId);
       }
    }


    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		startActivity(item.getIntent());
		
		super.onOptionsItemSelected(item);
		return true;
	}

}
