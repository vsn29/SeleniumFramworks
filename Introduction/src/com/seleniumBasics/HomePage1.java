package com.seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage1 {
	
	private WebDriver driver;

	public HomePage1(WebDriver driver1) {

		this.driver = driver1;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "hp-widget__sTo")
	public static WebElement destination;

	@FindBy(how = How.XPATH, using = "//span[@class='chNavText darkGreyText'][1]")
	public static WebElement source;


}
