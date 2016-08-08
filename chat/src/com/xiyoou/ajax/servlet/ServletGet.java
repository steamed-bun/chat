package com.xiyoou.ajax.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xiyoou.ajax.entities.Message;
import com.xiyoou.ajax.service.MessageService;

public class ServletGet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String finalMessageId = request.getParameter("finalMessageId");
		System.out.println("~"+finalMessageId);
		List<Message> list = messageService.getMessages(finalMessageId);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(json);
		
	}

}
