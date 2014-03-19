package com.lanqiushe.entity;

public class ChatMessage {
	private String chat_user_head;
	private String chat_user_name;
	private String chat_message_info;
	private String chat_message_time;

	public ChatMessage() {

	}

	public ChatMessage(String chat_user_head, String chat_user_name,
			String chat_message_info, String chat_message_time) {
		super();
		this.chat_user_head = chat_user_head;
		this.chat_user_name = chat_user_name;
		this.chat_message_info = chat_message_info;
		this.chat_message_time = chat_message_time;
	}

	public String getChat_user_head() {
		return chat_user_head;
	}

	public void setChat_user_head(String chat_user_head) {
		this.chat_user_head = chat_user_head;
	}

	public String getChat_user_name() {
		return chat_user_name;
	}

	public void setChat_user_name(String chat_user_name) {
		this.chat_user_name = chat_user_name;
	}

	public String getChat_message_info() {
		return chat_message_info;
	}

	public void setChat_message_info(String chat_message_info) {
		this.chat_message_info = chat_message_info;
	}

	public String getChat_message_time() {
		return chat_message_time;
	}

	public void setChat_message_time(String chat_message_time) {
		this.chat_message_time = chat_message_time;
	}

}
