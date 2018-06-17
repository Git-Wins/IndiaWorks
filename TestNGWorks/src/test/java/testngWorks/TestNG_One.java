package testngWorks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_One extends FileWorks {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Parameters ({"url"})
	@Test (enabled = true, dataProvider = "excelData") //invocationCount = 1, expectedExceptions = ArithmeticException.class), threadPoolSize = 4)
	public void a(String fName, String lName) {
		System.out.println("this is the TestNG-One-'a' method");
		int c = 9/0;
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-en&flowName=GlifWebSignIn&flowEntry=SignUp");
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
		driver.findElement(By.id("firstName")).sendKeys(fName);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName")));
		driver.findElement(By.id("lastName")).sendKeys(lName);
		
	}

	@Test (enabled = false)
	public void b() {
		System.out.println("this is the TestNG-One-'b' method");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
