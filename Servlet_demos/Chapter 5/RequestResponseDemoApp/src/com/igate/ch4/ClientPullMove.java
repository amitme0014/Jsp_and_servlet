package com.igate.ch4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClientPullMove")
public class ClientPullMove extends HttpServlet {

  String NEW_HOST = "http://localhost:9090/RequestResponseDemoApp/ClientPull";
  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    res.setHeader("Refresh", "5; URL=" + NEW_HOST);
    out.println("The requested URI has been moved to a different host.<BR>");
    out.println("Its new location is " + NEW_HOST + "<BR>");
    out.println("Your browser will take you there in 5 seconds.");
  }
}

