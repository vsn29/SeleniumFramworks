package com.amelia.page.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoggedInHomePage {

	public WebDriver driver;

	public LoggedInHomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flight')]")
	public WebElement flightNavTab;

	@FindBy(how = How.XPATH, using = "//input[@name='0-datefrom']")
	public WebElement dateButton;

	
	@FindBy(how = How.XPATH, using = "//button[@class='_3ozJ3d _29mVy- _2xyFzd']")
	public WebElement date;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_1fdqhw _3SJC02 _23p86s _2N4d5o _2k99yz']")
	public WebElement depDateCalender;
	
	
	@FindBy(how = How.XPATH, using = "//table[@class='_1pN9kv'][1]")
	public WebElement currMonthTable;
	
	
	@FindBy(how = How.XPATH, using = "//table[@class='_1pN9kv'][2]")
	public WebElement nextMonthTable;
    
	
	
	
	
}
