package com;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FbLoginTest extends TestBase {

	@Test
	public void init() throws Exception {
		// driver.get("https://www.facebook.com");
		FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
		loginpage.setEmail("your-username");
		loginpage.setPassword("your-password");
		loginpage.clickOnLoginButton();
		FbHomePage homepage = PageFactory.initElements(driver, FbHomePage.class);
		homepage.clickOnProfileDropdown();
		/* homepage.verifyLoggedInUserNameText(); */
		homepage.clickOnLogoutLink();
	}

}
