package org.tyss.ProvidenceSMS_GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection connection;
	
	public void openDBConnection(String dbURL, String dbUserName, String dbPassword) throws SQLException
	{
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		connection=DriverManager.getConnection(dbURL, dbUserName, dbPassword);
	}
	
	
	public List<String> getDataFromDataBase(String query, String columnName) throws SQLException
	{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		List<String> list = new ArrayList<>();
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}
	
	
	
	public void addDataToDataBase(String query) throws SQLException {
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		System.out.println("Data is updated  "+result);
	}
	
	
	public boolean verifyDataInDataBase(String query,String col_name,String expecteddata) throws SQLException {
		List<String>list= getDataFromDataBase(query, col_name);
		boolean flag = false;
		for(String actualdata:list)
		{
			if(actualdata.equalsIgnoreCase(expecteddata))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	
	public void closeDB() throws SQLException
	{
		connection.close();
	}

}
