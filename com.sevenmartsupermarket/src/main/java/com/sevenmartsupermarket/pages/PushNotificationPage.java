package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage {

	WebDriver driver;

	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;

	@FindBy(xpath = "//input[@id='title']")
	WebElement titlefield;

	@FindBy(xpath = "//input[@id='description']")
	WebElement descriptionfield;

	@FindBy(xpath = "//button[@name='create']")
	WebElement sendButton;
	
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessge;
	
	
	
	//@FindBy(xpath="//h3[text()='Push Notifications Informations']")
	//WebElement headerTxt;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']']")
	WebElement pageTitle;

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void clickOnPushnotification() {
		pushNotification.click();
	
	
	public String getpageTitle() {
		String page_title=pageTitle.getText();
		System.out.println(page_title);
		return page_title;
	}*/	
		


	public void enterTitlefield(String Title) {
		titlefield.sendKeys(Title);
	}

	public void enterDescriptionfield(String descr) {
		descriptionfield.sendKeys(descr);
	}

	public void clickonSend() {
		sendButton.click();
	}

	public void sendPushNotification(String Title, String descr) {
		// getpageTitle();
		enterTitlefield(Title);
		enterDescriptionfield(descr);
		clickonSend();
	}
	
	public String  sucessfullMessage() {
		String message = successMessge.getText();
		System.out.println(message);
		return message;
		
		
	}
	  

}
