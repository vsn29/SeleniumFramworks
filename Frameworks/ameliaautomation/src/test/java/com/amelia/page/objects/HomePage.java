package com.amelia.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@class='LM6RPg'][@type='text']")
	public WebElement searchText;

	@FindBy(how = How.XPATH, using = "//button[@class='vh79eN']")
	public WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _29YdH8']")
	public WebElement loginPopUpCloseButton;
	
	@FindBy(how = How.XPATH, using = "//a[@class='_3Ep39l']")
	public WebElement loginLink;
	
	@FindBy(how = How.XPATH, using = "//a[@class='_3ko_Ud']")
	public WebElement cartLink;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_2aUbKa']")
	public WebElement mouseHover;
	
	
	
	
	
	
	

	


	
	
	


}




