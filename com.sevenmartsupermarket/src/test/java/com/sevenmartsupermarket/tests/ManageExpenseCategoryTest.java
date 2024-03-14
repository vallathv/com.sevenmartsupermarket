package com.sevenmartsupermarket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.ExpenseCategoryPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;


public class ManageExpenseCategoryTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	ExpenseCategoryPage expensecategory=new ExpenseCategoryPage (driver);
	
	
	
	
	
	@Test
	
	public void verifypagetitleofExpensecategory() {
		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnManageExpence();
		homepage.clickOnManageExpencecateoption();
		 expensecategory=new ExpenseCategoryPage (driver);
		String Expected_title="Expense Category";
		String actual_title= expensecategory.gettextofExpenseCategoryPage();
		Assert.assertEquals(actual_title, Expected_title);
			
		
	}
	@Test

	public void VerifyexpenseCategoryAddedSuccesfully() {
		loginpage = new LoginPage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		homepage = new HomePage(driver);
		homepage.clickOnManageExpence();
		homepage.clickOnManageExpenceoption();
		expensecategory=new ExpenseCategoryPage (driver);
		expensecategory.addnewCategoryInfo("apple");
		String Expected_message = "×\nAlert!\nExpense Category Created Successfully"; 
		String actual_message = expensecategory.getsucsefullmessagetxt();
		Assert.assertEquals(actual_message, Expected_message);
		
	}
	
	
	
	
	

	
}
