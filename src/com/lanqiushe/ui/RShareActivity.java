package com.lanqiushe.ui;

import com.lanqiushe.R;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.manager.ToastManager;

import android.os.Bundle;
import android.view.View;

public class RShareActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_register_share);
		TitleManager.showTitle(this, new int[] {}, R.string.share);
		super.onCreate(savedInstanceState);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.register_share_bt: {
			ToastManager.show(this, "·ÖÏí.....");
			break;
		}

		}
	}
}
