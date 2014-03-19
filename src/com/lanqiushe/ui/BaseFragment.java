package com.lanqiushe.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ListView;

public class BaseFragment extends Fragment {
	public static final String tag= "BaseFragment";
	public FragmentActivity fa;
	public FragmentManager fm;
	public ListView mlv;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		fa = (FragmentActivity) activity;
		fm = getFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		findViews();
		init();
		setListener();

	}

	public void findViews() {
	};

	public void init() {
	}

	public void setListener() {
	}

}
