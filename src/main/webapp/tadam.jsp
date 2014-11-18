<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoveWines</title>
</head>
<body>
<jsp:useBean id="Counter" class="com.example.servletjspdemo.session.Counter" scope="session" />
<jsp:setProperty name="Counter" property="*" /> 
<jsp:useBean id="CounterServlet" class="com.example.servletjspdemo.session.CounterServlet" scope="session" />
<jsp:setProperty name="CounterServlet" property="*" />

<h2><center><img src="http://i62.tinypic.com/155pf0z.jpg"></center></h2>
<center>

<p><a href="showWines.jsp">Show all wines</a></p>
<p><a href="winesForm.jsp">Add new wine to the base</a></p>
<p><%CounterServlet.doGet(request, response);%></p><br/>
</center>
<img src="http://i62.tinypic.com/2dmdunt.jpg">


</body>
</html>