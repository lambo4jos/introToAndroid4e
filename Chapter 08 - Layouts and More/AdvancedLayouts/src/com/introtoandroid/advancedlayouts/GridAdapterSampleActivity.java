package com.introtoandroid.advancedlayouts;
import android.app.Activity;
import android.content.CursorLoader;import android.database.Cursor;
import android.os.Bundle;import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
public class GridAdapterSampleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("Grid Adapter");        CursorLoader loader = new CursorLoader(this,         		ContactsContract.CommonDataKinds.Phone.CONTENT_URI,         		null, null, null, null);
        Cursor contacts = loader.loadInBackground();        ListAdapter adapter = new SimpleCursorAdapter(this,         		R.layout.scratch_layout,         		contacts,         		new String[] {
        			ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,         			ContactsContract.CommonDataKinds.Phone.NUMBER        		}, new int[] {         			R.id.scratch_text1, R.id.scratch_text2        		}, 0);
        setContentView(R.layout.scratch_grid);
        int view_id = R.id.scratch_adapter_view;
        GridView av = (GridView) findViewById(view_id);
        av.setAdapter(adapter);
        av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override        	public void onItemClick(AdapterView<?> parent,         			View view, int position, long id) {
                		Toast.makeText(GridAdapterSampleActivity.this,                 				"Clicked _id=" + id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}