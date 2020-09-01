package com.amelia.test.flights;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amelia.page.objects.FlightHomePage;
import com.amelia.utility.Base;
import com.amelia.utility.CommonSteps;
import com.amelia.utility.Constants;
import com.amelia.utility.Database;
import com.amelia.utility.ExcelRead;

import junit.framework.Assert;

public class FlightAb extends Base {

	@Test
	@Parameters({ "url" })
	public void oneWayFlightSearch(@Optional("https://www.flipkart.com") String url)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		CommonSteps cs = new CommonSteps(driver);

		FlightHomePage fhp = new FlightHomePage(driver);

		ExcelRead er = new ExcelRead();

		String fromLocation = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightAb", 1);
		String toLocation = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightAb", 2);
		String expectedDepTime = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightAb", 7);
		String expectedArrivalTime = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightAb", 8);
		String fromMonth = er.readTestCaseData("C:\\", Constants.TEST_DATA, "Sheet1", "FlightAb", 3);
		String deptTime;
		String arrivalTime;

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
		cs.selectDate(fhp.depDateCalender, driver, fromMonth, "1");
		Thread.sleep(3000);

		cs.clickOnWebElement(fhp.searchButton);
		Thread.sleep(5000);

		deptTime = cs.getTextOfWebElement(fhp.firstRowDepTime);

		Assert.assertEquals(deptTime, expectedDepTime);

		arrivalTime = cs.getTextOfWebElement(fhp.firstRowArrivalTime);

		Assert.assertEquals(arrivalTime, expectedArrivalTime);

	}
}
