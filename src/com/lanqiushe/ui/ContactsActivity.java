package com.lanqiushe.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanqiushe.R;
 
import com.lanqiushe.adapter.NotifyMessageAdapter;
import com.lanqiushe.entity.NotifyMessage;
import com.lanqiushe.manager.TitleManager;

@SuppressWarnings("deprecation")
public class ContactsActivity extends BaseActivity implements OnClickListener,
		OnItemClickListener { 

	private ViewPager mPager;// 页卡内容
	private List<View> listViews; // Tab页面列表
	private ImageView cursor;// 动画图片
	private TextView tv_team, tv_notify, tv_chat;// 页卡头标
	private int offset = 0;// 动画图片偏移量
	private int currIndex = 0;// 当前页卡编号
	private int bmpW;// 动画图片宽度

	// 通知消息
	List<NotifyMessage> mData;
	NotifyMessageAdapter adapter;
	MyOnPageChangeListener mPageChangeListener;

	@SuppressWarnings("deprecation")
	LocalActivityManager manager = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		TitleManager.showTitle(this, new int[] {}, R.string.title_contacts);
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		InitImageView();
		InitTextView(); 
		initPagerViewer();
	}

	void InitImageView() {
		cursor = (ImageView) findViewById(R.id.cursor);
		cursor.setPadding(5, 0, 0, 5);
		bmpW = BitmapFactory.decodeResource(getResources(),
				R.drawable.line_down).getWidth();// 获取图片宽度
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;// 获取分辨率宽度
		offset = (screenW / 3 - bmpW) / 2;// 计算偏移量
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		cursor.setImageMatrix(matrix);// 设置动画初始位置
	}

	void InitTextView() {
		tv_notify = (TextView) findViewById(R.id.tv_notify);
		tv_chat = (TextView) findViewById(R.id.tv_chat);
		tv_team = (TextView) findViewById(R.id.tv_team);

		tv_notify.setOnClickListener(new MyOnClickListener(0));
		tv_chat.setOnClickListener(new MyOnClickListener(1));
		tv_team.setOnClickListener(new MyOnClickListener(2));
	}

	/**
	 * 初始化PageViewer
	 */
	private void initPagerViewer() {
		mPager = (ViewPager) findViewById(R.id.vPager);
		final ArrayList<View> list = new ArrayList<View>();
		Intent intent = new Intent(this, NotifyMessageActivity.class);
		list.add(getView("A", intent));
		Intent intent2 = new Intent(this, ChatMessageActivity.class);
		list.add(getView("B", intent2));
		Intent intent3 = new Intent(this, TeamMessageActivity.class);
		list.add(getView("C", intent3));

		mPager.setAdapter(new MyPagerAdapter(list));
		mPager.setCurrentItem(0);
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	/**
	 * 通过activity获取视图
	 * 
	 * @param id
	 * @param intent
	 * @return
	 */
	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}

	/**
	 * 头标点击监听
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);

		}
	};

	/**
	 * ViewPager适配器
	 */
	public class MyPagerAdapter extends PagerAdapter {
		public List<View> mListViews;

		public MyPagerAdapter(List<View> mListViews) {
			this.mListViews = mListViews;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(mListViews.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return mListViews.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(mListViews.get(arg1), 0);

			return mListViews.get(arg1);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == (arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
	}

	/**
	 * 页卡切换监听
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
		int two = one * 2;// 页卡1 -> 页卡3 偏移量

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (currIndex == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, 0, 0, 0);
				}
				break;
			case 1:
				if (currIndex == 0) {
					animation = new TranslateAnimation(offset, one, 0, 0);
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, one, 0, 0);
				}
				break;
			case 2:
				if (currIndex == 0) {
					animation = new TranslateAnimation(offset, two, 0, 0);
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, two, 0, 0);
				}
				break;
			}
			currIndex = arg0;
			animation.setFillAfter(true);// True:图片停在动画结束位置
			animation.setDuration(300);
			cursor.startAnimation(animation);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}
}
