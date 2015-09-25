package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/EMP";
	// Database credentials
	static final String USER = "username";
	static final String PASS = "password";

	public static void main(String[] args) {
		ReadClient();
	}// end main

	public static String ReadClient() {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		Statement stmt = null;
		String first_name = "";
		String last_name = "";
		Date date_of_birth;
		String address = "";
		String phone = "";
		String email = "";
		StringBuilder myClients = new StringBuilder();

		String sql;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"SYSTEM", "password");
			stmt = connection.createStatement();
			sql = "SELECT first_name, last_name, date_of_birth, address, phone, email from CLIENTS";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				first_name = rs.getString("first_name");
				last_name = rs.getString("last_name");
				date_of_birth = rs.getDate("date_of_birth");
				address = rs.getString("address");
				phone = rs.getString("phone");
				email = rs.getString("email");
				myClients.append("Clients: " + "<b>" + first_name + "</b>"
						+ " " + last_name + " " + date_of_birth + " " + address
						+ " " + phone + " " + email + "<br>");
				// System.out.println("Clients: " + first_name +" "+ last_name +
				// " "+ date_of_birth +" "+ address +" "+ phone +" "+ email);
				myClients.append("\n");
			}
			connection.close();
			return myClients.toString();
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return myClients.toString();
	}
	
	public ArrayList<String> isClientRegistered(String firstName,String lastName) {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		Statement stmt = null;
		String first_name = "";
		String last_name = "";
		Date date_of_birth;
		String address = "";
		String phone = "";
		String email = "";
		int clientID=0;
		ArrayList<String> results=new ArrayList<String>();
		StringBuilder myClients = new StringBuilder();

		String sql;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"SYSTEM", "password");
			stmt = connection.createStatement();
			sql = "SELECT first_name, last_name, date_of_birth, address, phone, email from CLIENTS"
					+ " where first_name="+firstName+" and last_name="+lastName;
			
			PreparedStatement p = connection.prepareStatement("SELECT client_id,first_name, last_name, date_of_birth, address, phone, email from CLIENTS"
					+ " where first_name=? and last_name=?");
					p.setString(1, firstName);
					p.setString(2, lastName);
					//p.setString(3, address);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				clientID=rs.getInt("client_id");
				first_name = rs.getString("first_name");
				last_name = rs.getString("last_name");
				date_of_birth = rs.getDate("date_of_birth");
				address = rs.getString("address");
				phone = rs.getString("phone");
				email = rs.getString("email");
				myClients.append("Clients: " + "<b>" + clientID+" "+first_name + "</b>"
						+ " " + last_name + " " + date_of_birth + " " + address
						+ " " + phone + " " + email + "<br>");
				myClients.append("\n");
			}
			results.add(clientID+"");
			results.add(myClients.toString());
			
			connection.close();
			return results;
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return results;
	}
	
	public String getAllCarsPerClient(int clientID) {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		Statement stmt = null;
		StringBuilder myCars = new StringBuilder();
		int carID=0;
		String make,model,vin="";
		int year;

		String sql;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"SYSTEM", "password");
			stmt = connection.createStatement();
			
			PreparedStatement p = 
					connection.prepareStatement("SELECT car_id,make,'model',car_year,vin from cars where"
							+ " client_id=?");
					p.setInt(1, clientID);
					//p.setString(3, address);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				make = rs.getString("make");
				model = rs.getString("'model'");
				year = rs.getInt("car_year");
				vin = rs.getString("vin");
				carID = rs.getInt("car_id");
				myCars.append("Cars: " + "<b>" + make + "</b>"
						+ " " + model + " " + year + " " + vin
						+ " " + carID +  "<br>");
				myCars.append("\n");
			}
			connection.close();
			return myCars.toString();
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return myCars.toString();
	}
	
	public String addNewCar(int carID,String make,String model,int year,String VIN,int clientID) {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		Statement stmt = null;
		StringBuilder myCars = new StringBuilder();

		String sql;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"SYSTEM", "password");
			stmt = connection.createStatement();
			
			PreparedStatement p = 
					connection.prepareStatement("INSERT into cars values(?,?,?,?,?,?)");
					p.setInt(1, carID);
					p.setString(2,make);
					p.setString(3,model);
					p.setInt(4, year);
					p.setString(5, VIN);
					p.setInt(6, clientID);
					//p.setString(3, address);
			int rs = p.executeUpdate();
			connection.close();
			return myCars.toString();
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return myCars.toString();
	}
}
