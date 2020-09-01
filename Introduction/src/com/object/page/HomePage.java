package com.object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver1) {

		this.driver = driver1;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='fromCity']")
	public static WebElement source;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='From']")
	public static WebElement sourceSearch;

	/*
	 * @FindBy(how = How.ID, using = "toCity") public static WebElement
	 * destinationSearch;
	 */
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='To']")
	public static WebElement destinationSearch;
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='chNavIcon appendBottom2 chSprite chHotels']")
	public static WebElement hotels;
	


}
