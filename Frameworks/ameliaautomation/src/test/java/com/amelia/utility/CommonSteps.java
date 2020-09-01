package com.amelia.utility;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amelia.page.objects.LoggedInHomePage;

import net.bytebuddy.asm.Advice.Return;

public class CommonSteps {
	public WebDriver browser;

	// Constructor
	public CommonSteps(WebDriver driver) {
		this.browser = driver;
	}

	// ************** Web Driver Methods ************************

	/**
	 * This method is to navigate to given url from open browser
	 * 
	 * @param url
	 */
	public void navigate_url(String url) {
		if (url != null) {
			browser.navigate().to(url);
		}
	}

	/**
	 * This method is to navigate to given url from open browser
	 * 
	 * @param url
	 * @throws InterruptedException
	 */
	public void wait(int milliSeconds) throws InterruptedException {
		Thread.sleep(milliSeconds);
	}

	// ************** Web Interactions Methods ************************

	/**
	 * This method is to verify is Web Element displayed
	 * 
	 * @param elementName
	 * @return boolean value
	 */
	public boolean isElementDisplayed(WebElement elementName) {
		return elementName.isDisplayed();

	}

	/**
	 * This method is to click on Web Element
	 * 
	 * @param elementName
	 * @throws InterruptedException
	 */
	public void clickOnWebElement(WebElement elementName) {
		elementName.click();

		// Select select = new Select(elementName);

	}

	/**
	 * This method is to enter text in text field
	 * 
	 * @param elementName
	 * @param text
	 */
	public void enterText(WebElement elementName, String text) {
		elementName.sendKeys(text);
	}

	/**
	 * This method is to get the innerText of any WebElement
	 * 
	 * @param elementName
	 * 
	 */
	public String getTextOfWebElement(WebElement elementName) {

		// System.out.println("Element Text: " +elementName.getText());
		return elementName.getText();
	}

	/**
	 * This method is to get the Value of any attribute of WebElement
	 * 
	 * @param elementName
	 * @param attributeName
	 */
	public String getAttributeValueOfWebElement(WebElement elementName, String attributeName) {

		// System.out.println("Element Text: " +elementName.getText());
		return elementName.getAttribute(attributeName);
	}

	/**
	 * This method is to get verify the mouse actions.
	 * 
	 * @param elementName
	 * @param WebDriver   driver
	 */
	public void mouseHoverOnWebElement(WebElement elementName, WebDriver driver) {

		Actions actions = new Actions(driver);
		actions.moveToElement(elementName).perform();
	}

	/**
	 * This method is to list the WebElements.
	 * 
	 * @param elementName
	 * @param String      value
	 */
	public void selectWebElement(List<WebElement> elementName, String value) {

		WebElement ele;

		Iterator itr = elementName.iterator();

		while (itr.hasNext()) {

			ele = (WebElement) itr.next();

			System.out.println(ele.getText());

			if (ele.getText().contains(value)) {

				ele.click();

				break;
			}

		}

	}

	/**
	 * This method is to clear the default text.
	 * 
	 * @param elementName
	 */
	public void clearTextField(WebElement elementName) {
		elementName.sendKeys(Keys.CONTROL + "a");
		elementName.sendKeys(Keys.DELETE);
	}

	/**
	 * This method is to select the Date.
	 * 
	 * @param elementName
	 * @param WebDriver   driver
	 * @param String      monthYear
	 * @param String      date
	 */
	public void selectDate(WebElement element, WebDriver driver, String monthYear, String date)
			throws InterruptedException {

		List<WebElement> tableHeader = element.findElements(By.tagName("th"));
		List<WebElement> dateList = element.findElements(By.tagName("td"));
		System.out.println("Size of Header" + tableHeader.size());

		Iterator itr = tableHeader.iterator();

		WebElement ele;
		WebElement ele1;

		boolean flag = false;
		// Select future months
		for (int i = 0; i <= 5; i++) {
			// System.out.println("value -i--"+i);
			// System.out.println("tableHeader Size---"+tableHeader.size());
			for (int j = 0; j < tableHeader.size(); j++) {
				ele = tableHeader.get(j);
				System.out.println("Header Element---" + ele.getText());
				if (ele.getText().contains(monthYear)) {
					System.out.println("Got the desired month---");
					flag = true;
					break;
				}
			}
			
			WebElement nextButton = driver.findElement(By.xpath("//div[@class='_1pNbsq']/button[@class='_223JL_']"));
			// Logic for clicking next button.
			if (flag != true) {
				System.out.println("Clicked button" + i);
				nextButton.click();
				Thread.sleep(1000);
				// re-assigning nextButton and TableHeader webelement to get rid of
				// staleException error
				// As upon click of next page the calendar object is refreshed
				nextButton = driver.findElement(By.xpath("//div[@class='_1pNbsq']/button[@class='_223JL_']"));
				tableHeader = element.findElements(By.tagName("th"));
			} else {
				// break the loop once you get calendar month
				break;
			}
		}

		// Selecting date logic
		dateList = element.findElements(By.tagName("td"));
		for (int k = 0; k < dateList.size(); k++) {
			ele1 = dateList.get(k);
			System.out.println("date---" + ele1.getText());
			if (ele1.getText().contains(date)) {
				ele1.click();
				break;
			}
		}

	}

	/**
	 * This method is to verify the WebElement is select or not.
	 * 
	 * @param elementName
	 * @param WebDriver   driver
	 */
	public boolean isSelected(WebElement elementName, WebDriver driver) {

		boolean isSelected = false;
		if (elementName.isSelected()) {
			isSelected = true;

			System.out.println("Radio Button is selected");
		} else {

			isSelected = false;
			System.out.println("Radio Button is not selected");
		}

		return isSelected;

	}

}
