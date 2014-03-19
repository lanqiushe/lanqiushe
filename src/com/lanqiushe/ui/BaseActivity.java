package com.lanqiushe.ui;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		findViews();
		init();
		setListener();
	}
	protected void findViews(){}
	protected void init(){}
	protected void setListener(){}
}
