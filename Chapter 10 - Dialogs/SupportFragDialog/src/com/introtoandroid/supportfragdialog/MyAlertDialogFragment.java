package com.introtoandroid.supportfragdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class MyAlertDialogFragment extends DialogFragment {
	public static MyAlertDialogFragment newInstance(String fragmentNumber) {	
		MyAlertDialogFragment newInstance = new MyAlertDialogFragment();
		Bundle args = new Bundle();
		args.putString("fragnum", fragmentNumber);
		newInstance.setArguments(args);
		return newInstance;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final String fragNum = getArguments().getString("fragnum");
		
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
		alertDialog.setTitle("Alert Dialog");
		alertDialog.setMessage("This alert brought to you by " + fragNum );
		alertDialog.setIcon(android.R.drawable.btn_star);
		alertDialog.setPositiveButton(android.R.string.ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						((SupportFragDialogActivity) getActivity())
								.doPositiveClick(fragNum);
						return;
					}
				});
		return alertDialog.create();
	}
}