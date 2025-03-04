package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	protected WebDriver driver;

	private final String linkNavigationBar = "//a[@class='nav-link'][normalize-space(text()) = '%s']";

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.getClass().getName() + " - WebDriver is on Thread: " + Thread.currentThread().getId()
				+ "---> " + this.driver);
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractPage> T clickOnNavigationBar(final String name) {
		String locator = String.format(linkNavigationBar, name);
		driver.findElement(By.xpath(locator)).click();
		switch (name) {
		case "Home":
			return (T) new HomePage(driver);
		case "Log in":
			return (T) new LoginPage(driver);
		default:
			throw new IllegalArgumentException("Unexpected value: " + name);
		}
	}

}
