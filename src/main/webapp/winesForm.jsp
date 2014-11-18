<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<jsp:useBean id="bazka" class="com.example.servletjspdemo.service.StorageWinesService" scope="application" />
<jsp:useBean id="wine" class="com.example.servletjspdemo.domain.Wines" scope="session" />
<jsp:setProperty name="wine" property="*" /> 

<form action="shortForm">


Type: 	<select name="type">
			<option>Red</option>
			<option>White</option>
			<option>Rose</option>
		</select><br/><br/>
Origin: <select name="origin">
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

Price: <input type="text" name="price" value="${wine.price}"/><br/><br/>

<br/><br/>




<br/><br/>
<input type="submit" value="Add"/>
<input type="reset" value="Cancel"/>

</form>
</body>
</html>