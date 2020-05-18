import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Selenium WebDriver Basics: Section 1- Section 5

public class Demo {

	public static void main(String[] args) {

		// Create Driver object for Chrome Browser

		// We will implement the methods of WebDriver

		// For Ex: Classname name = ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCourse\\chromedriver_win32 (4)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Opens the google home page
		driver.get("http://google.com");

		// Validates that the page title is correct
		System.out.println(driver.getTitle());

		// Validates if the your landed on the correct page
		System.out.println(driver.getCurrentUrl());

		// Gets the page source
		System.out.println(driver.getPageSource());

		// Opens the yahoo page
		driver.get("http://yahoo.com");

		// It navigates back to the google page
		driver.navigate().back();

		// forward to the yahoo page again
		driver.navigate().forward();

		driver.close();

	}

}
