package com.jspider.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/netflix")
public class NetflixServlet extends HttpServlet {
	
private static final long serialVertsionUTD = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	resp.setContentType("text.html");
	PrintWriter writer = resp.getWriter();
	writer.println("<h1> WLCOME TO NETFLIX </h1>");
	}

}
