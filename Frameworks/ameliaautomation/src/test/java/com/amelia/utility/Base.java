package com.amelia.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public RemoteWebDriver remoteWebDriver;
	public String sessionId = null;

	public ExtentTest test;

	URL remoteURL;
	RemoteWebDriver rwd;

	@BeforeTest

	@Parameters({ "execution", "browser", "url" })
	public void setup(@Optional("local") String execution, @Optional("chrome") String browser,
			@Optional("https://www.flipkart.com") String url) throws MalformedURLException {

		ExtentReports reports = new ExtentReports(System.getProperty("user.dir") + "\\TestReport.html");

		System.out.println("path :" + System.getProperty("user.dir") + "\\TestReport.html");

		ExtentTest test = reports.startTest("Base");

		if (execution.equalsIgnoreCase("local")) {

			switch (browser) {

			case "chrome":
				// WebDriver Manager
				WebDriverManager.chromedriver().setup();
				// Set chrome browser options and capabilities
				ChromeOptions chromeoptions = new ChromeOptions();
				chromeoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new ChromeDriver(chromeoptions);
				launchRemoteWebDriver(driver);

				break;

			case "firefox":
				// WebDriver Manager)

				WebDriverManager.firefoxdriver().setup();
				// Set chrome browser options and capabilities
				FirefoxOptions firefoxoptions = new FirefoxOptions();
				firefoxoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new FirefoxDriver(firefoxoptions);
				launchRemoteWebDriver(driver);

				break;

			case "ie":
				// WebDriver Manager)

				WebDriverManager.edgedriver().setup();
				// Set chrome browser options and capabilities
				EdgeOptions eo = new EdgeOptions();
				eo.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				;
				driver = new EdgeDriver(eo);
				launchRemoteWebDriver(driver);

				break;

			case "chrome-headless":

				// WebDriver Manager
				WebDriverManager.chromedriver().setup();
				// Set chrome browser options and capabilities
				ChromeOptions chromeoptions1 = new ChromeOptions();
				chromeoptions1.addArguments("--headless");
				chromeoptions1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new ChromeDriver(chromeoptions1);
				launchRemoteWebDriver(driver);

				break;

			default:

				// WebDriver Manager
				WebDriverManager.chromedriver().setup();
				// Set chrome browser options and capabilities
				ChromeOptions chromeoptions2 = new ChromeOptions();
				chromeoptions2.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new ChromeDriver(chromeoptions2);
				launchRemoteWebDriver(driver);

			}

		} else if (execution.equalsIgnoreCase("grid")) {

			switch (browser) {

			case "chrome":
				ChromeOptions chromeoptions = new ChromeOptions();
				remoteURL = new URL("http://localhost:4444/wd/hub");
				rwd = new RemoteWebDriver(remoteURL, chromeoptions);
				launchGridDriver(rwd);

				break;

			case "firefox":
				FirefoxOptions firefoxoptions = new FirefoxOptions();
				remoteURL = new URL("http://localhost:4444/wd/hub");
				rwd = new RemoteWebDriver(remoteURL, firefoxoptions);
				launchGridDriver(rwd);

				break;

			default:
				ChromeOptions chromeoptions3 = new ChromeOptions();
				remoteURL = new URL("http://localhost:4444/wd/hub");
				rwd = new RemoteWebDriver(remoteURL, chromeoptions3);
				launchGridDriver(rwd);
			}
		}

	}

	private void launchRemoteWebDriver(WebDriver driver) {
		this.remoteWebDriver = (RemoteWebDriver) driver;
		this.sessionId = remoteWebDriver.getSessionId().toString();
		remoteWebDriver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	private void launchGridDriver(RemoteWebDriver rwd) {
		this.driver = rwd;
		this.remoteWebDriver = rwd;
		this.sessionId = rwd.getSessionId().toString();
		rwd.manage().window().maximize();
		rwd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterTest
	public void close() {

		driver.close();
	}
}
