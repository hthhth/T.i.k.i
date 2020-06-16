package com.hth.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hth.pages.DienThoaiMayTinhBangPage;
import com.hth.pages.HomePage;
import com.hth.pages.ProductDetailsPage;
import com.hth.pages.ShoppingCartPage;

public class TestCase1AddToCart {
	private WebDriver driver;
	private HomePage homePage;
	private DienThoaiMayTinhBangPage dienThoaiMayTinhBangPage;
	private ProductDetailsPage productDetailsPage;
	private ShoppingCartPage shoppingCartPage;
	
	@BeforeClass
	public void setUp() {
		driver = Utils.setUp();
		Utils.navigateToHomePage(driver);
	}
	
	@Test
	public void addProductToCart() {
		WebDriverWait wait = new WebDriverWait(driver, 8);
		homePage = new HomePage(driver);
		homePage.clickLinkDienThoaiMayTinhBang();
		
		dienThoaiMayTinhBangPage = new DienThoaiMayTinhBangPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(dienThoaiMayTinhBangPage.getButtonBoQuaPopUp()));
		dienThoaiMayTinhBangPage.clickButtonBoQua();
		dienThoaiMayTinhBangPage.clickFirstProduct();
		
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.clickChonMua();
		productDetailsPage.clickGioHang();
		
		shoppingCartPage = new ShoppingCartPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCartPage.getButtonTienHanhDatHang()));
		shoppingCartPage.clickButtonTienHanhDatHang();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
