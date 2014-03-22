package com.lanqiushe.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lanqiushe.R;
import com.lanqiushe.R.id;

public class BasePopupWindow extends PopupWindow {
	private TextView tv_title;
	private Button btn_zhiding, btn_del;
	private View mPopView;

	public BasePopupWindow(Activity context, OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mPopView = inflater.inflate(R.layout.layout_pop_del, null);
		tv_title = (TextView) mPopView.findViewById(id.tv_title);
		btn_zhiding = (Button) mPopView.findViewById(R.id.btn_zhiding);
		btn_del = (Button) mPopView.findViewById(R.id.btn_del);
		btn_zhiding.setOnClickListener(itemsOnClick);
		btn_del.setOnClickListener(itemsOnClick);
		// ����SelectPicPopupWindow��View
		this.setContentView(mPopView);
		// ����SelectPicPopupWindow��������Ŀ�
		this.setWidth(LayoutParams.MATCH_PARENT);
		// ����SelectPicPopupWindow��������ĸ�
		this.setHeight(LayoutParams.MATCH_PARENT);
		// ����SelectPicPopupWindow��������ɵ��
		this.setFocusable(true);
		// ����SelectPicPopupWindow�������嶯��Ч��
		// this.setAnimationStyle(R.style.AnimBottom);
		// ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		// ����SelectPicPopupWindow��������ı���
		this.setBackgroundDrawable(dw);
		// mMenuView���OnTouchListener�����жϻ�ȡ����λ�������ѡ������������ٵ�����
		mPopView.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {

				int height = mPopView.findViewById(R.id.ll_popwindow).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				return true;
			}
		});
	}

}
