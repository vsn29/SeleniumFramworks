package com.amelia.test.flights;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amelia.page.objects.FlightHomePage;
import com.amelia.utility.Base;
import com.amelia.utility.CommonSteps;

public class FlightAa extends Base {

	@Test
	@Parameters({ "url" })
	public void oneWayFlightSearch(@Optional("https://www.flipkart.com") String url)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		CommonSteps cs = new CommonSteps(driver);

		FlightHomePage fhp = new FlightHomePage(driver);

		boolean oneWayButton;
		
		boolean roundTripButton;

		// Step 1:Navigate to the Flights home page
		cs.navigate_url("https://www.flipkart.com/travel/flights?otracker=nmenu_Flights");
		Thread.sleep(3000);

		oneWayButton = cs.isSelected(fhp.oneWaybutton, driver);

		System.out.println("One Way Trip button is selected.............." + oneWayButton);

		// Verify The default radio Button is selected

		Assert.assertTrue(oneWayButton, "Verified the button is selected");

		roundTripButton=cs.isSelected(fhp.roundWaybutton, driver);
		
		System.out.println("Verified the Round Trip Button.............." + roundTripButton);
		
		Assert.assertFalse(roundTripButton, "Verified the RoundTrip button");


	}
}
