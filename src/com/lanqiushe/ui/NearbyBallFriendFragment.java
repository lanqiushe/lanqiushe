 
package com.lanqiushe.ui;

import com.lanqiushe.R;
import com.lanqiushe.adapter.NearbyContentAdapter;
import com.lanqiushe.manager.LogManager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NearbyBallFriendFragment extends BaseFragment {
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    		LogManager.e(tag, "NearbyBallFriendFragment  ¿ªÊ¼");
    	return inflater.inflate(R.layout.layout_nearby_f_ballfriend, container, false);
    }
     @Override
 	public void onActivityCreated(Bundle savedInstanceState) {
    	 
    	 
     
    	 
 		super.onActivityCreated(savedInstanceState);
 	}

 	@Override
 	public void findViews() {
 		mlv = (ListView) fa.findViewById(R.id.nearby_ballfriend_lv);
 		super.findViews();
 	}

 	@Override
 	public void init() {
 		NearbyContentAdapter adapter = new NearbyContentAdapter(fa, null,
 				 NearbyContentAdapter.BALL_FRIEND);
 		mlv.setAdapter(adapter);
 		super.init();
 	}

 	@Override
 	public void onDestroy() {
 		LogManager.e(tag, "NearbyBallFriendFragment  Ïú»Ù");
 		super.onDestroy();
 	}
}
