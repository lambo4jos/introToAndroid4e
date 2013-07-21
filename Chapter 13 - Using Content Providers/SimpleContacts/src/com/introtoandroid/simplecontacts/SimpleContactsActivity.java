package com.introtoandroid.simplecontacts;

import com.androidintro.simplecontacts.R;

import android.app.Activity;
import android.support.v4.content.CursorLoader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

public class SimpleContactsActivity extends Activity {
		
	public static final String DEBUG_TAG = "SimpleContactsActivity";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
    }
	
    public void listContact(View v) {
    	String[] requestedColumns = {
    			ContactsContract.Contacts.DISPLAY_NAME,
    			ContactsContract.CommonDataKinds.Phone.NUMBER,
    	};
    	CursorLoader loader = new CursorLoader(this, 
				ContactsContract.Data.CONTENT_URI, 
				requestedColumns, null,	null, "display_name desc limit 1");
		Cursor contacts = loader.loadInBackground();

		int recordCount = contacts.getCount();
		Log.d(DEBUG_TAG, "Record Count: " + recordCount);
		
		if(recordCount > 0) {
			int nameIdx = contacts
    		    .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
    		int phoneIdx = contacts
    		    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
    		
    		contacts.moveToFirst();
    		Log.d(DEBUG_TAG, "Name: " + contacts.getString(nameIdx));
    		Log.d(DEBUG_TAG, "Phone: " + contacts.getString(phoneIdx));
		}
    }
}