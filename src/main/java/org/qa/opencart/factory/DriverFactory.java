package org.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qa.opencart.exception.FrameworkException;

public class DriverFactory {

	WebDriver driver;

	public WebDriver init_driver(String browserName) {

		switch (browserName.toLowerCase().trim()) {
		case "chrome":

			driver = new ChromeDriver();

			break;

		case "edge":

			driver = new EdgeDriver();

			break;

		case "firefox":

			driver = new FirefoxDriver();

			break;

		default:
			System.out.println("please pass the right browser name...."+ browserName);
			throw new  FrameworkException("no browser found");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		return driver;
	}

}
