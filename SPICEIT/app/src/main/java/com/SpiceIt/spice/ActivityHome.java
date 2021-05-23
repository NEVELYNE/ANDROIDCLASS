package com.SpiceIt.spice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class ActivityHome extends Fragment {
	GridView gridview;
	AdapaterGridView gridviewAdapter;
	ArrayList<GridViewItem> data = new ArrayList<GridViewItem>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_list, container, false);

		gridview = (GridView) v.findViewById(R.id.gridView1);


		data.add(new GridViewItem("Carrots", getResources().getDrawable(R.drawable.carrots)));
		data.add(new GridViewItem("Onions", getResources().getDrawable(R.drawable.onion)));
		data.add(new GridViewItem("Tomatoes", getResources().getDrawable(R.drawable.tomato)));
		data.add(new GridViewItem("Green Paper", getResources().getDrawable(R.drawable.green)));

		setDataAdapter();

		return v;
	}

	// Set the Data Adapter
	private void setDataAdapter() {
		gridviewAdapter = new AdapaterGridView(getActivity(), R.layout.fragment_list_item, data);
		gridview.setAdapter(gridviewAdapter);
	}




}