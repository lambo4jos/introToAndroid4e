package com.introtoandroid.advancedlayouts;

import com.androidbook.advancedlayouts.R;

import android.view.Menu;

public class AdvancedLayoutsActivity extends MenuActivity {

    public static final String DEBUG_TAG = "AdvancedLayoutsActivity";

    @Override
    void prepareMenu() {
        addMenuItem("1. Basic Layout", BasicLayoutActivity.class);
        addMenuItem("2. List Layout", MyListActivity.class);
        addMenuItem("3. GridView", GridLayoutActivity.class);
        addMenuItem("4. Adapters", AdaptersActivity.class);
        addMenuItem("5. Styles", StyleSamplesActivity.class);
        addMenuItem("6. Grid, List", GridListMenuActivity.class);
        addMenuItem("7. Dialog", DialogActivity.class);
        addMenuItem("8. Drawer", DrawerActivity.class);
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.advanced_layouts, menu);	
		super.onCreateOptionsMenu(menu);
		return true;
	}
}