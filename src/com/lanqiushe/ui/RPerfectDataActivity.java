package com.lanqiushe.ui;

import com.lanqiushe.R;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.manager.UIManager;

import android.os.Bundle;
import android.view.View;

public class RPerfectDataActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_register_perfect_data);
		TitleManager.showTitle(this, new int[] { TitleManager.BACK_ARROW,TitleManager.OK },
				R.string.perfect_data);
		super.onCreate(savedInstanceState);
	}
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.title_ok_iv:{
			
			UIManager.switcher(this, RShareActivity.class);
			
			break;
		}
			
			
		
 
		}
	}
}
