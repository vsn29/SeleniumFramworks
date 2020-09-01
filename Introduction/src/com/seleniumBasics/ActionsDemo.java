package com.seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
	
	
	public static void main(String[] args) {
		
		
		
		// System Property for Chrome Driver
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCourse\\chromedriver_win32\\chromedriver.exe");

				// Instantiate a ChromeDriver class.
				WebDriver driver = new ChromeDriver();

				// Launch Website
				driver.get("https://www.amazon.com/");

				driver.manage().window().maximize();
				
				Actions a = new Actions(driver);
				
				// Moves to specific element
				a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
				
				driver.close();

		
		
	}

}
