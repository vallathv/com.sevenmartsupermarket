package com.sevenmartsupermarket.tests;

import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;

import com.sevenmartsupermarket.utilities.Excel;
import com.sevenmartsupermarket.utilities.GeneralUtility;

import java.time.Duration;


import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.Constants;

public class ManageDeliveryboyTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ManageDeliveryBoyPage managedeliveryboy;
	Excel excel = new Excel();



	@Test(groups={"smoke","regression"})

	public void VerifyDeliveryboyDetailCreatedSuccesfully() {
		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnManagedeliveryboy();
		managedeliveryboy = new ManageDeliveryBoyPage(driver);
		//managedeliveryboy.clickOnAddNewDeliveryboy();
		managedeliveryboy.enterdeliveryboyinfo(GeneralUtility.getRandomFirstName() , 
				GeneralUtility.getRandomFirstName()+"@gmail.com", "7889654", "mainstreet,add2,CA", GeneralUtility.getRandomFirstName()+"123", "Ami36i4");
		
		String Expected_message = "×\nAlert!\nDelivery Boy Details Created Successfully"; 
		String actual_message = managedeliveryboy.getsucsefullmessagetxt();
		
		Assert.assertEquals(actual_message, Expected_message);

	}

	@Test (groups={"smoke","regression"})

	public void addDeliveryboydetailfromExcel() {
		loginpage = new LoginPage(driver);
		loginpage.login1();
		homepage = new HomePage(driver);
		homepage.clickOnManagedeliveryboy();
		managedeliveryboy = new ManageDeliveryBoyPage(driver);
		
		excel.setExcelFile("ManageDeliveryBoyinfo", "DeliveyBoyDetails");
		managedeliveryboy.enterdeliveryboyinfo(excel.getCellData(1, 0) + "_" + managedeliveryboy.getTimestamp(), (excel.getCellData(1, 1)), excel.getCellData(1, 2),
				excel.getCellData(1, 3), excel.getCellData(1, 4)+ "_" + managedeliveryboy.getTimestamp(), excel.getCellData(1, 5));
		
		String Expected_message = "×\nAlert!\nDelivery Boy Details Created Successfully";
		String actual_message = managedeliveryboy.getsucsefullmessagetxt();
		Assert.assertEquals(actual_message, Expected_message);

	}

	@Test
	public void addFiveDeliveryBoyDetailsfromexcel() {

		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnManagedeliveryboy();
		managedeliveryboy = new ManageDeliveryBoyPage(driver);
		// Setting the Excel file for data retrieval
		excel.setExcelFile("ManageDeliveryBoyinfo", "DeliveyBoyDetails");
		

		for (int row = 1; row <= 5; row++) {

			String Name = excel.getCellData(row, 0) + "_" + managedeliveryboy.getTimestamp();
			String email = excel.getCellData(row, 1);
			String PhNo = excel.getCellData(row, 2);
			String addr = excel.getCellData(row, 3);
			String User_name = excel.getCellData(row, 4)+"_" +managedeliveryboy.getTimestamp();
			String pass_word = excel.getCellData(row, 5);

			managedeliveryboy.enterdeliveryboyinfo(Name, email, PhNo, addr, User_name, pass_word);

		}
	}
	

	
	

	
	
		
	
	}

