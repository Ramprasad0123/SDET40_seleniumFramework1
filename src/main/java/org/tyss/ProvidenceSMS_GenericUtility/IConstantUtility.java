package org.tyss.ProvidenceSMS_GenericUtility;
/*
 * This interface consists of all the external file paths
 */
public interface IConstantUtility {
	/*
	 * variable, Method name=camel case
	 * interface,class,enum,annotation=Pascel case
	 * Ststic final member-->CAPITAL
	 */
	String PROJECT_PATH = System.getProperty("user.dir");
	String EXCEL_PATH = PROJECT_PATH +"/src/test/resources/ComTestdata1.xlsx";
	String PROPERTY_FILE_PATH = PROJECT_PATH +"/src/test/resources/CommonData.Properties";
	String PHOTO_PATH = PROJECT_PATH +"/src/test/resources/photo.png";
	String DB_URL="jdbc:mysql://localhost:3306/tyss";

}

