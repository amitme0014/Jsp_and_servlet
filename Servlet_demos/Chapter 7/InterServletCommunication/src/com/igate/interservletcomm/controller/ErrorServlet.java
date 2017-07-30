package com.igate.interservletcomm.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/errorservlet")
public class ErrorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Exception ex = (Exception) req.getAttribute("exception");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<HTML><HEAD><TITLE> Exception </TITLE>" + "</HEAD><BODY> "
				+ "<h1>Error Servlet </h1>" + ex.toString() + "");
		out.print("</BODY></HTML>");
	}
}
