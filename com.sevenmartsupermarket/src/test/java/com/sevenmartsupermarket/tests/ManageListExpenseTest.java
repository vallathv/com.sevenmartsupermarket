package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.ExpenseCategoryPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageListExpensePage;

public class ManageListExpenseTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	ManageListExpensePage managelistexpense =new ManageListExpensePage (driver);
	
	

	@Test
	
	public void verifyExpenseCreatedSuccesfully() throws InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnManageExpence();
		homepage.clickOnManageExpenceoption();
		managelistexpense=new ManageListExpensePage (driver);
		managelistexpense.addExpenseInfo("80");
		String Expected_message = "×\nAlert!\nExpense Record Created Successfully"; 
		String actual_message = managelistexpense.getsucsefullmessagetxt();
		
		
	

}
}