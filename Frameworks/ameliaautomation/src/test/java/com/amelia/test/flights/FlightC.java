 package com.amelia.test.flights;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amelia.page.objects.FlightHomePage;
import com.amelia.page.objects.HomePage;
import com.amelia.page.objects.LoggedInHomePage;
import com.amelia.utility.Base;
import com.amelia.utility.CommonSteps;
import com.amelia.utility.Constants;
import com.amelia.utility.Database;
import com.amelia.utility.ExcelRead;

public class FlightC extends Base {

	@Test
	@Parameters({ "url" })
	public void oneWayFlightSearch(@Optional("https://www.flipkart.com") String url)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		HomePage hp = new HomePage(driver);
		CommonSteps cs = new CommonSteps(driver);

		LoggedInHomePage lhp = new LoggedInHomePage(driver);
		FlightHomePage fhp = new FlightHomePage(driver);

		ExcelRead er = new ExcelRead();

		Database db = new Database();

		String price;
		
		boolean radioButton;

		String fromLocation = db.getFromLocation();

		String toLocation = db.getToLocation();

		String fromMonth = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightA", 3);

		// String fromDay = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1",
		// "FlightA", 4);

		String toMonth = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightA", 4);

		// String toDay = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1",
		// "FlightA", 6);

		// Step 1:Navigate to the Flights home page
		cs.navigate_url("https://www.flipkart.com/travel/flights?otracker=nmenu_Flights");
		Thread.sleep(3000);

		cs.clearTextField(fhp.fromCity);
		cs.enterText(fhp.fromCity, fromLocation);
		Thread.sleep(2000);
		cs.selectWebElement(fhp.fromList, fromLocation);
		Thread.sleep(2000);
		// Select to city
		cs.clearTextField(fhp.toCity);
		cs.enterText(fhp.toCity, toLocation);
		Thread.sleep(2000);
		cs.selectWebElement(fhp.toList, toLocation);
		Thread.sleep(2000);

		// Step 2: Click on departure date field
		cs.clickOnWebElement(fhp.dateButton);
		Thread.sleep(3000);

		// Step 3: Select the departure date
		cs.selectDate(fhp.depDateCalender, driver, fromMonth, "29");
		Thread.sleep(3000);

		cs.clickOnWebElement(fhp.searchButton);
		Thread.sleep(5000);

		price = cs.getTextOfWebElement(fhp.priceText);
		System.out.println("Price of the flight : " + price);

		// Verify
		assertEquals(price, "2790");
		
		
		

	}

}
