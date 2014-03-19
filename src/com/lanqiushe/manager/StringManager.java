package com.lanqiushe.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import android.content.Context;
import android.widget.EditText;

/**
 * �ַ����������߰�
 */
public class StringManager {

	/**
	 * �жϸ����ַ����Ƿ�հ״��� �հ״���ָ�ɿո�\s���Ʊ��\t ���س���\n�����з�\r ��ɵ��ַ���
	 * �������ַ���Ϊnull����ַ���������true
	 * 
	 * @param input
	 * @return boolean
	 */
	public static boolean isEmpty(String input) {
		return input == null || "".equals(input);
	}
	/**
	 * �ж��Ƿ��ֻ�����
	 * @param cellphone
	 * @return
	 */
    public static boolean isBadCellphone(String cellphone){
    	return cellphone.length()!=11;
    }
    /**
     * �ж�����ĸ�ʽ
     * @param pwd
     * @return
     */
    public static boolean isBadPwd(String pwd){
    	return false;//����û��������λ������
    }
    
	/**
	 * ��EditText�����ı���ȡ��
	 */
	public static String getStringByET(EditText et) {
		return et.getText().toString().trim();
	}
	
	/**
	 * ���غ�sp  �໥ת��
	 */
	public static int spToPix(Context context,int sp){
		final float scale = context. getResources ( ). getDisplayMetrics ( ). density ; 
		return ( int ) (sp * scale + 0.5f ) ; 
	}
}
