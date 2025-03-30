package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver(String browser) {
		if (driver.get() == null) {
			switch (browser.toLowerCase()) {
			case "chrome":
				driver.set(new ChromeDriver());
				break;
			case "firefox":
				driver.set(new FirefoxDriver());
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
		}
		System.out.println("WebDriver is on Thread: " + Thread.currentThread().getId());
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
