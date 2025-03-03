package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.enums.NavigationBar;

public class LoginPage extends AbstractPage {
	
	private final String closeBtn = "//button[@type='button'][text()='Close'][./ancestor::div[@id='logInModal']]";

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnCloseButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(closeBtn))).click();
	}
}
