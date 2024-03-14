package com.sevenmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	

		public String get_attribute(WebElement element, String attribute) {

			return element.getAttribute(attribute);

		}

		public String get_Css_Property(WebElement element, String cssvalue) {

			return element.getCssValue(cssvalue);

		}

		public List<String> getTextOfElements(List<WebElement> elementArray) {
			List<String> data = new ArrayList<String>();
			for (WebElement element : elementArray) {
				data.add(element.getText());
			}
			return data;
		}

		public static String getTimeStamp1() {
			String timeStamp = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss").format(new Date());
			return timeStamp;

		}

		public static String getRandomFirstName() {
			Faker faker = new Faker(); // faker used to avoid duplication
			return faker.name().firstName();

		}
		
		public static String getRandomlasttName() {
			Faker faker = new Faker(); // faker used to avoid duplication
			return faker.name().lastName();

		}

	}

