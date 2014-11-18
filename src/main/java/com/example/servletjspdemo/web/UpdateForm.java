package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = "/updateWineForm")
public class UpdateForm extends HttpServlet {

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
		
		boolean red = false;
		boolean white = false;
		boolean rose = false;
		if(request.getParameter("type").equalsIgnoreCase("Red") ){
			red=true;
		}
		if(request.getParameter("type").equalsIgnoreCase("White") ){
			white=true;
		}
		if(request.getParameter("type").equalsIgnoreCase("Rose") ){
			rose=true;
		}
		
		
		String origin  = null;
		origin = request.getParameter("origin");

		boolean spain = false;
		boolean italy = false;
		boolean chile = false;
		boolean argentina = false;
		boolean njuzeland = false;
		boolean france = false;
		
		if(request.getParameter("origin").equalsIgnoreCase("Spain") ){
			spain=true;
		}
		if(request.getParameter("origin").equalsIgnoreCase("Italy") ){
			italy=true;
		}
		if(request.getParameter("origin").equalsIgnoreCase("Chile") ){
			chile=true;
		}
		if(request.getParameter("origin").equalsIgnoreCase("Argentina") ){
			argentina=true;
		}
		if(request.getParameter("origin").equalsIgnoreCase("New Zeland") ){
			njuzeland=true;
		}
		if(request.getParameter("origin").equalsIgnoreCase("France") ){
			france=true;
		}
		
		
		
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
		
		
		
		String name;
		name = request.getParameter("name");
		
		int year=0;
		int years = 1900;
		if(request.getParameter("year") != null) {
		years = Integer.parseInt(request.getParameter("year"));
		}
		
		
		String sweetness = null;
		sweetness = request.getParameter("sweetness");
		
		boolean sweet = false;
		boolean medsweet = false;
		boolean dry = false;
		if(request.getParameter("sweetness").toLowerCase().contains("Sweet".toLowerCase())) sweet = true;
		if(request.getParameter("sweetness").toLowerCase().contains("Med-sweet".toLowerCase())) medsweet = true;
		if(request.getParameter("sweetness").toLowerCase().contains("Sweet".toLowerCase())) dry = true;

		
		String price;
		price = request.getParameter("price");
		
		
		long ID = Long.parseLong(request.getParameter("uuid"));
		

		String body = "<html><body>";

		boolean carmenere = false;
		boolean rioja = false;
		boolean savignonblanc = false;
		boolean cabernetsavignon=false;
		boolean pinotnoir = false;
		boolean primitivo = false;
		if(request.getParameter("strain").toLowerCase().contains("Carmenere".toLowerCase())) carmenere = true;
		if(request.getParameter("strain").toLowerCase().contains("Rioja".toLowerCase())) rioja = true;
		if(request.getParameter("strain").toLowerCase().contains("Savignon Blanc".toLowerCase())) savignonblanc = true;
		if(request.getParameter("strain").toLowerCase().contains("Cabernet Savignon".toLowerCase())) cabernetsavignon = true;
		if(request.getParameter("strain").toLowerCase().contains("Pinot noir".toLowerCase())) pinotnoir = true;
		if(request.getParameter("strain").toLowerCase().contains("Primitivo".toLowerCase())) primitivo = true;
			
		
		body += "<form action=\"/servletjspdemo/updateWine\"; method=\"get\">"
				+"Type: <select name=\"type\">";
				if(red) body+="<option selected>Red</option>";
				else body+="Type: <option>Red</option>";
				if(white) body+="<option selected>White</option>";
				else body+="<option>White</option>";
				if(rose) body+="<option selected>Rose</option>";
				else body+="<option>Rose</option>";
						
				body += "</select><br/><br/>";
			
