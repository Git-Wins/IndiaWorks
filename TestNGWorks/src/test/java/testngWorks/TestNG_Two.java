package testngWorks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Two {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test (enabled = true)
	public void a() {
		System.out.println("this is the TestNG-Two-'a' method");
		driver.get("https://www.google.com/");
	}

	@Test (enabled = false)
	public void b() {
		System.out.println("this is the TestNG-Two-'b' method");
	}

	@AfterMethod
	public void teardown() {
		//driver.quit();
	}

}
