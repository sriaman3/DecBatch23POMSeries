package org.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.qa.opencart.factory.DriverFactory;
import org.qa.opencart.pages.LoginPage;
import org.qa.opencart.pages.RegisterPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	protected DriverFactory df;
	protected LoginPage lp;
	protected RegisterPage registerPage;
	
	@BeforeTest
	public void setUp() {
		
		df = new DriverFactory();
		driver = df.init_driver("Edge");
		lp = new LoginPage(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
