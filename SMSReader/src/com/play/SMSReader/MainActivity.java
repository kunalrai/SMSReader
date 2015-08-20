package com.play.SMSReader;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;

public class MainActivity extends Activity{

	ListView lvMsg;
	TextView lblMsg, lblNo;
	SimpleCursorAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvMsg = (ListView) findViewById(R.id.lvMsg);

	}


	public void ShowMessages(View v){
		Uri inboxURI = Uri.parse("content://sms/inbox");

		String[] reqCols = new String[] { "_id", "address", "body" };

		ContentResolver cr = getContentResolver();

		Cursor c = cr.query(inboxURI, reqCols, null, null, null);

		adapter = new SimpleCursorAdapter(this, R.layout.row, c,
				new String[] { "body", "address" }, new int[] {
						R.id.lblMsg, R.id.lblNumber }, CursorAdapter.NO_SELECTION);
		lvMsg.setAdapter(adapter);

	}
}