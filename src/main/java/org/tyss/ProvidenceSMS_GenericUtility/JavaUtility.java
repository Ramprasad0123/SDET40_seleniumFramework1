package org.tyss.ProvidenceSMS_GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*
	 * This method is used to generate random number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit)
	{
		/*Random r=new Random();
		r.nextInt();
		return limit;*/
		return new Random().nextInt(limit);
	}
	
	/*
	 * This method is used to convert String to any Data
	 * @param data
	 * @param stratergy
	 */
	public Object convertStringToAnyData(String data, DataType stratergy)
	{
		Object obj=null;
		if(stratergy.toString().equalsIgnoreCase("long"))
		{
			obj=Long.parseLong(data);
		}
		else if(stratergy.toString().equalsIgnoreCase("int"))
		{
			obj=Integer.parseInt(data);
		}
		
		else if(stratergy.toString().equalsIgnoreCase("double"))
		{
			obj=Integer.parseInt(data);
		}
		return obj;
	}
	
	/*
	 * This method is used to current date and time into dd_MMMM_yyyy_hh_mm_sss format
	 * @ return
	 */
	
	public String currentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MMMM_yyyy_hh_mm_sss");
		String actualFormat = sdf.format(date);
		return actualFormat;
	}
	/*
	 * This Method is used to perform Robot class actions
	 * @throws AWTException
	 */
	 public void robotClass() {
		 Robot r=null;
		try {
			r= new Robot();
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	 }

}
