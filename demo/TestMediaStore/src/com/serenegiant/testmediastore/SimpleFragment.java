package com.serenegiant.testmediastore;

import java.io.FileNotFoundException;
import java.io.IOException;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.GridView;

public class SimpleFragment extends Fragment {

	private MediaStorePhotoAdapter mAdapter;
	private GridView mGridView;
	
	public SimpleFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		mGridView = (GridView)rootView.findViewById(R.id.gridView1);
		mAdapter = new MediaStorePhotoAdapter(getActivity(), R.layout.grid_item);
		// if you want to show title, set true(you also need TextEdit that id is 'title')
//		mAdapter.setShowTitle(true);
		mGridView.setAdapter(mAdapter);
		registerForContextMenu(mGridView);
		return rootView;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
		switch (view.getId()) {
		case R.id.gridView1:
			getActivity().getMenuInflater().inflate(R.menu.contextmenu_grid, menu);
			 break;
		}
		super.onCreateContextMenu(menu, view, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_delete:
		{
			final int position = ((AdapterContextMenuInfo)item.getMenuInfo()).position;
			// you should confirm to user whether or not to delete
			mAdapter.delete(position);
			return true;
		}
		case R.id.action_copy:
		{
			final int position = ((AdapterContextMenuInfo)item.getMenuInfo()).position;
			// MediaStorePhotoAdapter#add is add image asynchronusly,
			// but getImage may take some time, so it is better to call asynchronusly
			MediaStorePhotoAdapter.queuEvent(new Runnable() {
				@Override
				public void run() {
					try {
						final Bitmap bitmap = mAdapter.getImage(position, 512, 512);
						mAdapter.add(bitmap, "TestMediaStore", String.format("bitmap%d", position), null);
					} catch (FileNotFoundException e) {
					} catch (IOException e) {
					}
				}
			});
			return true;
		}
		default:
			return super.onContextItemSelected(item);
		}
	}
	
}
