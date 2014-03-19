 
package com.lanqiushe.ui;

import com.lanqiushe.R;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.manager.UIManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class RInputPwdActivity extends BaseActivity {
	private EditText mPwdET;
	private RelativeLayout mLockRL;
	private ImageView mLockIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	setContentView(R.layout.layout_register_input_pwd);
    	TitleManager.showTitle(this, new int[]{TitleManager.BACK_ARROW,TitleManager.OK}, R.string.title_input_pwd);
    	super.onCreate(savedInstanceState);
    }
    @Override
    protected void findViews() {
    	// TODO Auto-generated method stub
    	mPwdET  = (EditText) findViewById(R.id.register_input_pwd_et);
    	mLockRL = (RelativeLayout) findViewById(R.id.register_input_pwd_lock_rl);
    	mLockIV  = (ImageView) findViewById(R.id.register_input_pwd_lock_iv);
    	super.findViews();
    }
    public void onClick(View v){
    	switch (v.getId()) {
		case R.id.title_ok_iv:
			
			
			
			UIManager.switcher(this, RPerfectDataActivity.class);
			break;

	 
		}
    }
}
