package com.lanqiushe.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.eims.pullrefresh.ui.MyListView;
import com.eims.pullrefresh.ui.PullToRefreshBase;
import com.eims.pullrefresh.ui.PullToRefreshBase.OnRefreshListener;
import com.eims.pullrefresh.ui.PullToRefreshListView;
import com.lanqiushe.R;
import com.lanqiushe.adapter.NotifyMessageAdapter;
import com.lanqiushe.entity.NotifyMessage;
import com.lanqiushe.manager.DataManager;
 

public class NotifyMessageActivity extends BaseActivity {
	NotifyMessageAdapter adapter;
	List<NotifyMessage> mData;
	private PullToRefreshListView mPullListView;
	private ListView mListView;
	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");
	private boolean mIsStart = true;
	private int mCurIndex = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_notify);
		initView();
	}

	void initView() {
		mData = DataManager.getNotifyMessages();
		adapter = new NotifyMessageAdapter(this, mData);
		initNotifyMessage();
	}

	// ��ʼ��֪ͨ��Ϣ
	private void initNotifyMessage() {
		mData = DataManager.getNotifyMessages();
		mPullListView = (PullToRefreshListView) findViewById(R.id.notify_messafe_listview);
		mPullListView.setPullLoadEnabled(true);
		mPullListView.setScrollLoadEnabled(true);
		mCurIndex = mData.size();
		mListView = mPullListView.getRefreshableView();
		adapter = new NotifyMessageAdapter(this, mData);
		mListView.setAdapter(adapter);
		// ��ӵ��
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

			}
		});
		mPullListView.setOnRefreshListener(new OnRefreshListener<MyListView>() {
			@Override
			public void onPullDownToRefresh(
					PullToRefreshBase<MyListView> refreshView) {
				mIsStart = true;
				new GetDataTask().execute();
			}

			@Override
			public void onPullUpToRefresh(
					PullToRefreshBase<MyListView> refreshView) {
				mIsStart = false;
				new GetDataTask().execute();
			}
		});
		setLastUpdateTime();
		mPullListView.doPullRefreshing(true, 500);
	}

	// ˢ��֪ͨ��Ϣ���߳�
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
				// TODO�����µ�����

			} else {
				int start = mCurIndex;
				int end = mCurIndex + mData.size();
				if (end >= mData.size()) {
					end = mData.size();
					hasMoreData = false;
				}

				for (int i = start; i < end; ++i) {
					// TODO �������е�����
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
