package com.example.servletjspdemo.web;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

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


@WebServlet(urlPatterns = "/delete")

public class DeleteWine extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

			StorageWinesService service = (StorageWinesService) getServletContext().getAttribute("base");

			
			if(request.getSession().getAttribute("wine") == null){
				request.getSession().setAttribute("wine", new Wines());
			}
			
			Wines wine = (Wines) request.getSession().getAttribute("wine");
			
			
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
			
			String year = "";
			year = request.getParameter("year");
			
			String sweetness = null;
			sweetness = request.getParameter("sweetness");
			
			String alcohol = null;
			alcohol = request.getParameter("alcohol");
			
			String price = null;
			price = request.getParameter("price");
			
			String description = null;
			description = request.getParameter("description");

			long ID = Long.parseLong(request.getParameter("uuid"));
			String body = "<html><body> Wine with ID "
			+ ID
			+" has been removed<br/>";
			
			service.delete(ID);
			
			body += ""
					+ "<br/><br/><p><a href=\"showWines.jsp\">Back</a></p>"
			+"<br/><br/></body></html>";
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