package com.sevenmartsupermarket.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenmartsupermarket.utilities.PageUtility;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class ManageListExpensePage {

	WebDriver driver;
	PageUtility pageUtility = new PageUtility(driver);
	WaitUtility waitutility =new WaitUtility();
	

	@FindBy(xpath = "//h1[text()='Add Expense']")
	WebElement addExpensepageTitle;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	WebElement newLink;

	@FindBy(xpath = "//select[@id='user_id']")
	WebElement userField;

	@FindBy(xpath = "//select[@id='ex_cat']")
	WebElement category;

	@FindBy(xpath = "//select[@id='order_id']")
	WebElement orderid;

	@FindBy(xpath = "//select[@id='purchase_id']")
	WebElement purchaseId;

	@FindBy(xpath = "//select[@id='ex_type']")
	WebElement expenseType;

	@FindBy(xpath = "//input[@id='amount']")
	WebElement amount;

	@FindBy(xpath = "//input[@name='userfile']")
	WebElement fileUpload;
	@FindBy(xpath = "//button[@name='create']")
	//@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessge;

	public ManageListExpensePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String gettextofAddExpensePage() {
		return addExpensepageTitle.getText();

	}

	public void clickOnAddExpense() {
		newLink.click();
		System.out.println("Clicked on Add New Expense ");

	}

	public void selectUserField() {
		userField.click();
		pageUtility.selectIndex(userField, 6);

	}

	public void selectCategoryFromDropdown() {
		category.click();
		pageUtility.selectIndex(category, 4);

	}

	public void selectOrderId() {
		orderid.click();
		pageUtility.selectIndex(orderid, 3);

	}

	public void selectPurchaseId() {
		purchaseId.click();
		pageUtility.selectIndex(purchaseId, 4);

	}

	public void selectExpenseType() {
		expenseType.click();
		pageUtility.selectIndex(expenseType, 3);

	}

	public String enterAmount(String amt) {
		amount.sendKeys(amt);
		return amt;

	}
	

	public void fileUploadpath() throws InterruptedException {

		pageUtility = new PageUtility(driver);
		pageUtility.scrolldown(fileUpload);
		Thread.sleep(5000);
		String filePath = "C:\\Users\\USER\\Desktop\\Data.xlsx";
		File file= new File(filePath);
		fileUpload.sendKeys(file.getAbsolutePath());
	}
	

	
	
	

	public void clickonSave() throws InterruptedException {
		pageUtility = new PageUtility(driver);
		pageUtility.scrolldown(savebutton);
		System.out.println("scrolleddown");
		Thread.sleep(4000);
		savebutton.click();
		
	

	}
	
	public String  getsucsefullmessagetxt() {
		String  message=successMessge.getText();
		System.out.println(message);
		return message;		
		
}
	
	public void addExpenseInfo(String amt) throws InterruptedException {
		clickOnAddExpense();
		selectUserField();
		selectCategoryFromDropdown();
		selectOrderId();
		selectPurchaseId();
		selectExpenseType();
		enterAmount( amt);
		fileUploadpath();
		clickonSave();
		
		
	}
}
