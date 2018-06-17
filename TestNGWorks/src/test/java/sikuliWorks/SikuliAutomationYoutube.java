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


public class SikuliAutomationYoutube {

	Screen s;
	WebDriver driver;
	Pattern skpAd, pauseBtn;

	@Parameters ({"path"})
	@BeforeClass
	public void befSetup(String a) {
		s = new Screen();
		skpAd = new Pattern(a +"SkipAd.JPG");
		pauseBtn = new Pattern(a +"PauseBtn.JPG");
		
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=BfJvxGs-HxQ");
	}

	@Test
	public void toTest() throws FindFailed {
		driver.findElement(By.id("photoimg")).click();
		/*s.wait(skpAd, 10);
		s.find(skpAd);
		s.click(skpAd);*/
		s.wait(pauseBtn, 10);
		s.find(pauseBtn);
		s.click(pauseBtn);	
	}

	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
}
