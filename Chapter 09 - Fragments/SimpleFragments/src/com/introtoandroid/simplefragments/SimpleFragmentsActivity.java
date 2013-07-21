package com.introtoandroid.simplefragments;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class SimpleFragmentsActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragments_layout);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.simple_fragments, menu);	
		super.onCreateOptionsMenu(menu);
		return true;
	}
}