package com.jspider.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/skills")
public class SkillServlet extends HttpServlet {

	private static final long serialVertsionUTD = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	resp.setContentType("text.html");
	PrintWriter writer = resp.getWriter();
	String FirstName = req.getParameter("firstname");
	String LastName = req.getParameter("lastname");
	String[] skills = req.getParameterValues("skills");
	writer.println("<h1> hello "+FirstName+" "+LastName+" "+"</h1>");
	writer.println("<h3> Your Skills includes : </h3>");
	for(String skill:skills) {
		writer.println("<h4>"+skill+"</h4>");
	}
	}
	
}
