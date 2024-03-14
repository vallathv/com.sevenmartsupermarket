package com.sevenmartsupermarket.utilities;

import java.io.File;

import java.text.SimpleDateFormat;
import java.text.DateFormat;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenmartsupermarket.constants.Constants;

public class Screenshot {
	
	
	static TakesScreenshot screenshot;//interface used to capture screenshots  
	
	public static void takescreenshot(WebDriver driver, String imageName) {
		try {
			screenshot = (TakesScreenshot) driver;
			File file = screenshot.getScreenshotAs(OutputType.FILE); // screenshot is capture here.
			//code for time stamp
		//	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String timeStamp = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss").format(new Date());
			String path=Constants.SCREENSHOT_FILE_PATH+imageName+"-"+timeStamp +".png";
			File destination = new File (path);
			FileHandler.copy(file, destination);
			
			
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}
}