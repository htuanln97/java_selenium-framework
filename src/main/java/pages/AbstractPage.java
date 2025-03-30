package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	protected WebDriver driver;
	private WebDriverWait wait; // Keep this private to enforce lazy initialization
	
	private final String linkNavigationBar = "//a[@class='nav-link'][normalize-space(text()) = '%s']";

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		System.out.println(this.getClass().getName() + " - WebDriver is on Thread: " + Thread.currentThread().getId()
				+ "---> " + this.driver);
	}
	
	public WebDriverWait getWait() {
        if (wait == null) { // Lazy initialization
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        }
        return wait;
    }

	@SuppressWarnings("unchecked")
	public <T extends AbstractPage> T clickOnNavigationBar(final String name) {
		String locator = String.format(linkNavigationBar, name);
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
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
