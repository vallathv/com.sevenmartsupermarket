package com.sevenmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Select select;
	Actions act;
	
	
	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectIndex(WebElement element, int index) {
	 select = new Select(element);
	select.selectByIndex(index);
	
}

	public String selectValue(WebElement element, String value) {
		 select = new Select(element);
		select.selectByValue(value);
		return value;
		
	}
	public void selectvisibletext(WebElement element, String text) {
		 select = new Select(element);
		select.selectByVisibleText(text);
	}	
	
	public void mouseMove(WebElement element) {
		
		act =new Actions(driver);
		act.moveToElement(element).build().perform();
		
		
	}
	
	public void scrolldown(WebElement element) {
		
		JavascriptExecutor js= (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].scrollIntoView();",element);
		//js.executeScript("arguments[0].click();",element);
		
	}
	

	
	

}