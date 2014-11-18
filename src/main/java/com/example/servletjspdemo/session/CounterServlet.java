package com.example.servletjspdemo.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(urlPatterns = "/hello")
public class CounterServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
			HttpSession session = request.getSession();

			Counter counter = (Counter) session.getAttribute("counter");
	counter.set(counter.get() + 1);
	session.setAttribute("counter", counter);

	PrintWriter writer = response.getWriter();

	String body = "<font size=\"2\">You are " + counter + " person on that webpage!</font>";

		writer.println(body);
	}
}