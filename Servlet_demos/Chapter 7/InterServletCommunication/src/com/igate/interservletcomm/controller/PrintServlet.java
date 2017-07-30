package com.igate.interservletcomm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintServlet
 */
@WebServlet("/print")
public class PrintServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		ServletContext sc = getServletContext();
		out.println("In Include servlet... <br>");
		out.println(" context variables (application) " + "<br>");
		out.println("company " + " : " + sc.getAttribute("company") + "<br>");

		out.println(" Request attributes " + "<br>");
		out.println("name" + " : " + req.getAttribute("name"));

	}
}
