package com.igate.interservletcomm.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/PresentationServlet")
public class PresentationServlet extends HttpServlet {
	private static class ItemNotFoundException extends Exception {
		ItemNotFoundException() {
			super("Item not found");
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String item = req.getParameter("item");
		if (item == null) {
			res.setContentType("text/html");

			req.setAttribute("exception", new ItemNotFoundException());
			getServletContext().getRequestDispatcher("/errorservlet").forward(
					req, res);
		} else {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.print("<HTML><HEAD><TITLE>Item " + item + "</TITLE>"
					+ "</HEAD><BODY>From Presentation Servlet : Item set :- "
					+ item + ":<P>");
			getServletContext().getRequestDispatcher("/itemservlet").include(
					req, res);
			out.print("<br>After ItemServlet </BODY></HTML>");
		}
	}
}
