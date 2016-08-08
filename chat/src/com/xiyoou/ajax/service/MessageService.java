package com.xiyoou.ajax.service;

import java.util.List;

import com.xiyoou.ajax.dao.MessageDAO;
import com.xiyoou.ajax.entities.Message;

public class MessageService {

	private MessageDAO message = new MessageDAO();
	
	public Message newMessage(String content){
		return message.newMessage(content);
	}
	
	public void save(String content){
		message.saveMessage(newMessage(content));
	}
	
	public boolean ask(String finalMessageId){
		return message.hasNew(finalMessageId);
	}
	
	public List<Message> getMessages(String finalMessageId){
		return message.getMessages(finalMessageId);
	}
	
}
