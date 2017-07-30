package com.igate.ch4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletResponseCode")
public class ServletResponseCode extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		ServletContext context = getServletContext();
		PrintWriter pw = response.getWriter();
		if (context.getInitParameter("username").equals(name)
				&& context.getInitParameter("password").equals(pwd)) {
			pw.println("Authorized, you are welcome");
		} else {
			// Make use of HttpServletResponse interface to get status codes,
			// that represent HTTP specific response codes
			response.sendError(HttpServletResponse.SC_FORBIDDEN,
					"You are Forbidden, as credentials do not match");
		}
	}

}
