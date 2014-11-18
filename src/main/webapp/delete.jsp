<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete wine</title>
</head>
<body>
<jsp:useBean id="wine" class="com.example.servletjspdemo.domain.Wines" scope="session" />

<jsp:setProperty name="wine" property="*" />

<jsp:useBean id="service" class="com.example.servletjspdemo.service.StorageWinesService" scope="application" />
<%
	service.delete(wine.getId());
%>
<p>
	<a href="showWines.jsp">Show wines</a>
</p>
</body>
</html>