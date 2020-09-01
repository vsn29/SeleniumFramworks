package com.amelia.test.flights;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amelia.page.objects.FlightHomePage;
import com.amelia.page.objects.HomePage;
import com.amelia.page.objects.LoggedInHomePage;
import com.amelia.utility.Base;
import com.amelia.utility.CommonSteps;
import com.amelia.utility.Constants;
import com.amelia.utility.ExcelRead;

public class FlightB extends Base {

	@Test
	@Parameters({ "url" })
	public void oneWayFlightSearch(@Optional("https://www.flipkart.com") String url)
			throws InterruptedException, IOException {

		HomePage hp = new HomePage(driver);
		CommonSteps cs = new CommonSteps(driver);

		LoggedInHomePage lhp = new LoggedInHomePage(driver);
		FlightHomePage fhp = new FlightHomePage(driver);

		ExcelRead er = new ExcelRead();

		String price;

		String fromLocation = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightA", 1);

		String toLocation = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightA", 2);

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

		// Select to city
		cs.clearTextField(fhp.toCity);
		cs.enterText(fhp.toCity, toLocation);
		Thread.sleep(2000);
		cs.selectWebElement(fhp.toList, toLocation);

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

		// Veri
		assertEquals(price, "1995");

	}

}
