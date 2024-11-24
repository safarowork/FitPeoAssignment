package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RevenueCalculatorPage;
import testBase.BaseClass;

public class FitPeoAssignement extends BaseClass{
	
	HomePage homepage;
	RevenueCalculatorPage revenuecalculator;
	
	@Test(priority=1)
	void testNavigateRevenueCalculatorPage() throws InterruptedException {
		homepage = new HomePage(driver);
		revenuecalculator = new RevenueCalculatorPage(driver);
		
		homepage.clickRevenueCalculator();
		Assert.assertEquals(homepage.validateRevenueCalculatorPage(), true);
	}
	
	@Test(priority=2)
	void testScrollDownToSlider() {
		revenuecalculator.scollIntoSliderView();
	}
	
	@Test(priority=3)
	void testAdjustSlider() {
		revenuecalculator.adjustSlider(820);
		Assert.assertEquals(revenuecalculator.validateSliderMove(), "820");
		System.out.println("Hurray!! Slider move successful via Slider");
	}
	
	@Test(priority=4)
	void testUpdateTextField() {
		try {
			revenuecalculator.adjustSliderByText("560");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(revenuecalculator.validateSliderMoveByText(), "560");
		System.out.println("Hurray!! Slider move successful via text");
		revenuecalculator.adjustSliderBack();
	}
	
	@Test(priority=5)
	void testSelectCPTCodes() {
		revenuecalculator.selectCPTCodes();
	}
	
	@Test(priority=6)
	void testTotalRecurringReimbursement() {
		Assert.assertEquals(revenuecalculator.validateRecurringReimbursement(), "$110700");
		System.out.println("Total Recurring Reimbursement for all Patients Per Month as per the table value is: "+ revenuecalculator.validateRecurringReimbursement());
	}
	
	@Test(priority=7)
	void testHeaderDisplayReimbursement() {
		Assert.assertEquals(revenuecalculator.verifyHeaderReimursement(), "$110700");
		System.out.println("Total recurring reimbursement for all patients per month is Successfully validated via Header");
	}

}
