package com.hth.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	public static final String BASE_URL="https://tiki.vn/";
	static WebDriver setUp() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		return driver;

		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
			
	
	
	static void navigateToHomePage(WebDriver driver) {
		driver.get(BASE_URL);
	}
	
	public static Object[][] getData(int numberOfHeaderRows, String sheetName) throws IOException {
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath + "/Data/Data.xlsx", sheetName);
		Object[][] data = new Object[excel.getRowCount()-numberOfHeaderRows][excel.getColCount()];
		for (int i=0; i<excel.getRowCount()-numberOfHeaderRows; i++) {
			for (int j=0; j<excel.getColCount(); j++) {
				data[i][j] = excel.getCellDataString(i+numberOfHeaderRows, j);
			}
		}
		return data;
	}
}
