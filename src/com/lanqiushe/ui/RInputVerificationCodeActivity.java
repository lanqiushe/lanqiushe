package com.lanqiushe.ui;

import java.util.Timer;
import java.util.TimerTask;

import com.lanqiushe.R;
import com.lanqiushe.manager.StringManager;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.manager.ToastManager;
import com.lanqiushe.manager.UIManager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RInputVerificationCodeActivity extends BaseActivity implements
		OnClickListener {
	private EditText mVerificationCode;
	private Button mReGet;
	private Timer timer;
	private TimerTask timerTask;
	private static final int UPDATE_TIME = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_register_input_verification_code);
		TitleManager.showTitle(this, new int[] { TitleManager.BACK_ARROW,
				TitleManager.OK }, R.string.title_input_verification_code);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void init() {
		mVerificationCode = (EditText) findViewById(R.id.verification_code_tv);
		mReGet = (Button) findViewById(R.id.verification_code_time_tv);

		timer = new Timer();
		timerTask = getTimerTask();
		timer.scheduleAtFixedRate(timerTask, 1000, 1000);

		super.init();
	}

	@Override
	protected void setListener() {
		mReGet.setOnClickListener(this);
		super.setListener();
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_ok_iv: {
			UIManager.switcher(this, RInputPwdActivity.class);
			break;
		}

		case R.id.verification_code_time_tv: {
			mReGet.setEnabled(false);
			mReGet.setClickable(false);

			mReGet.setBackgroundResource(R.drawable.bt_bg_hollow_orange_pre);
			mReGet.setTextColor(Color.rgb(255, 255, 255));
			mReGet.setText(String.valueOf(5));

			timerTask = getTimerTask();

			timer.scheduleAtFixedRate(timerTask, 1000, 1000);

			break;
		}

		}
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case UPDATE_TIME:

				int number = Integer
						.valueOf(mReGet.getText().toString().trim());
				if (number == 1) {
					// œ‘ æ∆‰À˚
					mReGet.setBackgroundResource(R.drawable.bt_bg_hollow_orange_nor);

					mReGet.setTextColor(Color.rgb(234, 130, 50));
					mReGet.setText(R.string.again_get_verification_code);
					mReGet.setEnabled(true);
					mReGet.setClickable(true);

					timerTask.cancel();

					timerTask = null;
					return;
				}
				mReGet.setText(String.valueOf(--number));
				break;

			}
		};
	};

	private TimerTask getTimerTask() {
		return new TimerTask() {

			@Override
			public void run() {
				handler.sendEmptyMessage(UPDATE_TIME);
			}
		};
	}
}
