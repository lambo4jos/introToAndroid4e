package com.androidbook.advancedlayouts;
import android.app.Activity;
import android.content.CursorLoader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
public class ListAdapterSampleActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("List Adapter");
        Cursor contacts = loader.loadInBackground();
        setContentView(R.layout.scratch_list);
        int view_id = R.id.scratch_adapter_view;
        ListView av = (ListView) findViewById(view_id);
        av.setAdapter(adapter);
        av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
                		Toast.makeText(ListAdapterSampleActivity.this, 
            		}
        });
    }
}