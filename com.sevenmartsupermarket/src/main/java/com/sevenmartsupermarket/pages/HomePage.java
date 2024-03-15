package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='info']")
	 private WebElement profileName;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement homepageicon;

	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;
	
	@FindBy(xpath="//p[text()='Manage Delivery Boy']")
WebElement ManageDeliveryboy;
	
	@FindBy(xpath="//a//p[contains(text(),'Manage Location')]")
	WebElement ManageLocationlink;
	
	
	@FindBy(xpath="//p[contains(text(),'Manage Expense')]//i")
	WebElement ManageExpenceLink;
	
	@FindBy(xpath="//p[contains(text(),'Expense Category')]")
	WebElement expenseCategoryoption;
	
//@FindBy(xpath="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-expense\"]//i")
	@FindBy(xpath="(//p[contains(text(),'Manage Expense')])[2]")
	WebElement ManageExpenceOption;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
}
	
	
	
	
	public boolean   homepageisDisplayed() {
		boolean loginstatus =homepageicon.isDisplayed();
		System.out.println(loginstatus);
				return loginstatus;
			
		
	}
	
	
	public String getProfileName() {
		return profileName.getText();
		
		
	}
	
	public void clickOnPushnotification() {
		pushNotification.click();
	}
	public void clickOnManagedeliveryboy() {
		ManageDeliveryboy.click();
	}
	
	public void clickOnManagelocation() {
		ManageLocationlink.click();
	}
	
	
	public void clickOnManageExpence() {
		ManageExpenceLink.click();
		
		
	}
	
	public void clickOnManageExpencecateoption() {
	expenseCategoryoption.click();
}
	
	public void clickOnManageExpenceoption() {
		ManageExpenceOption.click();
		
		
	}
}
