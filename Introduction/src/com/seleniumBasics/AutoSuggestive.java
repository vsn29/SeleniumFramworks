package com.seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.object.page.HomePage;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCourse\\chromedriver_win32\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();

		// Launch Website
		driver.get("https://www.makemytrip.com"); // URL in the browser

		Thread.sleep(5000);

		HomePage homepage = new HomePage(driver);

		// WebElement source = driver.findElement(By.xpath("//span[@class='chNavText
		// darkGreyText'][1]"));

		homepage.source.click();
		homepage.sourceSearch.sendKeys("MUM");
		homepage.sourceSearch.sendKeys(Keys.ARROW_DOWN);
		homepage.sourceSearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// WebElement destination = driver.findElement(By.id("hp-widget__sTo"));
		//homepage.destinationSearch.click();
		homepage.destinationSearch.sendKeys("MAA");
		Thread.sleep(2000);
		homepage.destinationSearch.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		homepage.destinationSearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		homepage.hotels.click();

		// Close Browser

		driver.close();
	}

}
