package com.igate.ch4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.zip.*;

/** Example showing benefits of gzipping pages to browsers
 *  that can handle gzip.
 */

public class EncodedPage extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String encode = req.getHeader("Accept-Encoding");
		PrintWriter out;
		String title;
		if ((encode != null) && (encode.indexOf("gzip") != -1)){
			title = "Page Encoded with GZip";
			OutputStream out1 = resp.getOutputStream();
			out = new PrintWriter(new GZIPOutputStream(out1), false);
			resp.setHeader("Content-Encoding", "gzip");
		} else {
			title = "Unencoded Page";
			out = resp.getWriter();
		}
		out.println("<HTML><HEAD><TITLE>" + title + "</TITLE>"
				+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=CENTER>" + title
				+ "</H1>\n");
		String line = "Browsers that support Encoding feature indicate that "
				+ "they do so by setting the Accept-Encoding request header";
		for (int i = 0; i < 10000; i++) {
			out.println(line);
		}
		out.println("</BODY></HTML>");
		out.close();
	}
}
