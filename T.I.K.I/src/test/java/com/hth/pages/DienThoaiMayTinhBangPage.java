package com.hth.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DienThoaiMayTinhBangPage {
	private WebDriver driver;
	
	@FindBy(how=How.XPATH, using="/html/body/div[10]/div/div[2]/div[4]/div[2]/div[1]/a/div[1]/span/img")
	@CacheLookup
	private WebElement firstProduct;
	
	@FindBy(how=How.ID, using="onesignal-popover-cancel-button")
	@CacheLookup
	private WebElement buttonBoQuaPopUp;
	
	public DienThoaiMayTinhBangPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickButtonBoQua() {
		buttonBoQuaPopUp.click();
	}
	
	public void clickFirstProduct() {
		firstProduct.click();
	}

	public WebElement getFirstProduct() {
		return firstProduct;
	}

	public WebElement getButtonBoQuaPopUp() {
		return buttonBoQuaPopUp;
	}
	
	
	
}
