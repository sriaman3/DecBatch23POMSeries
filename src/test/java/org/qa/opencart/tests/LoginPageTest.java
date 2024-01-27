package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.contants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		System.out.println(lp.getLoginPageTitle());
		Assert.assertEquals(lp.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void loginPageCurrentUrlTest() {
		System.out.println(lp.getLoginPageUrl());
		Assert.assertTrue(lp.getLoginPageUrl().contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Test(priority = 3)
	public void forgotPasswordLinkExistTest() {
		
		Assert.assertTrue(lp.isForgotPassLinkExist());
	}
	
	@Test(priority = 4)
	public void loginTest() {
		
		accountPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		 Assert.assertTrue(accountPage.getAccountPageUrl().contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION));
	}

}
