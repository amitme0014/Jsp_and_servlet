package com.igate.interservletcomm.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContextSnoop")
public class ContextSnoop extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		// out.println(" List of context variables (application) ");
		ServletContext sc = getServletContext();
		// out.println("setting company  attribute  for value Patni ");
		sc.setAttribute("company", "IGATE");
		// out.println("setting request attribute name for anil  ");
		req.setAttribute("name", "Emma Clifton");

		System.out.println("forwarding print servlet");
		sc.getRequestDispatcher("/print").forward(req, res);
	}

}
