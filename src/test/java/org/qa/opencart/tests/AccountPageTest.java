package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.contants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void accountSetup() {
		accountPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accPageTitleTest() {
		String title = accountPage.getAccountPageTitle();
		Assert.assertEquals(title, AppConstants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void accPageHeaderTest() {
		
		String header = accountPage.getAccountHeader();
		
		System.out.println(header);
		
		Assert.assertEquals(header, AppConstants.ACCOUNT_PAGE_HEADER);
		
	}
	

}
