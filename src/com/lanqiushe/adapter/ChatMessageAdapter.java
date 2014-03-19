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
import com.lanqiushe.entity.ChatMessage;

public class ChatMessageAdapter extends BaseAdapter {
	Context mContext;
	List<ChatMessage> mData;
	private LayoutInflater inflater;

	public ChatMessageAdapter(Context context, List<ChatMessage> data) {
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
			convertView = inflater.inflate(R.layout.list_chat_item, null);
			holder.img_head = (ImageView) convertView
					.findViewById(R.id.img_head);
			holder.tv_chat_user = (TextView) convertView
					.findViewById(R.id.tv_chat_user);
			holder.tv_chat_info = (TextView) convertView
					.findViewById(R.id.tv_chat_info);
			holder.tv_chat_time = (TextView) convertView
					.findViewById(R.id.tv_chat_time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_chat_user.setText(mData.get(position).getChat_user_name());
		holder.tv_chat_info.setText(mData.get(position).getChat_message_info());
		holder.tv_chat_time.setText(mData.get(position).getChat_message_time());
		return convertView;
	}

	private static class ViewHolder {
		ImageView img_head;
		TextView tv_chat_user, tv_chat_info, tv_chat_time;
	}

}