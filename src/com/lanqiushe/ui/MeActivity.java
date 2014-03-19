package com.lanqiushe.ui;

import java.util.ArrayList;

import com.lanqiushe.R;
import com.lanqiushe.R.layout;
import com.lanqiushe.adapter.MeTeamMemberAdapter;
import com.lanqiushe.entity.TeamMember;
import com.lanqiushe.manager.ConstantManager;
import com.lanqiushe.manager.PreferenceManager;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.view.ScrollListView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MeActivity extends  BaseActivity {
	private View mNoTeam, mLackFullTeam;
	private ImageView mAdd;
	private Button mInviteBT,mExitBT;
	private static final int NO = 0;
	private static final int LACK = 1;
	private static final int FULL = 2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.layout_me);
	 TitleManager.showTitle(this, new int[] { TitleManager.SET },
	 	 	R.string.app_name);
		super.onCreate(savedInstanceState);
      
	}

	 
	protected void findViews() {
		//
		mNoTeam = findViewById(R.id.layout_me_no_team_in);
		mLackFullTeam = findViewById(R.id.layout_me_lack_or_full_team_in);
		mAdd = (ImageView) findViewById(R.id.me_add_iv);
		mInviteBT = (Button) findViewById(R.id.me_invite_bt);
		mExitBT = (Button) findViewById(R.id.me_exit_bt);
		//super.findViews();
	}

	 
	protected void init() {
		//传入不同的值，产生不同的状态
		showTeamInfo(FULL);

		//super.init();
	}

	private void showTeamInfo(int type) {
		switch (type) {
		case NO: {
			mNoTeam.setVisibility(View.VISIBLE);
			break;
		}

		case LACK: {
			mAdd.setVisibility(View.VISIBLE);
			mLackFullTeam.setVisibility(View.VISIBLE);
			mInviteBT.setVisibility(View.VISIBLE);
			
			ScrollListView mSlv = (ScrollListView) findViewById(R.id.common_scroll_listview);
			ArrayList<TeamMember> list = new ArrayList<TeamMember>();

			TeamMember t1 = new TeamMember();
			t1.teamMemberHead = "---";
			t1.teamMemberName = "李蛟";
			t1.teamMemberLocation = "前锋";

			list.add(null);

			list.add(null);
			list.add(null);

			BaseAdapter adapter = new MeTeamMemberAdapter(this, list);
			mSlv.setAdapter(adapter);

			break;
		}

		case FULL: {  
			mLackFullTeam.setVisibility(View.VISIBLE);
			mExitBT.setVisibility(View.VISIBLE);
			ScrollListView mSlv = (ScrollListView) findViewById(R.id.common_scroll_listview);
			ArrayList<TeamMember> list = new ArrayList<TeamMember>();

			TeamMember t1 = new TeamMember();
			t1.teamMemberHead = "---";
			t1.teamMemberName = "李蛟";
			t1.teamMemberLocation = "前锋";

			list.add(t1);
			list.add(t1);
			list.add(t1);

			BaseAdapter adapter = new MeTeamMemberAdapter(this, list
					);
			mSlv.setAdapter(adapter);

			
			
			break;
		}

		}

	}

}
