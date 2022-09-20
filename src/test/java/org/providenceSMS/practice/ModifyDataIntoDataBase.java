package org.providenceSMS.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataIntoDataBase {
	//for DDL, DML statements
	public static void main(String[] args) throws SQLException {
		//step1---> create the object for the driver
        Driver dbdriver = new Driver();
		
		//step2--->register the driver instance to the jdbc
		DriverManager.registerDriver(dbdriver);
		
		//step3--->get/ establish the database connecction
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root", "root");
		
		try {
			//step4---> create the statement
			Statement statement = connection.createStatement();
			
			//step5----> modify data
			int result = statement.executeUpdate("insert into sms values(1002,'yogi',23456782,'Mysore');");
			
				//step6--->verify or fetch the data
			System.out.println(result+" Data updated successfully");
			}
			finally {
				//step7----> close the db connection
				connection.close();//mandatory 
				System.out.println("connection closed successfully");
				
			}
			
		
	}

}
