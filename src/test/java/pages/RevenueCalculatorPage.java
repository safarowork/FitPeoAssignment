package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevenueCalculatorPage {
	public WebDriver driver;

	public RevenueCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor js;

	@FindBy(xpath="//input[@type='range']") private WebElement slider;
	@FindBy(xpath="//input[contains(@class,'MuiInputBase-input')]") private WebElement txt_slider;
	@FindBy(xpath="//div[@class='MuiBox-root css-1p19z09']") private WebElement cptSection;
	@FindBy(xpath="//div[@class='MuiBox-root css-1p19z09']//div//p[1]") private List<WebElement> codesCPTList;
	@FindBy(xpath="//div[@class='MuiBox-root css-m1khva']//p[contains(@class,'MuiTypography-body1')]") private WebElement table_reimbursement;
	@FindBy(xpath="//p[@class='MuiTypography-root MuiTypography-body2 inter css-1xroguk'][contains(text(),'Total Recurring Reimbursement for all Patients Per')]//p") private WebElement headerReimbursement;
	
	public void scollIntoSliderView() {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", slider);
	}

	public void adjustSlider(int targetValue) {
		int sliderInitialValue = 200;
		int sliderTargetValue = targetValue;
		int offset = sliderTargetValue - sliderInitialValue;

		for(int i=1;i<=offset;i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
	}

	public String validateSliderMove() {
		String sliderValue = slider.getAttribute("value");
		return sliderValue;
	}

	public void adjustSliderByText(String value) {
		txt_slider.sendKeys(Keys.CONTROL+"A");
		txt_slider.sendKeys(value);
	}

	public String validateSliderMoveByText() {
		String sliderValue = txt_slider.getAttribute("value");
		return sliderValue;
	}

	public void adjustSliderBack() {
		txt_slider.sendKeys(Keys.CONTROL+"A");
		txt_slider.sendKeys("820");
	}

	public void selectCPTCodes() {
		js.executeScript("arguments[0].scrollIntoView();", cptSection);
		
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
	}
	
	public String validateRecurringReimbursement() {
		return table_reimbursement.getText();
	}
	
	public String verifyHeaderReimursement() {
		return headerReimbursement.getText();
	}


}
