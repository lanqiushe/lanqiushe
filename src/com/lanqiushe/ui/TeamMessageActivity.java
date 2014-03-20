package com.lanqiushe.ui;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.lanqiushe.R;
import com.lanqiushe.adapter.TeamMemberMessageAdpter;
import com.lanqiushe.entity.ChatMessage;
import com.lanqiushe.entity.TeamMemberMessage;
import com.lanqiushe.manager.DataManager;
import com.lanqiushe.manager.ToastManager;

public class TeamMessageActivity extends BaseActivity implements OnItemClickListener{
	private ListView contacts_ballfriend_listview;
	TeamMemberMessageAdpter adapter;
	List<TeamMemberMessage> mData;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_my_team); 
		initView();
	}
	void initView(){
		mData = DataManager.getTeamMemberMessages();
		contacts_ballfriend_listview = (ListView)findViewById(R.id.contacts_ballfriend);
		adapter = new TeamMemberMessageAdpter(this, mData);
		contacts_ballfriend_listview.setAdapter(adapter);
		contacts_ballfriend_listview.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ListView listView = (ListView) parent;
		@SuppressWarnings("unchecked")
		TeamMemberMessage mTeamMemberMessage = (TeamMemberMessage) listView
				.getItemAtPosition(position);
		ToastManager.show(TeamMessageActivity.this, mTeamMemberMessage.getTeam_member_info());
	}
}
