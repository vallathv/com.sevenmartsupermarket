package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenmartsupermarket.pages.ManageLocationPage;
import com.sevenmartsupermarket.utilities.Excel;
import com.sevenmartsupermarket.utilities.GeneralUtility;


public class ManageLocationTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	ManageLocationPage managelocationpage; 

	Excel excel = new Excel();
	
	@Test(retryAnalyzer = com.sevenmartsupermarket.listeners.RetryAnalyzer.class)
	
	public void verifynewlocationdaddedsuccesfully() {
		
		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnManagelocation();
		managelocationpage = new ManageLocationPage(driver);
		managelocationpage.enterLocationInformations(" UNited", "10");
		String Expected_message = "×\nAlert!\nLocation Created Successfully"; 
		String actual_message = managelocationpage.getsucsefullmessagetxt();
		System.out.println(GeneralUtility.getRandomFirstName());
		Assert.assertEquals(actual_message, Expected_message);
		
	}
	
	@Test
	public void verifyLocationDeletedSuccesfully1() {
		
		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnManagelocation();
		managelocationpage = new ManageLocationPage(driver);
		
		managelocationpage.enterLocationInformations(" CA", "70");
		managelocationpage.clickOnDeletebutton();
		String Expected_message = "×\nAlert!\nLocation Deleted Successfully"; 
		String actual_message = managelocationpage.getDeletedmMessagetxt();
		Assert.assertEquals(actual_message, Expected_message);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
