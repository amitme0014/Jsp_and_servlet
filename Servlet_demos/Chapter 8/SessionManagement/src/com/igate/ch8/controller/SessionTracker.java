package com.igate.ch8.controller;

import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionTracker")
public class SessionTracker extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		// Get the current session object, create one if necessary
		HttpSession session = req.getSession(true);

		// Increment the hit count for this page.  The value is saved
		// in this client's session under the name "tracker.count".

		Integer count = (Integer) session.getAttribute("tracker.count");
		if (count == null)
			count = new Integer(1);
		else
			count = new Integer(count.intValue() + 1);

		session.setAttribute("tracker.count", count);
		out.println("<HTML><HEAD><TITLE>SessionTracker</TITLE></HEAD>");
		out.println("<BODY><H1>Session Tracking Demo</H1>");

		// Display the hit count for this page
		out.println("You've visited this page " + count
				+ ((count.intValue() == 1) ? " time." : " times."));

		out.println("<P>");

		out.println("<H2>Here is your session data:</H2>");

		Enumeration names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			out.println(name + ": " + session.getAttribute(name));
		}
		out.println("</BODY></HTML>");
	}
}
