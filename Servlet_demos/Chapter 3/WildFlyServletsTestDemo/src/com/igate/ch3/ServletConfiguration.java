package com.igate.ch3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletConfiguration", urlPatterns = { "/ServletConfiguration" }, initParams = {
		@WebInitParam(name = "name", value = "My Servlet"),
		@WebInitParam(name = "mail", value = "info@test.com") })
public class ServletConfiguration extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Accessing inital parameter : name by using the API method -
		// getInitParameter("name")
		String value = config.getInitParameter("name");
		System.out.println("Value is:::" + value);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		// Access ServletConfig and ServletContext
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();

		// Multiple initial parameters could be accessed via API method:
		// getInitParameterNames();

		Enumeration enums = config.getInitParameterNames();
		while (enums.hasMoreElements()) {
			String param = (String) enums.nextElement();
			pw.println(param + "Value is::" + config.getInitParameter(param)
					+ "<br>");
		}
		
		// Access context param set in the listener
		String companyName = context.getInitParameter("company");
		pw.println("Company Name is :::" + companyName);
	}

}
