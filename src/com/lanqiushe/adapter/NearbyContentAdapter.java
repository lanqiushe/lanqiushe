package com.lanqiushe.adapter;

import java.util.ArrayList;

import com.lanqiushe.R;
import com.lanqiushe.entity.TeamMember;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NearbyContentAdapter extends BaseAdapter {

	public static final int TEAM = 0;
	public static final int BALL_FRIEND = 1;
	public static final int BALL_PARK = 2;

	private Context context;
	private int category;

	public NearbyContentAdapter(Context context, ArrayList<TeamMember> list,
			int category) {
		this.context = context;
		this.category = category;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
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
			convertView = View.inflate(context, R.layout.item_nearby, null);
			holder.head = (ImageView) convertView
					.findViewById(R.id.item_nearby_head_iv);
			holder.name = (TextView) convertView
					.findViewById(R.id.item_nearby_name_tv);
			holder.distance = (TextView) convertView
					.findViewById(R.id.item_nearby_distance_tv);

			switch (category) {
			case TEAM: {
				holder.number = (TextView) convertView
						.findViewById(R.id.item_nearby_number_tv);

				break;
			}
			case BALL_PARK:
			case BALL_FRIEND: {
				holder.money = (TextView) convertView
						.findViewById(R.id.item_nearby_money_tv);
				holder.location = (TextView) convertView
						.findViewById(R.id.item_nearby_location_tv);
				break;
			}
			 
			}

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText("拉拉队");
		holder.distance.setText("1km");

		switch (category) {
		case TEAM: {

			holder.number.setVisibility(View.VISIBLE);
			holder.number.setText("(2/3)");

			break;

		}

		case BALL_FRIEND: {
			holder.money.setVisibility(View.VISIBLE);
			holder.location.setVisibility(View.VISIBLE);
			holder.money.setText("拉拉队（2/3）");
			holder.location.setText("大黄蜂");
			break;
		}

		case BALL_PARK: {
			holder.location.setVisibility(View.INVISIBLE);
			holder.money.setVisibility(View.VISIBLE);
			holder.money.setText("2元/小时");
			break;
		}
		}

		return convertView;
	}

	private static class ViewHolder {
		ImageView head;
		TextView name, number, money, location, distance;
	}

}
