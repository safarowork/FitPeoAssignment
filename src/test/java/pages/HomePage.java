package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Revenue Calculator']") private WebElement link_revenueCalculator;
	
	public void clickRevenueCalculator() {
		link_revenueCalculator.click();
	}
	
	public boolean validateRevenueCalculatorPage() throws InterruptedException {
		Thread.sleep(2000);
		boolean flag=false;
		if(driver.getPageSource().contains("Total Gross Revenue Per Year")) {
			flag=true;
			return flag;
		}
		else
			return flag;		
	}
	
}
