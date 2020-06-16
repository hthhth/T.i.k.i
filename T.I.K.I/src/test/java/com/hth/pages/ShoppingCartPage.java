package com.hth.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	private WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//*[@class='cart__submit']")
	@CacheLookup
	private WebElement buttonTienHanhDatHang;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickButtonTienHanhDatHang() {
		buttonTienHanhDatHang.click();
	}

	public WebElement getButtonTienHanhDatHang() {
		return buttonTienHanhDatHang;
	}
	
	
}
