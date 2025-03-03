package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.enums.NavigationBar;

public class HomePageTest extends TestBase {
	private HomePage homePage;
	private LoginPage loginPage;
	
	@Test
	public void test001() throws InterruptedException {
		driver.get("https://www.demoblaze.com/");
		
		homePage = new HomePage(driver);
		homePage.clickOnNavigationBar(NavigationBar.HOME.toString());
		loginPage = homePage.clickOnNavigationBar(NavigationBar.LOG_IN.toString());
		loginPage.clickOnCloseButton();
	}
}
