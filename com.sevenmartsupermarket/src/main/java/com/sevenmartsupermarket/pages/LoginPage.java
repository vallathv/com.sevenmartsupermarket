package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@name='remember_me']")
	WebElement remeberMeCheckBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;
	
	@FindBy(xpath="//div//h5[text()=' Alert!']")
	WebElement alertmessage;
	
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 

		try {
			FileInputStream fi = new FileInputStream(com.sevenmartsupermarket.constants.Constants.CONFIG_FILE_PATH);
			properties.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterUserName(String UserName) {
		userNameField.sendKeys(UserName);
	}

	public void enterPassword(String Password) {
		passwordField.sendKeys(Password);
	}

	public void clickOnLogin() {
		loginButton.click();
	}

	public void login(String userName, String Password) {
		enterUserName(userName);
		enterPassword(Password);
		clickOnLogin();
	}

	public void login1() {
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("passWord");
		login(userName, password);

	}
	
	public String  errormessage_txt() {
	
	String  error_txt=	alertmessage.getText();
	System.out.println(error_txt.trim());
	return error_txt;
		
	}
		
	}

