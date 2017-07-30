package com.igate.interservletcomm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.interservletcomm.bean.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String prodName = request.getParameter("prodName");
		float prodPrice = Float.parseFloat(request.getParameter("prodPrice"));
		int prodQty = Integer.parseInt(request.getParameter("prodQty"));

		// Pass the product object into Request object to another servlet via
		// forward method

		Product product = new Product();
		product.setProdName(prodName);
		product.setProdPrice(prodPrice);
		product.setProdQty(prodQty);

		request.setAttribute("product", product);
		// we could also set couple of other parameters.

		request.setAttribute("shopName", "Nova electronics");
		request.setAttribute("mail", "feedback@nova.com");

		// Obtain the request dispatcher object...via ServletContext object
		// Servlet Context can only take relative to the current context's root
		// As request is raised from POST method it will be forwarded to the
		// POST method of another servlet
		getServletContext().getRequestDispatcher("/DisplayProductInfo")
				.forward(request, response);
	}

}
