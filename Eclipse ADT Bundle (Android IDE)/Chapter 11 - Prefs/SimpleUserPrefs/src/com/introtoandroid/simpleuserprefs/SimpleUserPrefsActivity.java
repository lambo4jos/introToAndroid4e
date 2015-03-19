package com.introtoandroid.simpleuserprefs;


import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class SimpleUserPrefsActivity extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(android.R.id.content, new SimpleUserPrefsFragment());
		transaction.commit();
	}

    public static class SimpleUserPrefsFragment extends PreferenceFragment {
    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		PreferenceManager manager = getPreferenceManager();
            manager.setSharedPreferencesName("user_prefs");
    		addPreferencesFromResource(R.xml.userprefs);
    	}
    }
}