package com.sevenmartsupermarket.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.Excel;

public class DataProviders {

	Excel excel = new Excel();

	@DataProvider(name = "sevenmartsupermarket")
	public Object[][] login() {
		return new Object[][] { { "Tonya", "Jijo" }, { "Garth", "Jijo" }, { "Hank", "Jijo" } };
	}

	@DataProvider(name = "multilogin")
	public Object[][] adminlogin()

	{
		excel.setExcelFile("Login", "adminusers");

		return excel.getMultidimentionalData(2, 2);

	}

}
