package com.xiyoou.ajax.dao.test;

import java.util.Date;

import org.junit.Test;

import com.xiyoou.ajax.dao.MessageDAO;
import com.xiyoou.ajax.entities.Message;

public class MessageDAOTest {

	private MessageDAO messageDAO = new MessageDAO();
	
	@Test
	public void testSaveMessage() {
		Message message = new Message(null, "ÄãºÃ", new Date());
		messageDAO.saveMessage(message);
	}

	@Test
	public void testGetMessages() {

		System.out.println(messageDAO.getMessages("1"));
		
	}

	@Test
	public void testHasNew() {

		System.out.println(messageDAO.hasNew("0"));
		
	}

}
