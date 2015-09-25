<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Car</title>
</head>
<body>
<form action="ClientSearch"> 
	Car ID
   <input type="text" name="carID" size="20px"> <br>
   <input type="submit" name="DeleteCar" value="Delete">  
   <input type="hidden" name="myCars" value="${sessionScope.clientID}"/>
   </form>
</body>
</html>