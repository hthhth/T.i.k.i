package com.hth.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT, using="Điện Thoại - Máy Tính Bảng")
	@CacheLookup
	private WebElement linkDienThoaiMayTinhBang;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"__next\"]/div[1]/header/div[3]/div/div[1]/div[2]/div/input")
	@CacheLookup
	private WebElement searchBox;
			
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLinkDienThoaiMayTinhBang() {
		linkDienThoaiMayTinhBang.click();
	}
	
	public void search(String searchTerm) {
		searchBox.clear();
		searchBox.sendKeys(searchTerm);
		searchBox.sendKeys(Keys.ENTER);
	}
}
