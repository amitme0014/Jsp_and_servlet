package com.igate.ch4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HeaderSnoop")
public class HeaderSnoop extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();

    out.println("Request Headers:");
    out.println();
    Enumeration headernames = req.getHeaderNames();
    while (headernames.hasMoreElements()) {
     	 String name = (String) headernames.nextElement();
     	 String value = req.getHeader(name);
      	 if (value != null) {
        	out.println(name + ": " + value);
      	}
    }
  }
}
