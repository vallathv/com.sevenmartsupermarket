package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties = new Properties();

	public Base() {
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Initializing browser **/
	public void initailize(String browser, String url) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		driver.manage().deleteAllCookies();

	}
@Parameters("browser")
	@BeforeMethod (enabled=false)
	public void launchBrowser(String browser) {
		//String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initailize(browser, url);
		

	}

@BeforeMethod (enabled=true,alwaysRun=true)
public void launchBrowser() {
	String browser = properties.getProperty("browser");
	String url = properties.getProperty("url");
	initailize(browser, url);
	
}
	@AfterMethod
	public void terminatesession(ITestResult itestresult) { //ITestResult is Testng listner
	if (itestresult.getStatus()==ITestResult.FAILURE)	{
		
		Screenshot.takescreenshot(driver, itestresult.getName());
	}
		
	}
	@AfterMethod
	public void closebrowser() {
		
		driver.close();
	}


}
