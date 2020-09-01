package com.amelia.test.admin;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amelia.page.objects.HomePage;
import com.amelia.page.objects.LoggedInHomePage;
import com.amelia.utility.Base;
import com.amelia.utility.CommonSteps;

public class TestC extends Base {

	public Integer testCaseId = 4;

	public Integer testCaseExternalId;

	public Integer testPlanId = 2;

	public String platform = "Chrome";

	public String status = "PASS";

	public String dropdwon;

	@Test
	@Parameters({ "url" })
	public void verifyLoginFeature(@Optional("https://flipkart.com") String url) throws Throwable {

		HomePage hp = new HomePage(driver);
		CommonSteps cs = new CommonSteps(driver);

		LoggedInHomePage lhp = new LoggedInHomePage(driver);

		// Step 1: Navigate to url
		cs.navigate_url(url);

		// Step 2:Close login modal

		cs.clickOnWebElement(hp.loginPopUpCloseButton);
		Thread.sleep(5000);

		// Step 3: Assert search field is displayed
		cs.clickOnWebElement(lhp.flightNavTab);
		Thread.sleep(5000);
 
		/*
		 * cs.clearTextField(lhp.fromCity); Thread.sleep(2000);
		 * cs.enterText(lhp.fromCity, "gul"); Thread.sleep(2000);
		 * 
		 * cs.selectWebElement(lhp.fromList, "GBI"); Thread.sleep(2000);
		 * 
		 * 
		 * cs.clearTextField(lhp.toCity); Thread.sleep(2000); cs.enterText(lhp.toCity,
		 * "blr"); Thread.sleep(2000);
		 * 
		 * cs.selectWebElement(lhp.fromList, "BLR"); Thread.sleep(2000);
		 */
		/*
		 * cs.clickOnWebElement(lhp.dateButton); Thread.sleep(2000);
		 * 
		 * cs.selectDate(lhp.depDateCalender, driver, "11 Sept 2020");
		 * Thread.sleep(2000);
		 */
	}
}
