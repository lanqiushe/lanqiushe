package com.lanqiushe.ui;

import com.lanqiushe.R;
import com.lanqiushe.manager.StringManager;
import com.lanqiushe.manager.TitleManager;
import com.lanqiushe.manager.ToastManager;
import com.lanqiushe.manager.UIManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RInputCellphoneActivity extends BaseActivity {
	private EditText mCellphoneET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_register_input_cellphone);
		TitleManager.showTitle(this, new int[] { TitleManager.BACK_ARROW,
				TitleManager.OK }, R.string.title_input_cellphone);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void findViews() {
		mCellphoneET = (EditText) findViewById(R.id.register_cellphone_et);
		super.findViews();
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_ok_iv:
			String cellphone = StringManager.getStringByET(mCellphoneET);
			if (StringManager.isEmpty(cellphone)) {
				ToastManager.show(this, R.string.sp_cellphone_empty);
				return;
			}
			if (StringManager.isBadCellphone(cellphone)) {
				ToastManager.show(this, R.string.sp_cellphone_bad);
				return;
			}

			UIManager.switcher(this, RInputVerificationCodeActivity.class);
			break;

		}
	}
}