				body += "Origin: <select name=\"origin\">";
				if(spain) body+="<option selected>Spain</option>";
				else body+="<option>Spain</option>";
				if(italy) body+="<option selected>Italy</option>";
				else body+="<option>Italy</option>";
				if(chile) body+="<option selected>Chile</option>";
				else body+="<option>Chile</option>";
				if(argentina) body+="<option selected>Argentina</option>";
				else body+="<option>Argentina</option>";
				if(njuzeland) body+="<option selected>New Zeland</option>";
				else body+="<option>New Zeland</option>";
				if(france) body+="<option selected>France</option>";
				else body+="<option>France</option>";	
				
				body += "</select><br/><br/>";


			
				if(carmenere) body+= "Strain: <input type=\"checkbox\" name=\"strain\" value=\"Carmenere\" checked>Carmenere &nbsp";
				else body+="Strain: <br><input type=\"checkbox\" name=\"strain\" value=\"Carmenere\">Carmenere &nbsp ";
				if(rioja) body+="<input type=\"checkbox\" name=\"strain\" value=\"Rioja\" checked> Rioja &nbsp" ;
				else body+="<input type=\"checkbox\" name=\"strain\" value=\"Rioja\">Rioja &nbsp" ;
				if(savignonblanc) body+= "<input type=\"checkbox\" name=\"strain\" value=\"Savignon Blanc\" checked>Savignon Blanc &nbsp";
				else body+="<br><input type=\"checkbox\" name=\"strain\" value=\"Savignon Blanc\">Savignon Blanc &nbsp ";
				if(cabernetsavignon) body+="<input type=\"checkbox\" name=\"strain\" value=\"Cabernet Savignon\" checked> Cabernet Savignon &nbsp" ;
				else body+="<input type=\"checkbox\" name=\"strain\" value=\"Cabernet Savignon\">Cabernet Savignon &nbsp" ;
				if(pinotnoir) body+= "<input type=\"checkbox\" name=\"strain\" value=\"Pinot Noir\" checked>Pinot Noir &nbsp";
				else body+="<br><input type=\"checkbox\" name=\"strain\" value=\"Pinot Noir\">Pinot Noir &nbsp ";
				if(primitivo) body+="<input type=\"checkbox\" name=\"strain\" value=\"Primitivo\" checked> Primitivo <br/>" ;
				else body+="<input type=\"checkbox\" name=\"strain\" value=\"Primitivo\">Primitivo<br/>" ;
				
				
				body += 
				"<br/> Name: <input type =\"text\" name=\"name\"value=\"" + name +"\" />"
				+"<br/><br/> Year: <input type =\"text\" name=\"year\"value=\"" + years +"\" />";
				
				body += "<br/><br/>";

				if(sweet) body+= "Sweetness: <input type=\"radio\" name=\"sweetness\" value=\"Sweet\" checked>Sweet &nbsp";
				else body+="Sweetness: <br><input type=\"radio\" name=\"sweetness\" value=\"Sweet\">Sweet &nbsp ";
				if(medsweet) body+="<input type=\"radio\" name=\"sweetness\" value=\"Med-sweet\" checked> Med-sweet &nbsp" ;
				else body+="<input type=\"radio\" name=\"sweetness\" value=\"Med-sweet\">Med-sweet &nbsp" ;
				if(dry) body+= "<input type=\"radio\" name=\"sweetness\" value=\"Dry\" checked>Dry &nbsp";
				else body+="<input type=\"radio\" name=\"sweetness\" value=\"Dry\">Dry &nbsp ";
				
				
				body += "<br/><br/>"
				
				+"Price: <input type=\"text\" name=\"price\" value=\"" + price + "\"/>"
				
				+"<input type =\"hidden\" name=\"uuid\"value=\"" + ID +"\" />"
				+ "<br/><br/> <input type =\"submit\" value=\"Update\" />"
				+"<br/><br/>"

			+"<a href=\"winesForm.jsp\">Add another wine</a><br/><br/>"
			+ "<a href=\"showWines.jsp\">Show all wines</a><br/>"
//			+"<center><img src=\"wines.jpg\"></center>"
			//"<button href=\"showWines.jsp\"/> Show all wines</button>"
			+"<br/><br/>"
			+"</form></body></html>";
	
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