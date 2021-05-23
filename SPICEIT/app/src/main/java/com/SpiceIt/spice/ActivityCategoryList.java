package com.SpiceIt.spice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ActivityCategoryList extends Activity {

	GridView listCategory;
	ProgressBar prgLoading;
	TextView txtAlert;

	// declare adapter object to create custom category list
	AdapterCategoryList cla;

	// create arraylist variables to store data from server
	static ArrayList<Long> Category_ID = new ArrayList<Long>();
	static ArrayList<String> Category_name = new ArrayList<String>();
	static ArrayList<String> Category_image = new ArrayList<String>();

	String CategoryAPI;
	int IOConnect = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_list);

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.header)));
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setHomeButtonEnabled(true);
		bar.setTitle("Category");

		prgLoading = (ProgressBar) findViewById(R.id.prgLoading);
		listCategory = (GridView) findViewById(R.id.listCategory);
		txtAlert = (TextView) findViewById(R.id.txtAlert);

		cla = new AdapterCategoryList(ActivityCategoryList.this);

		// category API url
		CategoryAPI = Constant.CategoryAPI+"?accesskey="+Constant.AccessKey;

		// call asynctask class to request data from server
		new getDataTask().execute();

		// event listener to handle list when clicked
		listCategory.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
									long arg3) {
				// TODO Auto-generated method stub
				// go to menu page
				Intent iMenuList = new Intent(ActivityCategoryList.this, ActivityMenuList.class);
				iMenuList.putExtra("category_id", Category_ID.get(position));
				iMenuList.putExtra("category_name", Category_name.get(position));
				startActivity(iMenuList);
				overridePendingTransition(R.anim.open_next, R.anim.close_next);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_category, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
			case R.id.cart:
				// refresh action
				Intent iMyOrder = new Intent(ActivityCategoryList.this, com.SpiceIt.spice.ActivityCart.class);
				startActivity(iMyOrder);
				overridePendingTransition (R.anim.open_next, R.anim.close_next);
				return true;

			case R.id.refresh:
				IOConnect = 0;
				listCategory.invalidateViews();
				clearData();
				new getDataTask().execute();
				return true;

			case android.R.id.home:
				// app icon in action bar clicked; go home
				this.finish();
				overridePendingTransition(R.anim.open_main, R.anim.close_next);
				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}

	// clear arraylist variables before used
	void clearData(){
		Category_ID.clear();
		Category_name.clear();
		Category_image.clear();
	}

	// asynctask class to handle parsing json in background
	public class getDataTask extends AsyncTask<Void, Void, Void>{

		// show progressbar first
		@SuppressLint("WrongConstant")
		getDataTask(){
			if(!prgLoading.isShown()){
				prgLoading.setVisibility(0);
				txtAlert.setVisibility(8);
			}
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			// parse json data from server in background
			parseJSONData();
			return null;
		}

		@SuppressLint("WrongConstant")
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			// when finish parsing, hide progressbar
			prgLoading.setVisibility(8);

			// if internet connection and data available show data on list
			// otherwise, show alert text
			if((Category_ID.size() > 0) && (IOConnect == 0)){
				listCategory.setVisibility(0);
				listCategory.setAdapter(cla);
			}else{
				txtAlert.setVisibility(0);
			}
		}
	}

	// method to parse json data from server
	public void parseJSONData(){

		clearData();


	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		//cla.imageLoader.clearCache();
		listCategory.setAdapter(null);
		super.onDestroy();
	}


	@Override
	public void onConfigurationChanged(final Configuration newConfig)
	{
		// Ignore orientation change to keep activity from restarting
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
		overridePendingTransition(R.anim.open_main, R.anim.close_next);
	}

}
