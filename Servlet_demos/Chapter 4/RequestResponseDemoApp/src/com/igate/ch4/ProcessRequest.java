package com.igate.ch4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/Process"})
public class ProcessRequest extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		// Returning values of named parameters. This data is sent from client
		// to server, thus it would be reflected using the request object
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String qualification = request.getParameter("qualification");

		pw.println("Username>>" + username + "Password>>" + password
				+ "Gender>>" + gender + "Qualification>>" + qualification);
		// If dealing with multiple values like in check boxes or drop downs or textboxes
		// having same name, different API methods needs to be used to retrieve
		// the values
		String[] proofs = request.getParameterValues("proofs");
		// use for each loop to print out values selected in check box
		pw.println("Values checked for proofs submitted are::<BR>");
		if(proofs != null){
			for (String proof : proofs) {
				pw.println(proof + "<br>");
			}
		}
		

		// Multiple hobbies could be entered , we have given 3 text boxes with same name. 
		String[] hobbies = request.getParameterValues(("hobbies"));
		pw.println("Values entered for hobbies are::<BR>");
		if(hobbies != null){
			for (String hobby : hobbies) {
				pw.println(hobby + "<br>");
			}
		}
		
		
		// Query string is the parameters appended in the URL. Query parameters
		// would be exposed if we are using the GET Http method. If we use POST
		// Http method then query parameters would be appended in the body of
		// the request.
		String queryString = request.getQueryString();

		pw.println("Query String:::" + queryString + "<br>");

		// RequestURI is the URL from the context root. It can be used to
		// identify different types of requests.
		String requestURI = request.getRequestURI();
		pw.println("Request URI:::" + requestURI + "<br>");

		// ParameterNames returns a list of HTML parameter names
		Enumeration<String> inputParameters = request.getParameterNames();
		while (inputParameters.hasMoreElements()) {
			String param = inputParameters.nextElement();
			pw.println(param);
		}
		
		String info = request.getPathInfo();
		pw.println("Info is >>>" + info);
	}

}
