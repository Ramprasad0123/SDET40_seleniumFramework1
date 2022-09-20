package org.providenceSMS.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBase {
	public static void main(String[] args) throws SQLException  {
		//step1--->create object for the driver
		Driver dbdriver = new Driver();
		
		//step2--->register the driver instance to the jdbc
		DriverManager.registerDriver(dbdriver);
		
		//step3--->get/ establish the database connecction
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root", "root");
		try {
		//step4--->create the statement
		Statement statement = connection.createStatement();
		
		//step5---->Execute the query
		ResultSet result = statement.executeQuery("select * from sms;");
		
		//step6---> verify or itterate or fetch the data
		while(result.next())
		{
		   System.out.println(result.getString("emp_name"));
		}
			
		}
		finally {
			//step7----> close the db connection
			connection.close();//mandatory 
			System.out.println("connection closed successfully");
			
		}
		
	}

}
