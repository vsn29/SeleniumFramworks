import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCourse\\chromedriver_win32 (4)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com"); // URL in the browser
		// driver.findElement(By.className("inputtext")).sendKeys("helloworld");
		/*
		 * driver.findElement(By.id("email")).sendKeys("Thisis my first code");
		 * driver.findElement(By.name("pass")).sendKeys("123456");
		 * driver.findElement(By.linkText("Forgot account?")).click();
		 */

		driver.findElement(By.cssSelector("#email")).sendKeys("emailaddress");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='login_form']/table/tbody/tr[3]/td[2]/div/a")).click();

	}
}
