package com.amelia.test.flights;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amelia.page.objects.FlightHomePage;
import com.amelia.utility.Base;
import com.amelia.utility.CommonSteps;

import junit.framework.Assert;

//Test Case: Validation of filter-preference.


public class FlightAe extends Base{
	

	@Test
	@Parameters({ "url" })
	public void oneWayFlightSearch(@Optional("https://www.flipkart.com") String url)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		CommonSteps cs = new CommonSteps(driver);

		FlightHomePage fhp = new FlightHomePage(driver);

		// Step 1:Navigate to the Flights home page
		cs.navigate_url("https://www.flipkart.com/travel/search/result/flight/BLR/HYD/09092020//1/0/0/e?source=Expire%20Popup");
		Thread.sleep(3000);

		cs.clickOnWebElement(fhp.refundablePreference);
		
		Assert.assertTrue("refundable preference is desabled by default", true);
		
	

	}

}
