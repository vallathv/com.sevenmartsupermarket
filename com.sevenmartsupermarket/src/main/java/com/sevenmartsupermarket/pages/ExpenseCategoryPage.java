package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpenseCategoryPage {

	WebDriver driver;

	@FindBy(xpath = "//h1[text()='Expense Category']")
	WebElement expenseCategoryTxt;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	WebElement newLink;

	@FindBy(xpath = "//input[@id='name']")
	WebElement titleField;

	@FindBy(xpath = "//button[@name='create']")
	WebElement savebutton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessge;


	public ExpenseCategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String gettextofExpenseCategoryPage() {
		return expenseCategoryTxt.getText();

	}

	public void clickOnAddNewCategory() {
		newLink.click();
		System.out.println("Clicked on Add New Expense category");

	}

	public void enterTitle(String title) {
		titleField.sendKeys(title);

	}

	public void clickonSave() {

		savebutton.click();

	}
	
	public void addnewCategoryInfo(String title) {
		clickOnAddNewCategory();
		enterTitle(title);
		clickonSave();
		
	}

	public String  getsucsefullmessagetxt() {
		String  message=successMessge.getText();
		System.out.println(message);
		return message;		
		
}
}
