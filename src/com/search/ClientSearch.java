package com.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TestDAO;

public class ClientSearch extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// reading the user input
		if(request.getParameter("NewCar") != null){
			(new TestDAO()).addNewCar(Integer.parseInt(request.getParameter("carID")),
					request.getParameter("make"), 
					request.getParameter("model"), 
					Integer.parseInt(request.getParameter("year")), 
					request.getParameter("vin"), 
					Integer.parseInt(request.getParameter("myCars")));
			request.setAttribute("NewCarAdded", "true");
			response.sendRedirect("NewCarAdded.jsp");
		}
		if(request.getParameter("AddCar") != null){
			//request.setAttribute("Imran", yo);
			request.getSession().setAttribute("clientID", request.getParameter("myCars"));
			response.sendRedirect("ModifyCar.jsp");
		}
		if(request.getParameter("DeleteCar") != null){
			//request.setAttribute("Imran", yo);
			request.getSession().setAttribute("clientID", request.getParameter("myCars"));
			response.sendRedirect("DeleteCar.jsp");
		}
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String ClientNum = request.getParameter("myCars");
		ArrayList<String> searchResults = (new TestDAO()).isClientRegistered(
				firstName, lastName);
		boolean clientFound = false;
		String message = "Client not found!";
		if (Integer.parseInt(searchResults.get(0)) > 0) {
			clientFound = true;
			message = "Client found!";
		}
		if (request.getParameter("showCars") != null){
			message="";
		}
		StringBuilder output = new StringBuilder();
		output.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +"
				+ "http://www.w3.org/TR/html4/loose.dtd\">\n"
				+ "<html> \n"
				+ "<head> \n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; "
				+ "charset=ISO-8859-1\"> \n"
				+ "<title> Crunchify.com JSP Servlet Example  </title> \n"
				+ "</head> \n"
				+ "<body> <div align='center'> \n"
				+ "<style= \"font-size=\"12px\" color='black'\""
				+ "\">"
				+ message
				+ "<br>"
				+ searchResults.get(1)
				+ "</font>"
				+ "<form action='ClientSearch'>");
		if (clientFound) {
			output.append("<input type='submit' name='showCars' value='Show My Cars'>");
			output.append("<input type='hidden' name='myCars' value='"
					+ searchResults.get(0) + "'>");
		} else if(request.getParameter("showCars") == null && !clientFound){
			output.append("<input type='submit' name='AddNewClient' value='Add New Client'>");
		}
		
		PrintWriter out = response.getWriter();
		if (request.getParameter("showCars") != null) {
			String car = (new TestDAO()).getAllCarsPerClient(Integer
					.parseInt(request.getParameter("myCars")));
			output.append(car);
			output.append("<input type='submit' name='AddCar' value='Add New Car'>");
			output.append("<input type='submit' name='DeleteCar' value='Delete Car'>");
			output.append("<input type='hidden' name='myCars' value='"+request.getParameter("myCars")+"'>");
			output.append("" + "</body> \n" + "</html>");
			
			out.println(output.toString());
		} else {
			output.append("" + "</body> \n" + "</html>");
			out.println(output.toString());
		}
		
	}
}
