<%@page import="com.example.servletjspdemo.domain.Wines"%>
<%@page import="com.example.servletjspdemo.web.TakeData"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Our wines</title>
</head>
<body>
<table bordercolor=white cellspacing=22>
	<thead>
		<tr>
			<th>TYPE</th>
			<th>ORIGIN</th>
			<th>STRAIN</th>
			<th>NAME</th>
			<th>YEAR</th>
			<th>SWEETNESS</th>
			<th>PRICE</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>
	</thead>
<jsp:useBean id="base" class="com.example.servletjspdemo.service.StorageWinesService" scope="application" />
<tbody>

<% for(com.example.servletjspdemo.domain.Wines wine : base.getAllWines()){ 
%>
		<tr>
		<td><center>
		<%
		out.println("<p>" + wine.getType() + "</p>");
		%>
		</center></td>
		<td><center>
		<%
		out.println("<p>" + wine.getOrigin() + "</p>");
		%>
		</center></td>
		<td>
		<% out.println("<p>" + wine.getStringFromTable() + "</p>");
		%>
		</td>
		<td><center>
		<%
		out.println("<p>" + wine.getName() + "</p>");
		%>
		</center></td>
		<td><center>
		<%
		out.println("<p>" + wine.getYear() + "</p>");
		%>
		</center></td>
		<td><center>
		<%
		out.println("<p>" + wine.getSweetness() + "</p>");
		%>
		</center></td>
		<td><center>
		<%
		out.println("<p>" + wine.getPrice() + "PLN </p>");
		%>
		</center></td>
		<% 
		out.println("<td><center><a href=\"delete?uuid="+String.valueOf(wine.getId())+"\">delete</a></center></td>");
		out.println("<td><center><a href=\"updateWineForm?uuid="
				+String.valueOf(wine.getId())
				+"&type="
				+ String.valueOf(wine.getType())
				+"&origin="
				+ String.valueOf(wine.getOrigin())
				+"&strain="
				+String.valueOf(wine.getStringFromTable())
				+"&name="
				+ String.valueOf(wine.getName())
				+"&year="
				+ String.valueOf(wine.getYear())
				+"&sweetness="
				+String.valueOf(wine.getSweetness())
				+"&price="
				+String.valueOf(wine.getPrice())
				
				+"\">update</a></center></td> </tr>");
		
		}
		%>

		<a href="winesForm.jsp">Add another wine</a>
</p>
</body>
</html>