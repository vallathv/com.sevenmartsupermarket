package com.sevenmartsupermarket.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageLocationPage {

	WebDriver driver;
	Properties properties = new Properties();
	PageUtility pageUtility = new PageUtility(driver);

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//select[@id='country_id']")
	WebElement country;

	@FindBy(xpath = "//select[@id='st_id']")
	WebElement state;

	@FindBy(xpath = "//input[@id='location']")
	WebElement locationField;

	@FindBy(xpath = "//input[@id='delivery']")
	WebElement deliveryChargefield;

	@FindBy(xpath = "//button[@name='create']")
	WebElement savebutton;

	@FindBy(xpath = "//a[@type='button']")
	WebElement cancelbutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessge;

	@FindBy(xpath = "//tbody/tr[1]/td[6]/a[2]")
	WebElement deletebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deletedMessage;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnAddNewlocation() {

		newButton.click();
		System.out.println("Clicked on Add New Locationbutton");
	}

	/*
	 * public void selectCountry() { pageUtility = new PageUtility(driver);
	 * pageUtility.selectValue(country, "United Kingdom");
	 * 
	 * }
	 */
	public String selectState() {
		pageUtility = new PageUtility(driver);
		String state_dd = pageUtility.selectValue(state, "3807");
		return state_dd;
	}

	public void enterLocation(String location) {

		locationField.sendKeys(location);

	}

	public void enterDeliveryCharge(String charge) {

		deliveryChargefield.sendKeys(charge);

	}

	public void scrollpage() {
		pageUtility = new PageUtility(driver);
		pageUtility.mouseMove(savebutton);
	}

	public void clickSavebutton() {

		savebutton.click();

	}

	public void enterLocationInformations(String location, String charge) {
		clickOnAddNewlocation();
		// selectCountry();
		selectState();
		enterLocation(location);

		enterDeliveryCharge(charge);

		clickSavebutton();
	}

	public String getsucsefullmessagetxt() {
		String message = successMessge.getText().trim();
		System.out.println(message);
		return message;

	}

	public void clickOnDeletebutton() {
		scrollpage();
		cancelbutton.click();
		deletebutton.click();
		driver.switchTo().alert().accept();

	}

	public String getDeletedmMessagetxt() {
		String del_message = deletedMessage.getText().trim();
		System.out.println(del_message);
		return del_message;

	}

}
