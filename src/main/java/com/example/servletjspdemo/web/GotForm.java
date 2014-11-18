package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/formularzwypelniony")
public class GotForm extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		
		String selectedHobby = "";
		for (String hobby : request.getParameterValues("hobby")) {
			selectedHobby += hobby + " ";
		}
		
		String body="<html><body> Twoje imie to: " 
		+request.getParameter("imie")
		+"<br/> Wiek: "
		+request.getParameter("wiek")
		+"<br/> Hobby: " + selectedHobby + "<br />"
		+"<br/> Wojewodztwo: "
		+request.getParameter("wojewodztwo")
		+"<br/> Zainteresowania: "
		+request.getParameter("opis")

		+"</body></html>";
				
		writer.println(body);
		
		writer.close();
	
	}
}
