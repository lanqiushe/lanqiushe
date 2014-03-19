package com.lanqiushe.ui;

import com.lanqiushe.R;
import com.lanqiushe.manager.NetManager;
import com.lanqiushe.manager.ToastManager;
import com.lanqiushe.manager.UIManager;

import android.os.Bundle;
import android.view.View;

public class LoginAndRegisterActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_login_and_register);
		super.onCreate(savedInstanceState);
	}
    @Override
    protected void init() {
    	// TODO Auto-generated method stub
//    	if(!NetManager.isNetworkConnected(this)){
//    		//网络未连接
//    	}
    	
    	
    	
    	 
    	super.init();
    }
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_and_register_sina_ll: {
			ToastManager.show(this, "新浪第三方登录界面");
			break;
		}

		case R.id.login_and_register_qq_ll: {
			ToastManager.show(this, "-QQ 第三方登录界面---");
			break;
		}
		case R.id.login_and_register_login_bt: {
			 
			UIManager.switcher(this, LoginActivity.class);
			break;
		}
		case R.id.login_and_register_register_bt: {
			 
			UIManager.switcher(this, RInputCellphoneActivity.class);
			break;
		}

		}
	}
}
