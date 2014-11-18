package com.example.servletjspdemo.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import com.example.servletjspdemo.domain.Wines;
import com.example.servletjspdemo.service.StorageWinesService;

@WebServlet(urlPatterns = "/updateWine")

public class UpdateWine extends HttpServlet {

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
		
		long ID = Long.parseLong(request.getParameter("uuid"));
		
		String body = "<html><body><head><link rel=\"stylesheet\" type=\"text/css\" href=\"dist/css/bootstrap.css\"></head><title>Update</title> Updated!";

		Wines updatedWine = new Wines();

		updatedWine.setType(type);
		updatedWine.setOrigin(origin);
		updatedWine.setStrain(strains);
		updatedWine.setName(name);
		updatedWine.setYear(years);
		updatedWine.setId(ID);
		updatedWine.setSweetness(sweetness);
		updatedWine.setPrice(price);


		service.setUpdate(updatedWine,ID);
		body += ""
					+ "<form action=\"/servletjspdemo/showWines.jsp\"; method=\"get\">"
					+ "<br/><br/> <input type =\"submit\" value=\"Back\" />"
					+"<br/><br/></body></html>";
		writer.println(body);
		writer.close();
	}
	
		@Override
		public void init() throws ServletException {
				if(getServletContext().getAttribute("base") == null)
				{
					System.out.println("blad");
					getServletContext().setAttribute("base", new StorageWinesService());
				}
		}
}