package com.introtoandroid.supportfragdialog;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SupportFragDialogActivity extends FragmentActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Handle Alert Dialog Button
		Button launchAlertDialog = (Button) findViewById(R.id.Button_AlertDialog);
		launchAlertDialog.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String strFragmentNumber = "Fragment Instance One";
				DialogFragment newFragment = MyAlertDialogFragment.newInstance(strFragmentNumber);
				showDialogFragment(newFragment, strFragmentNumber);
			}
		});
		// Handle Alert Dialog 2 Button
		Button launchAlertDialog2 = (Button) findViewById(R.id.Button_AlertDialog2);
		launchAlertDialog2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String strFragmentNumber = "Fragment Instance Two";
				DialogFragment newFragment = MyAlertDialogFragment.newInstance(strFragmentNumber);
				showDialogFragment(newFragment, strFragmentNumber);
			}
		});
	}

	void showDialogFragment(DialogFragment newFragment, String strFragmentNumber) {
		newFragment.show(getSupportFragmentManager(), strFragmentNumber);
	}

	public void doPositiveClick(String strFragmentNumber) {
		Toast.makeText(getApplicationContext(),
				"Clicked OK! (" + strFragmentNumber + ")", Toast.LENGTH_SHORT).show();
	}
}