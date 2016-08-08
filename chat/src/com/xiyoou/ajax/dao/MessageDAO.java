package com.xiyoou.ajax.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xiyoou.ajax.entities.Message;
import com.xiyou.ajax.hibernate.HibernateUtils;

public class MessageDAO{
	
	
	public void saveMessage(Message message){
		Session session = HibernateUtils.getInit().getSession();
		Transaction transaction = session.beginTransaction();
		session.save(message);
		transaction.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> getMessages(String finalMessageId){
		Session session = HibernateUtils.getInit().getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Message m where m.id > :id  order by m.id";
		ArrayList<Message> list = (ArrayList<Message>)session.createQuery(hql).setString("id", finalMessageId).list();
		transaction.commit();
		return list;
	}
	
	public boolean hasNew(String finalMessageId){
		Session session = HibernateUtils.getInit().getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select count(*) from Message m where m.id > :id";
		long count = (Long)session.createQuery(hql).setString("id", finalMessageId).uniqueResult();
		transaction.commit();
		boolean a = count > 0;
		return a;
	}
	
	public Message newMessage(String content){
		return new Message(null, content, new Date());
	}
	
}
