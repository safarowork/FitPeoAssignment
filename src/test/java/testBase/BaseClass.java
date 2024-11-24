package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass()
	public void setUp() {
		System.setProperty("webdriver.driver.chrome", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.fitpeo.com");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
