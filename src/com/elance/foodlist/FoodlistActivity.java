package com.elance.foodlist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class FoodlistActivity extends Activity {

	private List<String> arrayList;
	private String[] categorys;
	
	private Food createFoodObjFromResource(int resourceId) {
		String[] array = getResources().getStringArray(R.array.array0);
		Food food = new Food();
		food.setName(array[0]);
		food.setCategory(array[1]);
		food.setGlycemicLoadGroup(array[2]);
		food.setGlycemicLoad(Float.parseFloat(array[3]));
		if(array.length > 4) {
			food.setServing(Float.parseFloat(array[5]));
		}
		if(array.length > 6) {
			food.setFat(Float.parseFloat(array[7]));
		}
		
		return food;
	}
	
	private List<Food> getStringFromResource() {
		/*
		Resources res = getResources();
		TypedArray arrayList = res.obtainTypedArray(resourceName);
		return arrayList.getString(0);
		*/
		List<Food> food = new ArrayList<Food>();
		food.add(createFoodObjFromResource(R.array.array0));
		food.add(createFoodObjFromResource(R.array.array1));
		food.add(createFoodObjFromResource(R.array.array2));
		food.add(createFoodObjFromResource(R.array.array3));
		food.add(createFoodObjFromResource(R.array.array4));
		food.add(createFoodObjFromResource(R.array.array5));
		return food;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_foodlist);
		setContentView(R.layout.test);
		//arrayList = getStringFromResource();
		// for(int i = 0; i < 10; i++) {
		//categoryList.contains()

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
		updateList(filteredList);
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
