package com.introtoandroid.userprefsheaders;

import java.util.List;


import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class UserPrefsActivity extends PreferenceActivity {
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
	@Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }
	
    public static class UserNameFragment extends PreferenceFragment {
    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		PreferenceManager manager = getPreferenceManager();
            manager.setSharedPreferencesName("user_prefs");
    		addPreferencesFromResource(R.xml.personal_settings);
    	}
    }
    
    public static class GameSettingsFragment extends PreferenceFragment {
    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		PreferenceManager manager = getPreferenceManager();
            manager.setSharedPreferencesName("user_prefs");
    		addPreferencesFromResource(R.xml.game_settings);
    	}
    }
    
    public static class CharacterSettingsFragment extends PreferenceFragment {
    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		PreferenceManager manager = getPreferenceManager();
            manager.setSharedPreferencesName("user_prefs");
    		addPreferencesFromResource(R.xml.character_settings);
    	}
    }
}