package com.amelia.test.admin;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.amelia.page.objects.HomePage;
import com.amelia.utility.Base;
import com.amelia.utility.CommonSteps;
import com.amelia.utility.TestLinkIntegration;

public class TestA extends Base {

	public Integer testCaseId = 4;

	public Integer testCaseExternalId;

	public Integer testPlanId = 2;

	public String platform = "Chrome";

	public String status = "PASS";

	@Test
	@Parameters({ "url" })
	public void verifySearchFeature(@Optional("https://flipkart.com") String url) throws Throwable {

		HomePage hp = new HomePage(driver);
		CommonSteps cs = new CommonSteps(driver);

		String loginButtonName;

		String loginAttributeValue;

		String cartLink;
		int a = 30;

		// Step 1: Navigate to url
		cs.navigate_url(url);

		// Step 2:Close login modal
		cs.clickOnWebElement(hp.loginPopUpCloseButton);
		Thread.sleep(5000);

		// Step 3: Assert search field is displayed
		assertTrue(cs.isElementDisplayed(hp.searchText));

		// Step 4: Verify login button text
		loginButtonName = cs.getTextOfWebElement(hp.loginLink);
		System.out.println(loginButtonName);

		cartLink = cs.getTextOfWebElement(hp.cartLink);
		System.out.println(cartLink);

		loginAttributeValue = cs.getAttributeValueOfWebElement(hp.cartLink, "class");
		System.out.println("Tag value of Cartlink :" + loginAttributeValue);

		loginAttributeValue = cs.getAttributeValueOfWebElement(hp.cartLink, "class");
		System.out.println("Tag value of Cartlink :" + loginAttributeValue);

		Thread.sleep(5000);

		cs.mouseHoverOnWebElement(hp.mouseHover, driver);
		// System.out.println(cs.sumOfTwoNumbers(add, sub));

		// Step 4: Enter the test in search field and then click search button
		cs.enterText(hp.searchText, "phone");
		Thread.sleep(5000);

		TestLinkIntegration test1 = new TestLinkIntegration();

		// test1.updateTestCaseResult(testCaseId, testCaseExternalId, testPlanId,
		// platform, status);

	}

}
