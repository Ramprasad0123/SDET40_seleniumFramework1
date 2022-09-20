package org.provienceSMS.EndToEnd.TC;

import java.sql.SQLException;
import java.util.List;

import org.tyss.ProvidenceSMS_GenericUtility.DatabaseUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;

public class FetchDataFromDataBase {
	public static void main(String[] args) throws SQLException {
		DatabaseUtility databaseUtility = new DatabaseUtility();
		databaseUtility.openDBConnection(IConstantUtility.DB_URL, "root", "root");
		
		List<String> data1 = databaseUtility.getDataFromDataBase("select * from sms;", "address");
		
		System.out.println(data1);
		
		databaseUtility.closeDB();
		
	}

}
