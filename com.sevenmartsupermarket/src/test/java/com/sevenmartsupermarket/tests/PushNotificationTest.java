package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.Excel;

public class PushNotificationTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	PushNotificationPage pushnoti ;
	Excel excel= new Excel();

	@Test (groups="Regression")

	public void verifypushNotificationMessage() {
		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnPushnotification();
		pushnoti= new PushNotificationPage(driver);
		excel.setExcelFile("Pnotification","PushNotifi");
		pushnoti.sendPushNotification(excel.getCellData(0,0),(excel.getCellData(0,1)));
		//pushnoti.sendPushNotification("Hi", "hello");
		pushnoti.sucessfullMessage();
	}
	
	
	@Test  (groups="smoke")

	
	public void printExcelData() {
		
		excel.setExcelFile("Login","Login credentails");
		System.out.println(excel.getCellData(0,0));
		System.out.println(excel.getCellData(0,1));
	}
	
	


}


