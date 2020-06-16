package com.hth.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	private WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//*[@name='results-count-with-execution-time']")
	@CacheLookup
	private WebElement searchResultCount;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchResultCount() {
		return searchResultCount.getText().split(" ")[0];
	}
	
	public WebElement getSearchResultElement() {
		return searchResultCount;
	}
	
}
