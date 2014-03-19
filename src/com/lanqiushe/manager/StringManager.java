package com.lanqiushe.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import android.content.Context;
import android.widget.EditText;

/**
 * 字符串操作工具包
 */
public class StringManager {

	/**
	 * 判断给定字符串是否空白串。 空白串是指由空格\s、制表符\t 、回车符\n、换行符\r 组成的字符串
	 * 若输入字符串为null或空字符串，返回true
	 * 
	 * @param input
	 * @return boolean
	 */
	public static boolean isEmpty(String input) {
		return input == null || "".equals(input);
	}
	/**
	 * 判断是否手机号码
	 * @param cellphone
	 * @return
	 */
    public static boolean isBadCellphone(String cellphone){
    	return cellphone.length()!=11;
    }
    /**
     * 判断密码的格式
     * @param pwd
     * @return
     */
    public static boolean isBadPwd(String pwd){
    	return false;//密码没有做最少位数限制
    }
    
	/**
	 * 将EditText中中文本获取到
	 */
	public static String getStringByET(EditText et) {
		return et.getText().toString().trim();
	}
	
	/**
	 * 像素和sp  相互转换
	 */
	public static int spToPix(Context context,int sp){
		final float scale = context. getResources ( ). getDisplayMetrics ( ). density ; 
		return ( int ) (sp * scale + 0.5f ) ; 
	}
}
