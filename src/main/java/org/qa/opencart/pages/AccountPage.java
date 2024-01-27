package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.opencart.contants.AppConstants;
import org.qa.opencart.utils.ElementUtil;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil eleUtils;
	
	private By headerName = By.xpath("//h2[normalize-space()='My Account']");
	private By logout = By.cssSelector("aside[id='column-right'] a:nth-child(1)");
	
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtils = new ElementUtil(this.driver);
	}
	
	public String getAccountPageTitle() {
		return eleUtils.waitForTitleIs(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
	}
	
	public String getAccountPageUrl() {
		return eleUtils.waitForURLContains(AppConstants.ACCOUNT_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
	}
	
	public String getAccountHeader() {
		return eleUtils.doElementGetText(headerName);
	}
	

}
