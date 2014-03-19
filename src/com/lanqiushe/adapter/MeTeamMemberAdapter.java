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

public class MeTeamMemberAdapter extends BaseAdapter {

	private Context context;
    private int resource;
    private ArrayList<TeamMember> list;
    public MeTeamMemberAdapter( Context context,ArrayList<TeamMember> list,int resource){
    	this.context = context;
    	this.resource = resource;
    	this.list = list;
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
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
		 if(convertView==null){
			 holder = new ViewHolder();
			 convertView = View.inflate(context, resource, null);
			 holder.head =(ImageView) convertView.findViewById(R.id.item_me_team_memeber_head_iv);
			 holder.name = (TextView) convertView.findViewById(R.id.item_me_team_memeber_name_tv);
			 holder.location =  (TextView) convertView.findViewById(R.id.item_me_team_memeber_location_tv);
			 holder.noTeamMember =  (TextView) convertView.findViewById(R.id.item_me_team_memeber_empty_tv);
			 convertView.setTag(holder);
			
			 
			 
			 
		 }else{
			 holder =  (ViewHolder) convertView.getTag();
		 }
		 TeamMember tm =  list.get(position);
		 if(tm ==null){
			 holder.noTeamMember.setVisibility(View.VISIBLE);
			 
		 }else{
			 holder.noTeamMember.setVisibility(View.GONE);
			 holder.head.setVisibility(View.VISIBLE);
			 holder.head.setImageResource(R.drawable.user_img);
			 holder.name.setVisibility(View.VISIBLE);
			 holder.name.setText(tm.teamMemberName);
			 holder.location.setVisibility(View.VISIBLE);
			 holder.location.setText(tm.teamMemberLocation);
		 }
		 
		 
		return convertView;
	}
	private static class ViewHolder{
		 ImageView head;
		 TextView name,location,noTeamMember;
		 
	}

}
