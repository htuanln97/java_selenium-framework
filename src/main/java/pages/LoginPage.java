package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {
	
	private final String closeBtn = "//button[@type='button'][text()='Close'][./ancestor::div[@id='logInModal']]";

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnCloseButton() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(closeBtn))).click();
	}
}
