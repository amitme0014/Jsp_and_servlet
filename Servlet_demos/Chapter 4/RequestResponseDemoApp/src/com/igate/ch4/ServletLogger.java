package com.igate.ch4;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class ServletLogger
 */
@WebServlet(name = "ServletLogger", urlPatterns = { "/ServletLogger" }, initParams = { @WebInitParam(name = "propFileName", value = "logger.properties") })
public class ServletLogger extends HttpServlet {

	private Logger log = null;

	public void init() {
		ServletConfig cg = getServletConfig();
		ServletContext ctx = getServletContext();
		String filename = cg.getInitParameter("propFileName");
		String path = ctx.getRealPath("/WEB-INF/" + filename);
		PropertyConfigurator.configure(path);
		log = Logger.getLogger(ServletLogger.class);
		log.info("ServletLogger started.");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// display a DEBUG level message
		log.debug("Sending a DEBUG message");
		// display an INFO level message
		log.info("Sending an INFO message");

		// better display something
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		out.println("<html><head><title>Servlet logging</title></head><body>");
		out.println("<h2>Hello from ServletLogger</h2>");
		out.println("Your logger name is: " + log.getName() + "<br>");
		out.println("</body></html>");
		out.close();
	}

}
