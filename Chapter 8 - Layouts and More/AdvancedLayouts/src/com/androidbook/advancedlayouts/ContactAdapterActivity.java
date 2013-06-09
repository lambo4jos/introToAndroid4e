package com.androidbook.advancedlayouts;

import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ContactAdapterActivity extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] requestedColumns = {
				ContactsContract.CommonDataKinds.Phone._ID,
				ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
				ContactsContract.CommonDataKinds.Phone.NUMBER,
		};
		CursorLoader loader = new CursorLoader(this, 
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
				requestedColumns, null, null, null);
		Cursor contacts = loader.loadInBackground();
		setContentView(R.layout.contact);
		
		ListAdapter adapter = new SimpleCursorAdapter(this, 
				R.layout.contact_item_simple, 
				contacts, 
				new String[] { 
					ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME 
				}, 
				new int[] { 
					R.id.contact_item_simple_text
				}, 0);
		setListAdapter(adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView,
	 * android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Cursor phone = (Cursor) l.getItemAtPosition(position);

		TextView tv = ((TextView) v);
		String name = phone.getString(phone.getColumnIndex(
				ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
		String num = phone.getString(phone.getColumnIndex(
				ContactsContract.CommonDataKinds.Phone.NUMBER));

		String displayed = tv.getText().toString();
		if (displayed.compareTo(name) == 0) {
			tv.setText(num);
		} else {
			tv.setText(name);
		}
		Log.d(AdvancedLayoutsActivity.DEBUG_TAG, "Cursor pos: "	+ 
				phone.getPosition() + "== list pos: "	+ position);
		Log.d(AdvancedLayoutsActivity.DEBUG_TAG, "Cursor id: " + 
				phone.getString(phone.getColumnIndex(
						ContactsContract.CommonDataKinds.Phone._ID)) + 
						"== list id: " + id);
	}
}