package com.lanqiushe.manager;

import com.lanqiushe.R;
import com.lanqiushe.ui.MainActivity;
import com.lanqiushe.ui.MeSetActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TitleManager {
	/**
	 * app title����,����ĳ�������setTiele�����е�flag��flag�������title����Ҫ��ʾ��iv
	 */
	public static final int BACK_ARROW = 1;// ���أ���ͷ��
	public static final int TITLE_NAME = 2;// ����
	public static final int OK = 3;// ok
	public static final int SET = 4; // me �����set
	public static final int SET_BACK = 5; // ���ý���ķ���
	public static final int NEXT = 6;//��������е�main
	public static void showTitle(final Activity activity, int[] flags, int title) {
		if (title > 0) {
			TextView tv = (TextView) activity.findViewById(R.id.title_title_tv);

			tv.setText(title);
		}
		if (flags != null) {
			for (int flag : flags) {
				switch (flag) {
				case NEXT:{
					ImageView iv = (ImageView) activity.findViewById(R.id.title_next_iv);
					iv.setVisibility(View.VISIBLE);
                    iv.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
						     UIManager.switcher(activity, MainActivity.class);
						     activity.finish();
							
						}
					});
					 
					break;
				}
				
				
				
				case BACK_ARROW: {
					ImageView iv = (ImageView) activity
							.findViewById(R.id.title_back_iv);
					iv.setVisibility(View.VISIBLE);
					iv.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							activity.finish();
						}
					});
					break;
				}
				case OK: {
					activity.findViewById(R.id.title_ok_iv).setVisibility(
							View.VISIBLE);
					break;
				}
				case SET: {
					ImageView iv = (ImageView) activity
							.findViewById(R.id.title_set_iv);
					iv.setVisibility(View.VISIBLE);
					iv.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							UIManager.switcher(activity, MeSetActivity.class);

						}
					});
					break;

				}
				case SET_BACK: {
					LinearLayout ll = (LinearLayout) activity
							.findViewById(R.id.title_set_back_ll);
					ll.setVisibility(View.VISIBLE);
					ll.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							activity.finish();
						}
					});
					break;
				}

				}
			}
		}

	}

}
