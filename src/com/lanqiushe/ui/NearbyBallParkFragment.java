 
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

public class NearbyBallParkFragment extends BaseFragment {
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    		LogManager.e(tag, "NearbyBallParkFragment  ¿ªÊ¼¡£¡£¡£¡£");
    	return inflater.inflate(R.layout.layout_nearby_f_ballpark, container, false);
    }
     @Override
  	public void onActivityCreated(Bundle savedInstanceState) {
  		super.onActivityCreated(savedInstanceState);
  	}

  	@Override
  	public void findViews() {
  		mlv = (ListView) fa.findViewById(R.id.nearby_park_lv);
  		super.findViews();
  	}

  	@Override
  	public void init() {
  		NearbyContentAdapter adapter = new NearbyContentAdapter(fa, null,
  				 NearbyContentAdapter.BALL_PARK);
  		mlv.setAdapter(adapter);
  		super.init();
  	}

  	@Override
  	public void onDestroy() {
  		LogManager.e(tag, "NearbyBallParkFragment  Ïú»Ù");
  		super.onDestroy();
  	}
}
