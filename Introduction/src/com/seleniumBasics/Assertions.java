//Asserrtion in Selenium
//================================================================================
//Points to Remember :

//1) Assertion determines the state of the application whether it is the same what we are expecting or not.

//2)If the assertion fails, then the test case is failed and stops the execution.

//3)To use the Assertion in Web Driver, you need to download the Testng jar file and add it to the eclipse

//4)There are two types of Assertion:

//  a) Hard Assertion

//  b) Soft Assertion

// Syntax of AssertFalse() method is :
//-----------------------------------------

// Assert.AssertFalse(condition);  


// Syntax of AssertTrue() method is :
//------------------------------------------

// Assert.AssertTrue(condition);  


package com.seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assertions {
	
	
	public static void main(String[] args) {
		
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCourse\\chromedriver_win32\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();

		driver.get("http://spicejet.com"); //URL in the browser

		//To check the false condition
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		// Select the checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		//Prints the checkbox selected
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//Checks for the True Condition
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		
		//Close Browser
		  
		  driver.close();
	}
	
	
	


}
