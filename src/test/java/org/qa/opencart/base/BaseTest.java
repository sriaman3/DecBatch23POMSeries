package org.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.opencart.factory.DriverFactory;
import org.qa.opencart.pages.AccountPage;
import org.qa.opencart.pages.LoginPage;
import org.qa.opencart.pages.RegisterPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected WebDriver driver;
	protected DriverFactory df;
	protected LoginPage lp;
	protected RegisterPage registerPage;
	protected AccountPage accountPage;
	protected Properties prop;
	
	@BeforeTest
	public void setUp() {
		
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		lp = new LoginPage(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
