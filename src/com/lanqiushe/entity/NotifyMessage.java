package com.lanqiushe.entity;

public class NotifyMessage {
	private String notify_head;
	// 通知类型
	private int notify_type;
	private String notify_title;
	private String notify_info;
	
	public NotifyMessage() { 
	}
	
	public NotifyMessage(String notify_head, int notify_type,
			String notify_title, String notify_info) { 
		this.notify_head = notify_head;
		this.notify_type = notify_type;
		this.notify_title = notify_title;
		this.notify_info = notify_info;
	}

	public String getNotify_head() {
		return notify_head;
	}

	public void setNotify_head(String notify_head) {
		this.notify_head = notify_head;
	}

	public int getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(int notify_type) {
		this.notify_type = notify_type;
	}

	public String getNotify_title() {
		return notify_title;
	}

	public void setNotify_title(String notify_title) {
		this.notify_title = notify_title;
	}

	public String getNotify_info() {
		return notify_info;
	}

	public void setNotify_info(String notify_info) {
		this.notify_info = notify_info;
	}

}
