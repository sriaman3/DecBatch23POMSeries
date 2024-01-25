package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
	
	public String getRandomEmailID() {
		System.out.println(System.currentTimeMillis());
		
		return "testautomation" + System.currentTimeMillis() + "@opencart.com";
		
		//UUID.randomUUID()
		
	}
	
	@BeforeClass
	public void regPageSetUp() {
		
		registerPage = lp.navigateToRegisterPage();
	}
	
	@Test
	public void userRegTest() throws InterruptedException {
		boolean isRegDone =  registerPage.userRegisteration("Rahul", "yadav", getRandomEmailID() , "9876543233", "test@123", "test@123", "yes");
		Thread.sleep(3000);
		Assert.assertTrue(isRegDone);
	}

}
