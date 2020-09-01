package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagefactory.HomePage;
import pagefactory.LoginPage;

public class TestLoginWithPageFactory {

	String driverPath = "C:\\geckodriver.exe";

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	@BeforeTest

	public void setup() {

		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCourse\\chromedriver_win32\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();

		// Launch Website
		driver.get("https://www.amazon.com/");

		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/V4/");

	}

	/**
	 * 
	 * This test go to http://demo.guru99.com/V4/
	 * 
	 * Verify login page title as guru99 bank
	 * 
	 * Login to application
	 * 
	 * Verify the home page using Dashboard message
	 * 
	 */

	@Test(priority = 0)

	public void test_Home_Page_Appear_Correct() {

		// Create Login Page object

		objLogin = new LoginPage(driver);

		// Verify login page title

		String loginPageTitle = objLogin.getLoginTitle();

		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

		// login to application

		objLogin.loginToGuru99("mgr123", "mgr!23");

		// go the next page

		objHomePage = new HomePage(driver);

		// Verify home page

		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

	}

}
