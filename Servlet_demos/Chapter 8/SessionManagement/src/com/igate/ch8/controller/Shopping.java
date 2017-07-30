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

/**
 * Servlet implementation class Shopping
 */

@WebServlet("/Shopping")
public class Shopping extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		ArrayList<String> cartList = null;
		ArrayList<String> shopCart = (ArrayList<String>) session
				.getAttribute("Shopcart");
		if (session != null && shopCart == null) {
			cartList = new ArrayList<String>();
			session.setAttribute("Shopcart", cartList);
		}
		if (operation != null && operation.equalsIgnoreCase("AddItem")) {
			String item = request.getParameter("item");
			cartList = (ArrayList<String>) session.getAttribute("Shopcart"); // fetch
																				// existing
																				// cart
																				// list
			cartList.add(item);
			pw.println(item + "is added to cart!!!!");
			session.setAttribute("Shopcart", cartList);
		}
		if (operation != null && operation.equalsIgnoreCase("RemoveItem")) {
			String item = request.getParameter("item");
			cartList = (ArrayList<String>) session.getAttribute("Shopcart"); // fetch
																				// existing
																				// cart
																				// list
			boolean ans = cartList.remove(item);
			if (ans == false) {
				pw.println("Cannot remove item as does not exists!!!<br>");
			} else {
				pw.println(item + "is removed to cart!!!!");
				session.setAttribute("Shopcart", cartList);
			}
		}
		if (operation != null && operation.equalsIgnoreCase("EmptyCart")) {
			cartList = (ArrayList<String>) session.getAttribute("Shopcart"); // fetch
			// existing
			// cart
			// list
			cartList.clear();
			session.setAttribute("Shopcart", cartList);
		}
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<a href='Store'>Go Back</a>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
