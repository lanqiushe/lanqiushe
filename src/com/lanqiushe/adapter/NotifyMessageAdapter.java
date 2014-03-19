package com.lanqiushe.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanqiushe.R;
import com.lanqiushe.entity.NotifyMessage;

public class NotifyMessageAdapter extends BaseAdapter {
	Context mContext;
	List<NotifyMessage> mData;
	private LayoutInflater inflater;

	public NotifyMessageAdapter(Context context, List<NotifyMessage> data) {
		inflater = LayoutInflater.from(context);
		this.mContext = context;
		this.mData = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			/* 绑定相应的视图 */
			convertView = inflater.inflate(R.layout.list_notify_item, null);
			holder.img_head = (ImageView) convertView
					.findViewById(R.id.img_head);
			holder.tv_notify_title = (TextView) convertView
					.findViewById(R.id.tv_notify_title);
			holder.tv_notify_info = (TextView) convertView
					.findViewById(R.id.tv_notify_info);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_notify_title.setText(mData.get(position).getNotify_title());
		holder.tv_notify_info.setText(mData.get(position).getNotify_info());
		return convertView;
	}

	private static class ViewHolder {
		ImageView img_head;
		TextView tv_notify_title, tv_notify_info;
	}

}
