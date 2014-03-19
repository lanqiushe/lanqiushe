package com.lanqiushe.ui;

import com.lanqiushe.R;
import com.lanqiushe.adapter.MeSetAdapter;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.manager.ToastManager;
import com.lanqiushe.manager.UIManager;
import com.lanqiushe.view.ScrollListView;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;

public class MeSetActivity extends BaseActivity implements OnItemClickListener, OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_set);
		TitleManager.showTitle(this, new int[] { TitleManager.SET_BACK },
				R.string.title_set);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void init() {
		ScrollListView mScrollLV = (ScrollListView) findViewById(R.id.set_common_scroll_listview);
		String[] array = getResources().getStringArray(R.array.set_item);
		BaseAdapter adapter = new MeSetAdapter(this, array);
		mScrollLV.setAdapter(adapter);
		mScrollLV.setOnItemClickListener(this);
        findViewById(R.id.set_exit_login_bt).setOnClickListener(this);
		super.init();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0: {// 新浪微博
			ToastManager.show(this, "新浪微博");
			break;
		}
		case 1: {// 腾讯微博
			ToastManager.show(this, "腾讯微博");
			break;
		}

		case 2: {// 修改密码
			ToastManager.show(this, " 修改密码");
			break;
		}

		case 3: {// 关于我们
			ToastManager.show(this, "关于我们");
			break;
		}

		case 4: {// 联系客服
			ToastManager.show(this, "联系客服");
			break;
		}

		case 5: {// 好评
			ToastManager.show(this, "好评");
			break;
		}

		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 UIManager.switcher(this, LoginAndRegisterActivity.class);
		 finish();
	}
}
