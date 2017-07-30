package com.igate.interservletcomm.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/itemservlet")
public class ItemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String item = req.getParameter("item");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print(" From Item Servlet: Received : " + item + "<br>");
	}
}
