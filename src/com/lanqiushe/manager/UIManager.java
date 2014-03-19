package com.lanqiushe.manager;

import java.util.Map;

import com.lanqiushe.R;

 

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class UIManager {
	/**
	 * �������ʱ�����ʾ�Ի���
	 * @param context
	 * @param loadingTextRes
	 * @return
	 */
	public static Dialog getLoadingDialog(Context context, int loadingTextRes) {

		final Dialog dialog = new Dialog(context, R.style.netLoadingDialog);
		dialog.setCancelable(false);
		dialog.setContentView(R.layout.custom_progress_dialog);
		// Window window = dialog.getWindow();
		// WindowManager.LayoutParams lp = window.getAttributes();
		// DisplayMetrics dm = new DisplayMetrics();
		// ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
		// int screenW = dm.widthPixels;
		// lp.width = (int) (0.6 * screenW);

		TextView titleTxtv = (TextView) dialog.findViewById(R.id.dialog_tv);
		titleTxtv.setText(loadingTextRes);
		return dialog;
	}

	
	
	
	
	
	
	
	/**
	 * û�������ʱ����ʾ�Ի���
	 */
	public static Dialog getNoNetDialog(Context context){
		final Dialog dialog = new Dialog(context, R.style.MyDialog);
		dialog.setContentView(R.layout.dialog_no_net);
		
		
		
		return dialog;
	}
	

	/**
	 * �����л�
	 * 
	 * @param from
	 * @param to
	 */
	public static void switcher(Context from, Class<?> to) {
		switcher(from, to, null);
	}

	public static void switcher(Context from, Class<?> to,
			Map<String, Object> extras) {
		Intent i = new Intent(from, to);
		if (extras != null) {
			for (String name : extras.keySet()) {
				Object obj = extras.get(name);
				if (obj instanceof String) {
					i.putExtra(name, (String) obj);
				}
				if (obj instanceof Integer) {
					i.putExtra(name, (Integer) obj);
				}
				if (obj instanceof String[]) {
					i.putExtra(name, (String[]) obj);
				}

			}
		}
		from.startActivity(i);
	}
}
