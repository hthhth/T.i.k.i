package com.hth.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hth.pages.HomePage;
import com.hth.pages.SearchResultPage;

public class TestCase2SearchFunction {
	private WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	
	@DataProvider(name="search")
	public Object[][] getSearchData() throws IOException {
		return Utils.getData(1, "Search");
	}
	
	@BeforeClass
	public void setUp() {
		driver = Utils.setUp();
		Utils.navigateToHomePage(driver);
	}
	
	@Test(dataProvider="search")
	public void search(String searchTerm) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		homePage = new HomePage(driver);
		homePage.search(searchTerm);
		
		searchResultPage = new SearchResultPage(driver);
		wait.until(ExpectedConditions.visibilityOf(searchResultPage.getSearchResultElement()));
		Assert.assertNotEquals(searchResultPage.getSearchResultCount(), "0");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
