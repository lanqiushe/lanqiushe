package com.lanqiushe.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.eims.pullrefresh.ui.PullToRefreshBase;
import com.eims.pullrefresh.ui.PullToRefreshBase.OnRefreshListener;
import com.eims.pullrefresh.ui.PullToRefreshListView;
import com.lanqiushe.R;
import com.lanqiushe.adapter.ChatMessageAdapter;
import com.lanqiushe.entity.ChatMessage;
import com.lanqiushe.manager.DataManager;
import com.lanqiushe.manager.UIManager;
import com.lanqiushe.view.BaseListView;
import com.lanqiushe.view.BasePopupWindow;

public class ChatMessageActivity extends BaseActivity {
	ChatMessageAdapter adapter;
	List<ChatMessage> mData;
	private PullToRefreshListView mPullListView;
	private ListView mListView;
	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");
	private boolean mIsStart = true;
	private int mCurIndex = 0;
	BasePopupWindow mPopWindow;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_chat);
		initView();
	}

	void initView() {
		mData = DataManager.getChatMessages();
		adapter = new ChatMessageAdapter(this, mData);
		initNotifyMessage();
	}

	// 初始化通知消息
	private void initNotifyMessage() {
		mData = DataManager.getChatMessages();
		mPullListView = (PullToRefreshListView) findViewById(R.id.chat_messafe_listview);
		mPullListView.setPullLoadEnabled(true);
		mPullListView.setScrollLoadEnabled(true);
		mCurIndex = mData.size();
		mListView = mPullListView.getRefreshableView();
		adapter = new ChatMessageAdapter(this, mData);
		mListView.setAdapter(adapter);
		// 添加点击
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ListView listView = (ListView) parent;
				@SuppressWarnings("unchecked")
				ChatMessage mChatMessage = (ChatMessage) listView
						.getItemAtPosition(position);
				UIManager
						.switcher(ChatMessageActivity.this, ChatActivity.class);
			}
		});
		mPullListView
				.setOnRefreshListener(new OnRefreshListener<BaseListView>() {
					@Override
					public void onPullDownToRefresh(
							PullToRefreshBase<BaseListView> refreshView) {
						mIsStart = true;
						new GetDataTask().execute();
					}

					@Override
					public void onPullUpToRefresh(
							PullToRefreshBase<BaseListView> refreshView) {
						mIsStart = false;
						new GetDataTask().execute();
					}
				});
		mListView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO 弹出分享浮动框
				mPopWindow = new BasePopupWindow(ChatMessageActivity.this,
						itemsOnClick);

				// 显示窗口
				mPopWindow.showAtLocation(ChatMessageActivity.this.findViewById(R.id.chat_messafe_listview),
						Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
				return false;
			}
		});
		setLastUpdateTime();
		mPullListView.doPullRefreshing(true, 500);
	}

	// 刷新通知消息的线程
	class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected String[] doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			boolean hasMoreData = true;
			if (mIsStart) {
				// TODO增加新的数据

			} else {
				int start = mCurIndex;
				int end = mCurIndex + mData.size();
				if (end >= mData.size()) {
					end = mData.size();
					hasMoreData = false;
				}

				for (int i = start; i < end; ++i) {
					// TODO 增加所有的数据
				}

				mCurIndex = end;
			}

			adapter.notifyDataSetChanged();
			mPullListView.onPullDownRefreshComplete();
			mPullListView.onPullUpRefreshComplete();
			mPullListView.setHasMoreData(hasMoreData);
			setLastUpdateTime();
			super.onPostExecute(result);
		}
	}

	// 为弹出窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {
		public void onClick(View v) {
			mPopWindow.dismiss();
			switch (v.getId()) {

			default:
				break;
			}
		}
	};

	private void setLastUpdateTime() {
		String text = formatDateTime(System.currentTimeMillis());
		mPullListView.setLastUpdatedLabel(text);
	}

	private String formatDateTime(long time) {
		if (0 == time) {
			return "";
		}

		return mDateFormat.format(new Date(time));
	}

}