package com.igate.ch3;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServerSnoop")
public class ServerSnoop extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();

		out.println("req.getServerName(): " + req.getServerName());
		out.println("req.getServerPort(): " + req.getServerPort());
		out.println("getServletContext().getServerInfo(): "
				+ getServletContext().getServerInfo());
		out.println("getServerInfo() name: "
				+ getServerInfoName(getServletContext().getServerInfo()));
		out.println("getServletContext().getAttribute(\"attribute\"): "
				+ getServletContext().getAttribute("attribute"));
	}

	private String getServerInfoName(String serverInfo) {
		int slash = serverInfo.indexOf('/');
		if (slash == -1)
			return serverInfo;
		else
			return serverInfo.substring(0, slash);
	}

}
