package com.igate.ch4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SiteSelector")
public class SiteSelector extends HttpServlet {

	Vector sites = new Vector();
	Random random = new Random();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sites.addElement("http://www.google.com");
		sites.addElement("http://docs.oracle.com/javaee/6/tutorial/doc/bnafd.html");
		sites.addElement("http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html");
		sites.addElement("http://en.wikipedia.org/wiki/Web_container");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");

		int siteIndex = Math.abs(random.nextInt()) % sites.size();
		String site = (String) sites.elementAt(siteIndex);
		// The first line sets the status code to indicate a redirection is to
		// take place, while the second line gives the new location.
		// res.setStatus(res.SC_MOVED_TEMPORARILY);
		// res.setHeader("Location", site);
		
		// These two lines can be simplified to one using the sendRedirect( )
		// convenience method
		res.sendRedirect(site);
	}
}
