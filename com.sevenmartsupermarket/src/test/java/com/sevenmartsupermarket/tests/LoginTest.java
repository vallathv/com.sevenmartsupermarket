package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.Screenshot;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups="smoke")

	public void verifyLogin() {
		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		String expectedprofilename = "Amina";   
		String actualprofilename = homepage.getProfileName();
		Assert.assertEquals(actualprofilename, expectedprofilename);

	}

	@Test(retryAnalyzer = com.sevenmartsupermarket.listeners.RetryAnalyzer.class)

	public void verifyErrormessage_Whenloginprocessfails() {

		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q88");
		String expectderrortxt = "Alert!";
		String Actualerrortext = loginpage.errormessage_txt();
		Assert.assertEquals(Actualerrortext, expectderrortxt);

	}

}