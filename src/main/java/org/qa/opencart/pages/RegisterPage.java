package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.opencart.contants.AppConstants;
import org.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil eleUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtils = new ElementUtil(this.driver);
	}
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By successMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	public boolean userRegisteration(String firstName, String lastName, String email, String telephone, String password,
			 String confirmpassword, String subscribe) {
		
		eleUtils.waitForVisibilityOfElement(this.firstName, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(firstName);
		eleUtils.doSendKeys(this.lastName, lastName);
		eleUtils.doSendKeys(this.email, email);
		eleUtils.doSendKeys(this.telephone, telephone);
		eleUtils.doSendKeys(this.password, password);
		eleUtils.doSendKeys(this.confirmpassword, password);
		
		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtils.doClick(this.subscribeYes);
		} else {
			eleUtils.doClick(this.subscribeYes);
		}
		
		eleUtils.doClick(agreeCheckBox);
		eleUtils.doClick(continueButton);
		
		String message = eleUtils.doElementGetText(successMessg);
		
		if(message.contains(AppConstants.USER_REGISTER_SUCCESS_MESSG)) {
			eleUtils.doClick(logoutLink);
			eleUtils.doClick(registerLink);
			return true;
		}
		
		return false;
	}

}
