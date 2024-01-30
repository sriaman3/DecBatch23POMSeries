package org.qa.opencart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.qa.opencart.base.BaseTest;
import org.qa.opencart.contants.AppConstants;
import org.qa.opencart.factory.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	
	private static final Logger log = LogManager.getLogger(DriverFactory.class);
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		System.out.println(lp.getLoginPageTitle());
		log.info("this is testing of login page title");
		Assert.assertEquals(lp.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void loginPageCurrentUrlTest() {
		log.info("this is testing of login page URL");
		System.out.println(lp.getLoginPageUrl());
		Assert.assertTrue(lp.getLoginPageUrl().contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Test(priority = 3)
	public void forgotPasswordLinkExistTest() {
		
		Assert.assertTrue(lp.isForgotPassLinkExist());
	}
	
	@Test(priority = 4)
	public void loginTest() {
		log.info("login to the application");
		accountPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		 Assert.assertTrue(accountPage.getAccountPageUrl().contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION));
	}

}
