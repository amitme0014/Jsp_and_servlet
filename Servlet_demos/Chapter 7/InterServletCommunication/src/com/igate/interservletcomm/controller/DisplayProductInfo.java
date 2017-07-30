package com.igate.interservletcomm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igate.interservletcomm.bean.Product;

/**
 * Servlet implementation class DisplayProductInfo
 */
@WebServlet("/DisplayProductInfo")
public class DisplayProductInfo extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream os = response.getOutputStream();
		// Fetch data from Request object...
		Product product = (Product) request.getAttribute("product");
		String shopName = (String) request.getAttribute("shopName");
		String mail = (String)request.getAttribute("mail");
		
		os.println("Product Data entered...<BR>");
		os.println("Product Name        "  + product.getProdName() + "   Price    " + product.getProdPrice() + "Quantity     " + product.getProdQty() + "<BR>");
		os.println("Shop Name     " + shopName + "<BR>");
		os.println("Mail       " + mail);
	}

}
