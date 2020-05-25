package com.seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceAppTest {

	public static void main(String[] args) throws InterruptedException {
		

		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCourse\\chromedriver_win32\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();

		// Launch Website
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.manage().window().maximize();

		Thread.sleep(2000);

	}
}
