package com.igate.ch4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoggerServlet", urlPatterns = { "/LoggerServlet" }, initParams = {
		@WebInitParam(name = "fileName", value = "sample.txt")})

public class LoggerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		// Code to read data from sample.txt file
		ServletConfig cg = getServletConfig();
		ServletContext ctx = getServletContext();
		String filename = cg.getInitParameter("fileName");
		String path = ctx.getRealPath("/WEB-INF/" + filename);
		try (FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);) {
			String contents;
			out.println("Printing names on browser as well as logging on console with Servlet Context");
			while ((contents = br.readLine()) != null) {
				out.println(contents + "<BR>");
				log("Servlet context logging the users>>>" + contents);
			}
		} catch (IOException e) {
			log("could not find file: " + e.getMessage());
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
