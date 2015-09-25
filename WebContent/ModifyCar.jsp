<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Your Cars Here</title>
</head>
<body>
<h1>Add New Car</h1>
<form action="ClientSearch">  
    Car ID
   <input type="text" name="carID"size="20px"> <br>
    Make 
   <input type="text" name="make"size="20px"> <br>
   Model
   <input type="text" name="model"size="20px"> <br>
    Year
   <input type="text" name="year"size="20px"> <br>
   VIN
   <input type="text" name="vin"size="20px"> <br>
    Make 
   <input type="submit" name="NewCar" value="Add Car">  
   <input type="hidden" name="myCars" value="${sessionScope.clientID}"/>
  </form>
</body>
</html>