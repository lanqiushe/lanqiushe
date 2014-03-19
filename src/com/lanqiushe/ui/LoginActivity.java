package com.lanqiushe.ui;

import com.lanqiushe.R;
import com.lanqiushe.manager.ConstantManager;
import com.lanqiushe.manager.PreferenceManager;
import com.lanqiushe.manager.StringManager;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.manager.ToastManager;
import com.lanqiushe.manager.UIManager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends BaseActivity implements OnClickListener {
	private TextView mChangeUserTV, mUserNameTV, mNewUser, mForgetPwd;
	private ImageView mHeadIV;
	private EditText mCellPhoneET, mPwdET;
	private Button mLoginBT;
    private RelativeLayout mTitleRootRL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_login);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void findViews() {
		mTitleRootRL = (RelativeLayout) findViewById(R.id.title_root_rl);
		mChangeUserTV = (TextView) findViewById(R.id.login_change_user_tv);
		mUserNameTV = (TextView) findViewById(R.id.login_username_tv);
		mHeadIV = (ImageView) findViewById(R.id.login_head_iv);
		mCellPhoneET = (EditText) findViewById(R.id.login_cellphone_et);
		mPwdET = (EditText) findViewById(R.id.login_pwd_et);
		mLoginBT = (Button) findViewById(R.id.login_login_bt);
		mNewUser = (TextView) findViewById(R.id.login_newuser_tv);
		mForgetPwd = (TextView) findViewById(R.id.login_forget_pwd_tv);
		super.findViews();
	}

	@Override
	protected void init() {
		// 判断是否登录过,登录过才
		String spUserName  =PreferenceManager.getString(this,
				ConstantManager.SP_USER_NAME);
		if (StringManager.isEmpty(spUserName)) {
			// 为empty
			mCellPhoneET.setVisibility(View.VISIBLE);
			TitleManager.showTitle(this, new int[] { TitleManager.BACK_ARROW,
					TitleManager.OK }, -1);
		} else {
			mChangeUserTV.setVisibility(View.VISIBLE);
			mHeadIV.setVisibility(View.VISIBLE);
			mUserNameTV.setVisibility(View.VISIBLE);
			mTitleRootRL.setVisibility(View.GONE);
		}
		super.init();
	}

	@Override
	protected void setListener() {
		mChangeUserTV.setOnClickListener(this);
		mHeadIV.setOnClickListener(this);
		mUserNameTV.setOnClickListener(this);
		mLoginBT.setOnClickListener(this);
		mNewUser.setOnClickListener(this);
		mForgetPwd.setOnClickListener(this);

		super.setListener();
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_login_bt:
		case R.id.title_ok_iv: {
			// 用户主界面
			String cellphone = StringManager.getStringByET(mCellPhoneET);
			String pwd = StringManager.getStringByET(mPwdET);
            if(mCellPhoneET.isShown()){//有用户登录记录的情况下是不用展示电话号码的框框的  .只有电话号码框展示的时候才做号码验证
            	if(StringManager.isEmpty(cellphone)){
                	ToastManager.show(this, R.string.sp_cellphone_empty);
                	return;
                }
                if(StringManager.isBadCellphone(cellphone)){
                	ToastManager.show(this, R.string.sp_cellphone_bad);
                	return;
                }
            }
			 
		
            if(StringManager.isEmpty(pwd)){
            	ToastManager.show(this, R.string.sp_pwd_empty);
            	return;
            }
            if(StringManager.isBadPwd(pwd)){
            	ToastManager.show(this, R.string.sp_pwd_bad);
            	return;
            }
            //前面验证通过。用户登录的数据就该保存
			PreferenceManager.setString(this, ConstantManager.SP_USER_NAME,
					cellphone);
			UIManager.switcher(this, MainActivity.class);
			finish();
			break;
		}
		case R.id.login_change_user_tv:{
			TitleManager.showTitle(this, new int[] { TitleManager.BACK_ARROW,
					TitleManager.OK }, -1);
			mTitleRootRL.setVisibility(View.VISIBLE);
			mChangeUserTV.setVisibility(View.GONE);
			mHeadIV.setVisibility(View.GONE);
			mUserNameTV.setVisibility(View.GONE);
			mCellPhoneET.setVisibility(View.VISIBLE);
			break;
		}
		case R.id.login_head_iv:{
			break;
		}
		case R.id.login_username_tv:{
			break;
		}
		case R.id.login_lock_rl: {
			//mPwdET.setinpu
			break;
		}

		case R.id.login_newuser_tv: {
			UIManager.switcher(this, RInputCellphoneActivity.class);
			break;
		}
		case R.id.login_forget_pwd_tv: {
			UIManager.switcher(this, RInputCellphoneActivity.class);
			break;
		}

		}
	}
}
