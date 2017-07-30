package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet can have multiple URL patterns. This demo will show that
 * MultipleURLServlet can be invoked by multiple URL patterns i.e either by
 * /MultipleURLServlet or /Multiple or /Many.
 */

@WebServlet(name = "MultipleURLServlet", urlPatterns = { "/MultipleURLServlet",
		"/Multiple", "/Many" })
public class MultipleURLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Byte stream can also be used to write output from servlets
		ServletOutputStream os = response.getOutputStream();
		os.println("Welcome to Servlets<BR>");
		os.println("Where I could be invoked with multiple URL patterns<BR>");
		os.println("Test me out with same<BR>");
	}

}
