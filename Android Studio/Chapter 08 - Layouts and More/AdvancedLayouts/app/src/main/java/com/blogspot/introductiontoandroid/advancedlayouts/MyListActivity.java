package com.blogspot.introductiontoandroid.advancedlayouts;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyListActivity extends ListActivity {
	
	private String[] items	= { "Basic Layout", 
								"List Layout", 
								"Grid View" };
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.textview, items));
    }
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Log.d (AdvancedLayoutsActivity.DEBUG_TAG, "pos: "+position + " , id: "+ id);
		switch (position) {
		case 0:
			Intent intent = new Intent(this,
					BasicLayoutActivity.class);
			startActivity(intent);
			break;
		case 1:
			TextView tv = (TextView) v;
			tv.setText("Changed");
			break;
		case 2:
			String original = (String) l
					.getItemAtPosition(position);
			Log.d(AdvancedLayoutsActivity.DEBUG_TAG, "original string: "
					+ original);
			((TextView) v).setText("Updated");
			break;
		}
	}
}