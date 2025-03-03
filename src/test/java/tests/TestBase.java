package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import core.WebDriverFactory;

public class TestBase {
	protected WebDriver driver;
	
	@BeforeMethod
	@Parameters({ "broswer" })
	public void beforeMethod(@Optional("chrome") String broswer) {
		driver = WebDriverFactory.getDriver(broswer);
		System.out.println(
				String.format("WebDriver started by Thread: '%s' ---> '%s'", Thread.currentThread().getId(), driver));
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println(
				String.format("WebDriver closed by Thread: '%s' ---> '%s'", Thread.currentThread().getId(), driver));
		WebDriverFactory.quitDriver();
	}
}
