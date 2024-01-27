package org.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qa.opencart.exception.FrameworkException;

public class DriverFactory {

	WebDriver driver;
	Properties prop;

	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");

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
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	public Properties init_prop() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	

}
