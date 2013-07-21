package com.introtoandroid.advancedlayouts;

import com.androidbook.advancedlayouts.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogActivity extends Activity {

    @Override
    protected void onCreate(
        Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.dialog);
        
        Button b = (Button)findViewById(R.id.do_dialog_btn);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(DialogActivity.this)
                	.setMessage("Press agree to continue...")
                	.setPositiveButton("Agree", null)
                	.show();
            }           
        });
    }
}