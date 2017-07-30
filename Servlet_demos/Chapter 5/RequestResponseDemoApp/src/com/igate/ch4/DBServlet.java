package com.igate.ch4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	Connection con;
	String url = "jdbc:oracle:thin:@localhost:1522:xe";

	public void init() throws ServletException {
		try {
			// URL Pattern, username, password can be obtained from Servlet init parameters also
			  Class.forName("oracle.jdbc.driver.OracleDriver"); 
			 con = DriverManager.getConnection(url,"system","yukti");
		} catch (Exception e) {
			System.out.println("Database connect failed (init)");
			System.out.println(e.toString());
			return;
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp824177");
			while(rs.next()){
				pw.println(rs.getInt("ID") + "<br>");
				pw.println(rs.getString("NAME") + "<br>");
				pw.println(rs.getFloat("SALARY") + "<br>");
			}
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
