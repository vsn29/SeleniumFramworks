package com.amelia.page.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlightHomePage {

	public WebDriver driver;

	public FlightHomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@class='_16qL6K HDWLFe _2YVEL1 _1qpQfA _366U7Q']")
	public WebElement fromCity;

	@FindBy(how = How.XPATH, using = "//div[@class='_3I5ZTr']")
	public List<WebElement> fromList;

	@FindBy(how = How.XPATH, using = "//div[@class='_3I5ZTr']")
	public List<WebElement> toList;

	@FindBy(how = How.XPATH, using = "//input[@class='_16qL6K HDWLFe _2YVEL1 _1ljU-s _366U7Q']")
	public WebElement toCity;

	@FindBy(how = How.XPATH, using = "//input[@name='0-datefrom']")
	public WebElement dateButton;

	@FindBy(how = How.XPATH, using = "//div[@class='_1fdqhw _3SJC02 _23p86s _2N4d5o _2k99yz']")
	public WebElement depDateCalender;

	@FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA FGyeEh _1eFTEo']")
	public WebElement searchButton;

	@FindBy(how = How.XPATH, using = "//div[@class='price']/div[@class='c-price-display u-text-ellipsis '][1]")
	public WebElement priceText;

	@FindBy(how = How.CSS , using = "input#ONE_WAY")
	public WebElement oneWaybutton;
	
	@FindBy(how = How.CSS , using = "input#ROUND_TRIP")
	public WebElement roundWaybutton;

	
	@FindBy(how = How.XPATH , using = "(//div[@class='left-wing']/div[@class='time'])[1]")
	public WebElement firstRowDepTime;
	
	@FindBy(how = How.XPATH , using = "(//div[@class='right-wing']/div[@class='time'])[1]")
	public WebElement firstRowArrivalTime;
	
	@FindBy(how = How.XPATH , using = "(//span[@class='c-switch switch-off'])[1]")
	public WebElement nonStopPreference;
	
	@FindBy(how = How.XPATH , using = "(//span[@class='u-ib u-rfloat'])[2]")
	public WebElement refundablePreference;
	
	
	
	
	
}
