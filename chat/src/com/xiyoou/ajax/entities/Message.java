package com.xiyoou.ajax.entities;

import java.util.Date;

public class Message {

	private Integer id;
	private String content;
	private Date time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Message(Integer id, String content, Date time) {
		super();
		this.id = id;
		this.content = content;
		this.time = time;
	}
	public Message() {
		super();
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", time=" + time
				+ "]";
	}
	
	
}
