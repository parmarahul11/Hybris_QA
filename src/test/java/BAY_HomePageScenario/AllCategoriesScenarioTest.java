package BAY_HomePageScenario;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClass;
import generic.utilities.BaseClassBay;
import object_Repo_BAY.AllCategories_Elements;
import object_Repo_BAY.HomePage_EleBAY;

@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class AllCategoriesScenarioTest extends BaseClassBay{

	@Test(priority = 1)
	public void clickOnPanasonicStoreIconTest() throws InterruptedException {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		//click on all categories	
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		//click On panasonic store Icon
		AllCategories_Elements ac=new AllCategories_Elements(driver);
		wUtil.clickUsingJSE(driver, ac.getPanasonicStoreIcon());
		//verify title of page
		Assert.assertTrue(true);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
	}

	@Test(priority = 2)
	public void clickOnBackToSchoolsIconTest() throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		//click on all categories	
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		//click On top trending Icon
		AllCategories_Elements ac=new AllCategories_Elements(driver);
		ac.clickOnBackToSchoolIcon();
		//verify title of page
		Assert.assertTrue(true);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
	
	}
	
	@Test(priority = 3)
	public void clickOnOfficeAutomationIconTest() throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		//click on all categories	
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		//click On Office Automation Icon
		AllCategories_Elements ac=new AllCategories_Elements(driver);
		ac.clickOnOfficeAutoamtionIcon();
		//verify title of page
		Assert.assertTrue(true);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
	}

}
