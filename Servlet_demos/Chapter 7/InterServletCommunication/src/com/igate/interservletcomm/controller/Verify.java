package com.igate.interservletcomm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify")
public class Verify extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("passwd");
		if(username.equals("IGATE") && pwd.equals("IGATE123")){
			getServletContext().getRequestDispatcher("/success.html").forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}
	}

}
