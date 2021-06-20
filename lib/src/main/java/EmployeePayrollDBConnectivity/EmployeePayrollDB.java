package EmployeePayrollDBConnectivity;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class EmployeePayrollDB 
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome in Employee payroll database connectivity");
		String jdbcURL = "jdbc:mysql://localhost/payroll_service?characterEncoding=latin1";;
		String userName = "root";
		String password = "Nikita007@";
		Connection connection;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drive loaded");
		}
		catch(ClassNotFoundException e)
		{
			throw new IllegalStateException("Cannot find athe driver in the classpath!", e);
		}
		listDrivers();
		try {
			System.out.print("Connection databse:" +jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, userName , password);
			System.out.println("Connection is successful!!!!!!"+connection);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * This function is use to show the driver which is installed.
	 */
	private static void listDrivers() 
	{
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements())
		{
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println("  "+driverClass.getClass().getName());
		}

	}
		
}
