<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="base" class="com.example.servletjspdemo.service.StorageWinesService" scope="application" />
<jsp:useBean id="wino" class="com.example.servletjspdemo.domain.Wines" scope="session" />

<form action="shortForm">
		<%long ID = Long.parseLong(request.getParameter("uuid")); %>
		
			base.showUpdate(ID);

Type: 	<select name="type" value ="${wine.type}">
			<option>Red</option>
			<option>White</option>
			<option>Rose</option>
			<option>Champagne</option>
		</select><br/><br/>
Origin: <select name="origin" value ="${wine.origin}">
			<option>Spain</option>
			<option>Italy</option>
			<option>Chile</option>
			<option>Argentina</option>
			<option>New Zeland</option>
			<option>France</option>
			</select><br/><br/>

Strain: <input type="checkbox" name="strain" value="Carmenere">Carmenere &nbsp
		<input type="checkbox" name="strain" value="Rioja"/>Rioja &nbsp
		<input type="checkbox" name="strain" value="Savignon Blanc"/>Sauvignon Blanc <br/>
		<input type="checkbox" name="strain" value="Cabernet Sauvignon"/>&nbsp &nbspCabernet Sauvignon &nbsp
		<input type="checkbox" name="strain" value="Pinot Noir"/>&nbsp &nbspPinot Noir</t>
		<input type="checkbox" name="strain" value="Primitivo"/>Primitivo</t>  
		<br/><br/>
		

		
Name: <input type="text" name="name" value="${wine.name}"/><br/><br/>

Year: <input type="text" name="year" value="${wine.year}"/><br/><br/>

Level of sweetness: <input type="radio" name="sweetness" value="Sweet"/>Sweet &nbsp &nbsp
					<input type="radio" name="sweetness" value="Med-sweet"/>Med-Sweet &nbsp&nbsp
					  <input type="radio" name="sweetness" value="Dry"/>Dry <br/><br/>

Percent of alcohol: 
		<select name=alcohol value ="${wine.alcohol}">
				<option>0.0</option>
				<option>10.5</option>
				<option>11.0</option>
				<option>11.5</option>
				<option>12.0</option>
				<option>12.5</option>
				<option>13.0</option>
				<option>13.5</option>
				<option>14.0</option>
				<option>14.5</option>
		</select><br/><br/>

Price: <input type="text" name="price" value="${wine.price}"/><br/><br/>

Description: <br/><textarea name="description" cols = "35" rows="1.5" value="${wine.description}"/>Add short description...</textarea><br/><br/>


</body>
</html>