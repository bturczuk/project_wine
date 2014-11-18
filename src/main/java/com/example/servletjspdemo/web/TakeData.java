package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.rmi.CORBA.Util;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Wines;
import com.example.servletjspdemo.service.StorageWinesService;



@WebServlet(urlPatterns = "/shortForm")


public class TakeData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		
		
		PrintWriter writer = response.getWriter();
		
		StorageWinesService service = (StorageWinesService) getServletContext().getAttribute("base");
		
		if(request.getSession().getAttribute("wino") == null){
			request.getSession().setAttribute("wino", new Wines()); 
		}
		
		Wines wine = (Wines) request.getSession().getAttribute("wino");
	
		
		
	String type = null;
	type = request.getParameter("type");
	
	String origin  = null;
	origin = request.getParameter("origin");
	
	String strain = "";
	strain = request.getParameter("strains");

	
	String strains[]= request.getParameterValues("strain");
	strain = "";
	if(strains != null){	
	for(int i=0; i<strains.length; i++){
			strain += strains[i] + ", ";		
	}
	}
	else if (strains == null){
		strain = "none selected";
	}

	String name = null;
	name = request.getParameter("name");
	
	int year = 1900;
	int years = 1900;
	if(request.getParameter("year") != null) {
	years = Integer.parseInt(request.getParameter("year"));
	}
	
	
	String sweetness = null;
	sweetness = request.getParameter("sweetness");
	
	String price;
	price = request.getParameter("price");
		
	System.out.println(strain);
	
	String body = "<html><body>"
			+"<form action=\"/servletjspdemo/winesForm.jsp\">"
			+"<u>Type:</u> "
			+type
			+"<br/><u>Origin:</u> "
			+origin
			+"<br/><u>Strain:</u> "
			+strain
			+"<br/><u>Name:</u> "
			+name 
			+"<br/><u>Year of produce:</u> "
			+years
			+"<br/><u>Level of sweetness:</u> "
			+sweetness
			+"<br/><u>Price:</u> "
			+price
			+"PLN<br/><br/> "


			+"<a href=\"winesForm.jsp\">Add another wine</a><br/><br/>"
			+ "<a href=\"showWines.jsp\">Show all wines</a><br/>"
			+"<down><center><img src=\"http://i60.tinypic.com/dvsz6r.jpg\"></center></down>"
			+"<br/><br/>"
			+"</form>";
			

	
	
	wine.setType(type);
	wine.setOrigin(origin);
	wine.setStrain(strains);
	wine.setName(name);
	wine.setYear(years);
	wine.setSweetness(sweetness);
	wine.setPrice(price);
	
	
	service.add(wine);
	
	writer.println(body);
	writer.close();
	}
	
	@Override
	public void init() throws ServletException {

		if(getServletContext().getAttribute("base") == null)
		{
			getServletContext().setAttribute("base", new StorageWinesService());
		}


	}

	
	
}

