package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.opencart.contants.AppConstants;
import org.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	//WebDriver, By locators, action method
	//concept of encapsulation
	//Page Object Model- Design Pattern
	
	private WebDriver driver;
	private ElementUtil eleUtils;
	
	private By userName = By.xpath("//*[@id='input-email']");
	private By pass = By.xpath("//*[@id='input-password']");
	private By forgotPass = By.xpath("(//*[text()='Forgotten Password'])[1]");
	private By loginBtn = By.xpath("//*[@value='Login']");
	private By registerLink = By.xpath("(//a[text()='Register'])[2]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtils = new ElementUtil(this.driver);
	}
	
	public String getLoginPageTitle() {
		return eleUtils.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.MEDIUM_DEFAULT_WAIT);
	}
	
	public String getLoginPageUrl() {
		return eleUtils.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
	}
	
	public boolean isForgotPassLinkExist() {
		return eleUtils.getElement(forgotPass).isDisplayed();
	}
	
	public boolean doLogin(String userName, String pass) {
		eleUtils.waitForVisibilityOfElement(this.userName, AppConstants.SHORT_DEFAULT_WAIT).sendKeys(userName);
		eleUtils.doSendKeys(this.pass, pass);
		eleUtils.doClick(loginBtn);
		return true;
	}
	
	public RegisterPage navigateToRegisterPage() {
		
		eleUtils.doClickWithWait(registerLink, AppConstants.MEDIUM_DEFAULT_WAIT);	
		return new RegisterPage(driver);
	}
	

}
