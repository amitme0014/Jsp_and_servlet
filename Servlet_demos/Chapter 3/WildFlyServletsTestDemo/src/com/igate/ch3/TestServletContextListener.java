package com.igate.ch3;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sc) {
	}

	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("Context Listener invoked........");
		ServletContext context = sc.getServletContext();
		// Setting contextual parameters that would be common to all servlets
		context.setInitParameter("company", "IGATE GLOBAL SOLUTIONS");
	}

}
