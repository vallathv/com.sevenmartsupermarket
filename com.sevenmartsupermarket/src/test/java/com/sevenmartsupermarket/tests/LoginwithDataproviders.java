package com.sevenmartsupermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenmartsupermarket.dataproviders.DataProviders;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.base.Base;

;

public class LoginwithDataproviders extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Test(dataProvider ="multilogins", dataProviderClass = DataProviders.class )
	
	public void verifyLoginWithDifferntAdminUsers(String userName, String Password) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login(userName, Password);
		 Assert.assertTrue(homepage.homepageisDisplayed(), "Login failed for username: " + userName);
		
		
		
	}	
	
	

}
