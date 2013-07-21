package com.introtoandroid.viewsamples;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;

public class ViewSampleActivity extends MenuActivity {
	public final static String debugTag = "ViewSample";

	void prepareMenu() {
		addMenuItem("Forms", FormsActivity.class);
		addMenuItem("Indicators", IndicatorsActivity.class);
		addMenuItem("Containers", ContainersActivity.class);
		addMenuItem("Text Display", TextDisplayActivity.class);
		addMenuItem("Events", EventsActivity.class);
	}

    @Override
	public boolean onCreateOptionsMenu(
	    android.view.Menu menu) {
	     super.onCreateOptionsMenu(menu);
	     
	     menu.add("Forms")
	         .setIcon(android.R.drawable.ic_menu_edit)
	         .setIntent(new Intent(this, FormsActivity.class));
	     menu.add("Indicators")
	         .setIntent(new Intent(this, IndicatorsActivity.class))
	         .setIcon(android.R.drawable.ic_menu_info_details);
	     menu.add("Containers")
	         .setIcon(android.R.drawable.ic_menu_view)
	         .setIntent(new Intent(this, ContainersActivity.class));
	     
	     SubMenu style_choice = menu.addSubMenu("Style").setIcon(android.R.drawable.ic_menu_preferences);
	     style_choice.add(style_group, light_id, 1, "Light").setChecked(isLight);
	     style_choice.add(style_group, dark_id, 2, "Dark").setChecked(!isLight);
	     style_choice.setGroupCheckable(style_group, true, true);
	             
	     Log.d(ViewSampleActivity.debugTag, "onCreateOptionsMenu() called");
	     
	     return true;
	}

    private static final int light_id = 1;
    private static final int dark_id = 2;
    private static final int style_group = 1;
    private boolean isLight = true;

    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    if (item.getItemId() == light_id) {
	       item.setChecked(true);
	       isLight = true;
	       return true;
	    } else if (item.getItemId() == dark_id) {
	        item.setChecked(true);
	        isLight = false;
	        return true;
	    }   
	    return super.onOptionsItemSelected(item);
	}
}