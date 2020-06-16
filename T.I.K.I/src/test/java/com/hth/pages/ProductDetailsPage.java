package com.hth.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	private WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//*[@class='btn btn-add-to-cart']")
	@CacheLookup
	private WebElement buttonChonMua;
	
	@FindBy(how=How.XPATH, using="//*[@class='Userstyle__CartItem-sc-6e6am-13 gjPwhU']/a/div/span")
	@CacheLookup
	private WebElement gioHang;
	
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickChonMua() {
		buttonChonMua.click();
	}
	
	public void clickGioHang() {
		gioHang.click();
	}
}
