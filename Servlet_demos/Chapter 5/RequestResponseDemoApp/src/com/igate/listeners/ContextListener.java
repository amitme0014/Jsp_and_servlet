package com.igate.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sc)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sc)  { 
    	ServletContext context= sc.getServletContext();
    	context.setInitParameter("username", "admin");
    	context.setInitParameter("password", "igate123");
    }
	
}
