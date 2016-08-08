package com.xiyoou.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiyoou.ajax.service.MessageService;

public class SendServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private MessageService messageService = new MessageService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = request.getParameter("message");
		
		messageService.save(message);
		
	}

}
