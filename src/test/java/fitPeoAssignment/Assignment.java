package fitPeoAssignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		//Launch Chrome browser, maximize and set implicit wait time to 20s
		
		System.setProperty("webdriver.driver.chrome", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1. Navigate to the FitPeo Homepage:
		driver.get("https://www.fitpeo.com");
		
		// 2. Navigate to the Revenue Calculator Page:
		
		WebElement link_revenueCalculator = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));	
		link_revenueCalculator.click();
		
		Thread.sleep(2000);  //Wait time is added for better view of script execution
		
		// 3. Scroll Down to the Slider section:
		
		WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", slider);
		
		//4. Adjust the Slider:
		
		int sliderInitialValue = 200;
		int sliderTargetValue = 820;
		int offset = sliderTargetValue - sliderInitialValue;
		
		for(int i=1;i<=offset;i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
		
		//verify if the slider is moved:
		if(slider.getAttribute("value").equals("820"))
			System.out.println("Hurray!! Slider move successful via Slider");
		else 
			System.out.println("Oops... Slider move failed via Slider");
		
		Thread.sleep(2000);
		
		//5. Update the Text Field:
		
		//Locate the text box to enter slider value
		WebElement txt_slider = driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input')]"));
	
		//Move the slider by passing value
		try {
		txt_slider.sendKeys(Keys.CONTROL+"A");
		txt_slider.sendKeys("560");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//6. Validate Slider Value:
		
		if(txt_slider.getAttribute("value").equals("560"))
			System.out.println("Hurray!! Slider move successful via text");
		else 
			System.out.println("Oops... Slider move failed via text");
		
		//Set slider value back to 820
		txt_slider.sendKeys(Keys.CONTROL+"A");
		txt_slider.sendKeys("820");
		
		Thread.sleep(2000);  
		
		//7. Select CPT Codes:
		
		//Locate the CPT codes section:
		WebElement cptSection = driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']"));
		
		//Scroll down to the CPT codes area:
		js.executeScript("arguments[0].scrollIntoView();", cptSection);

		//Locate all the CPT codes
		List<WebElement> codesCPTList = driver.findElements(By.xpath("//div[@class='MuiBox-root css-1p19z09']//div//p[1]"));
		
		//Select the checkboxes for the desired CPT codes: CPT-99091, CPT-99453, CPT-99454, and CPT-99474
		
		String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
		
		for(int i=1;i<=codesCPTList.size();i++) {
			String text = driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']//div["+i+"]//p[1]")).getText();
			for(int j=0;j<cptCodes.length;j++) {
				if(text.equals(cptCodes[j])) {
					driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']//div["+i+"]//span[contains(@class,'MuiCheckbox-root MuiCheckbox')]")).click();
					continue;
				}
			}
		}
		
		//8. Validate Total Recurring Reimbursement:
		
		WebElement table_reimbursement = driver.findElement(By.xpath("//div[@class='MuiBox-root css-m1khva']//p[contains(@class,'MuiTypography-body1')]"));
		String tableReimbursementValue = table_reimbursement.getText();
		System.out.println("Total Recurring Reimbursement for all Patients Per Month as per the table value is: "+ tableReimbursementValue);
		
		//9. Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700.	
		
		WebElement headerReimbursement = 
		driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body2 inter css-1xroguk'][contains(text(),'Total Recurring Reimbursement for all Patients Per')]//p"));		
		
		String headerReimbursementValue = headerReimbursement.getText();
		System.out.println("Header displaying Total Recurring Reimbursement for all Patients Per Month: "+headerReimbursementValue);
		
		if(headerReimbursementValue.equals("$110700"))
			System.out.println("Total recurring reimbursement for all patients per month is Successfully validated via Header");
		else
			System.out.println("Total recurring reimbursement for all patients per month fails validation via Header");
		
		Thread.sleep(2000);
		
		//Close the browser window
		driver.quit();
	}
}


