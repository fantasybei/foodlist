package com.elance.foodlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class FoodlistActivity extends Activity {

	private List<String> arrayList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foodlist);
		arrayList = new ArrayList<String>();
		// for(int i = 0; i < 10; i++) {
		arrayList.add("Fish");
		arrayList.add("Guava");
		arrayList.add("Orange");
		arrayList.add("Pineapple");
		arrayList.add("Apple");
		arrayList.add("Beef");

		// }

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.simple_text, R.id.text1, arrayList);
		ListView lv = (ListView) findViewById(R.id.listView1);
		TextView header = (TextView) getLayoutInflater().inflate(
				R.layout.simple_text, null);
		TextView footer = (TextView) getLayoutInflater().inflate(
				R.layout.simple_text, null);
		header.setText("Header");
		footer.setText("Footer");
		lv.addHeaderView(header);
		lv.addFooterView(footer, null, false);

		lv.setAdapter(adapter);

		lv.setFooterDividersEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_foodlist, menu);
		return true;
	}

	private void updateList(List<String> array) {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.simple_text, R.id.text1, array);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(adapter);
	}

	public void search(View view) {
		String searchString = ((EditText) findViewById(R.id.searchText))
				.getText().toString();
		List<String> filteredList = new ArrayList<String>();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).toLowerCase()
					.indexOf(searchString.toLowerCase()) != -1) {
				filteredList.add(arrayList.get(i));
			}
		}
		//updateList(Arrays.sort(filteredList));
		/*
		 * new AlertDialog.Builder(this).setMessage(searchString).setTitle(
		 * "Search Title"
		 * ).setCancelable(true).setNeutralButton(android.R.string.cancel, new
		 * DialogInterface.OnClickListener() {
		 * 
		 * public void onClick(DialogInterface dialog, int which) { // TODO
		 * Auto-generated method stub
		 * 
		 * } }).show();
		 */
	}
}
