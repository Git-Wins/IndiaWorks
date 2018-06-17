package sikuliWorks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SikuliAutomationFileUpld {

	Screen s;
	WebDriver driver;
	Pattern fileInptBox, openButton;

	@Parameters ({"path"})
	@BeforeClass
	public void befSetup(String a) {
		s = new Screen();
		fileInptBox = new Pattern(a +"FileNameField.JPG");
		openButton = new Pattern(a +"FileUploadOpenButton.JPG");	
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/image_upload/index.php");
	}

	@Test
	public void toTest() throws FindFailed {
		driver.findElement(By.id("photoimg")).click();
		s.wait(fileInptBox, 10);
		s.type(fileInptBox, "TestSikuli.docx");
		s.click(openButton);	
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
