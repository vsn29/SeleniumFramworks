package com.amelia.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
	String dbUrl = "jdbc:mysql://localhost:3306/flipkart";

	// Database Username
	String username = "root";

	// Database Password
	String password = "root123";

	public String getFromLocation() throws ClassNotFoundException, SQLException {

		String location = null;
		// Query to Execute
		String query = "select fromCity from flight limit 1;";

		Connection cn = databaseConnect();
		Statement stmt = cn.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			location = rs.getString("fromCity");

		}
		// closing DB Connection
		closeDbConnection(cn);
		return location;
	}

	public String getToLocation() throws ClassNotFoundException, SQLException {

		String location = null;
		// Query to Execute
		String query = "select toCity from flight limit 1;";

		Connection cn = databaseConnect();
		Statement stmt = cn.createStatement();
		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			location = rs.getString("toCity");

		}
		// closing DB Connection
		closeDbConnection(cn);
		return location;
	}

	public Connection databaseConnect() throws ClassNotFoundException, SQLException {

		// Load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);

		return con;

	}

	public void closeDbConnection(Connection con) throws SQLException {

		con.close();

	}

}
