package com.igate.ch8.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Store")
public class Store extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter pw = response.getWriter();
		ArrayList<String> shopCart = (ArrayList<String>) session
				.getAttribute("Shopcart");
		if (shopCart != null && !shopCart.isEmpty()) {
			pw.println("Shopping cart contains following items!!!<br>");
			// Display cuurent items already purchased
			for (String item : shopCart) {
				pw.println(item + "<br>");
			}
		} else {
			pw.println("Shopping cart is Empty!!!<br>");
		}
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<form action='Shopping'>"); // method is get
		pw.println("<input type='text' name='item'/><br>");
		pw.println("<input type='submit' name='operation' value='AddItem'/>");
		pw.println("<input type='submit' name='operation' value='RemoveItem'/>");
		pw.println("<input type='submit' name='operation' value='EmptyCart'/>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
