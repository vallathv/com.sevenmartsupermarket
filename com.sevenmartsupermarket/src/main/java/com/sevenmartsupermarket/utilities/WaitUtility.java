package com.sevenmartsupermarket.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	WebDriverWait wait;

	// Method to wait for a button to be clickable
	public void waitForButtonTobeClickable(WebDriver driver, WebElement element, long time) {
		// Initialize WebDriverWait with the specified time
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	// Method to wait for an element's visibility by its XPath
	public void waitForElementVisibilityByXPath(WebDriver driver, String xpath, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	
	public void waitForElementVisibilityByXPath1(WebDriver driver, WebElement element, long time) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	
	public void waitForElementWithFluentWait(WebDriver driver, long timeoutInSeconds, long pollingEveryInMiliSec, String xpath) {
	    Wait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(timeoutInSeconds)) // Use the timeoutInSeconds parameter
	            .pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)) // Use the pollingEveryInMiliSec parameter for polling frequency
	            .ignoring(NoSuchElementException.class);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
}
