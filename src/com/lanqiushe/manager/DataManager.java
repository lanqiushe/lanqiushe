package com.lanqiushe.manager;

import java.util.ArrayList;
import java.util.List;

import com.lanqiushe.entity.ChatMessage;
import com.lanqiushe.entity.NotifyMessage;
import com.lanqiushe.entity.TeamMemberMessage;

public class DataManager {
	public static List<NotifyMessage> getNotifyMessages() {
		List<NotifyMessage> mNotifyMessages = new ArrayList<NotifyMessage>();
		for (int i = 0; i < 10; i++) {
			NotifyMessage nMessage = new NotifyMessage("", 0, "约战通知",
					"三对三对牛，挑一下..");
			mNotifyMessages.add(nMessage);
		}
		return mNotifyMessages;
	}

	public static List<ChatMessage> getChatMessages() {
		List<ChatMessage> mChatMessages = new ArrayList<ChatMessage>();
		for (int i = 0; i < 10; i++) {
			ChatMessage cMessage = new ChatMessage("", "曾文韬", "约个时间，来一场...",
					"昨天");
			mChatMessages.add(cMessage);
		}
		return mChatMessages;
	}
	public static List<TeamMemberMessage> getTeamMemberMessages(){
		List<TeamMemberMessage> mTeamMemberMessages = new ArrayList<TeamMemberMessage>();
		for (int i = 0; i < 10; i++) {
			TeamMemberMessage cTeamMemberMessage = new TeamMemberMessage("", "曾文韬", "我是冠军",
					"控球后卫");
			mTeamMemberMessages.add(cTeamMemberMessage);
		}
		return mTeamMemberMessages; 
	}
}
