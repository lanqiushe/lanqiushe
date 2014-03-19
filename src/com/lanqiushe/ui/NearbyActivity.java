package com.lanqiushe.ui;

import java.util.ArrayList;

import com.lanqiushe.R;
import com.lanqiushe.adapter.NearbyContentAdapter;
import com.lanqiushe.adapter.NearbyFragmentAdapter;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.manager.ToastManager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

@SuppressLint("ResourceAsColor")
public class NearbyActivity extends FragmentActivity implements
		OnPageChangeListener {
	 
	private ViewPager mvp;
	 
   
    private ArrayList<TextView> tvList;  
	private ArrayList<RadioButton> rbList; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_nearby);
		TitleManager.showTitle(this, null, R.string.title_nearby);
		super.onCreate(savedInstanceState);

		findViews();
		init();
		setListener();
	}

	private void findViews() {
		
	 
		
		mvp = (ViewPager) findViewById(R.id.nearby_vp);
		mvp.setOffscreenPageLimit(2);

	}

	private void init() {
		 tvList = new ArrayList<TextView>();
		rbList = new ArrayList<RadioButton>();
		 tvList.add(((TextView) findViewById(R.id.top_nav_left_tv)));
		 tvList.add(((TextView) findViewById(R.id.top_nav_middle_tv)));
		 
		 tvList.add(((TextView) findViewById(R.id.top_nav_right_tv)));
		rbList.add((RadioButton)findViewById(R.id.top_nav_left_line));
		rbList.add((RadioButton)findViewById(R.id.top_nav_middle_line));
		rbList.add((RadioButton)findViewById(R.id.top_nav_right_line));
		ArrayList<Fragment> list = new ArrayList<Fragment>();
		list.add(new NearbyTeamFragment());
		list.add(new NearbyBallFriendFragment());
		list.add(new NearbyBallParkFragment());
		NearbyFragmentAdapter adapter = new NearbyFragmentAdapter(
				getSupportFragmentManager(), list);
		mvp.setAdapter(adapter);

	}

	private void setListener() {
		mvp.setOnPageChangeListener(this);

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		 
		 changeNavText(arg0);
		
		
		

		rbList.get(arg0).setChecked(true);
	}

	private void changeNavText(int index) {
		// 改变导航字体
		for (int i = 0, len = tvList.size(); i < len; i++) {
			TextView tv = tvList.get(i);
			// 
			tv.setTextColor(Color.rgb(146,148,151));
			if (i == index) {// 232,129,59
				tv.setTextColor(Color.rgb( 232,129,59));
			}
			

		}
		 
		
	}
}
