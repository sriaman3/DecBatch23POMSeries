package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
	
	public String getRandomEmailID() {
		
		return "testautomation" + System.currentTimeMillis() + "@opencart.com";
		
		//UUID.randomUUID()
		
	}
	
	@BeforeClass
	public void regPageSetUp() {
		
		registerPage = lp.navigateToRegisterPage();
	}
	
	
	/**
	 * using the excel
	 * @return
	 */
	
	@DataProvider
	public Object[][] getRegTestExcelData() {
		return ExcelUtil.getExcelData("register");
	}
	/**
	 * using the dataProvider only
	 * @return
	 */
	@DataProvider
	public Object[][] getRegDataUsingDataProvider() {
		
		return new Object[][] {
				{"Sujata", "Jain","9876543233", "test@123", "test@123", "yes"},
				{"Ashish", "Srivatava", "9876987233", "test@123","test@123", "yes"},
				{"Anita", "Sharma", "9876987233", "test@123","test@123", "yes"}
		};
		
	}
	
	@Test(dataProvider = "getRegTestExcelData")
	public void userRegTestUsingDP(String firstName, String lastName, String telephone, String password,
			 String confirmpassword, String subscribe) throws InterruptedException {
		System.out.println(getRandomEmailID());
		boolean isRegDone =  registerPage.userRegisteration(firstName, lastName, getRandomEmailID() ,telephone, password, confirmpassword, subscribe);
		Thread.sleep(3000);
		Assert.assertTrue(isRegDone);
		
	}
	
	
	
	/**
	 * this method is without dataprovider
	 * @throws InterruptedException
	 */
	
	@Test(enabled = false)
	public void userRegTest() throws InterruptedException {
		boolean isRegDone =  registerPage.userRegisteration("Rahul", "yadav", getRandomEmailID() , "9876543233", "test@123", "test@123", "yes");
		Thread.sleep(3000);
		Assert.assertTrue(isRegDone);
	}

}
