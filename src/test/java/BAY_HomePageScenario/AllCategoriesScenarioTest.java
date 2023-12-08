package BAY_HomePageScenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.AllCategories_Elements;
import object_Repo_BAY.HomePage_EleBAY;

//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class AllCategoriesScenarioTest extends BaseClassBay {

	@Test(priority = 1)
	public void clickOnPanasonicStoreIconTest() throws InterruptedException {

		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On panasonic store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		wUtil.clickUsingJSE(driver, ac.getGamingStoreIcon());
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	/*
	 * @Test(priority = 2) public void clickOnBackToSchoolsIconTest() throws
	 * InterruptedException { HomePage_EleBAY hp=new HomePage_EleBAY(driver);
	 * //click on all categories hp.getAllCatagoiesIcon().click();
	 * Thread.sleep(2000); //click On top trending Icon AllCategories_Elements
	 * ac=new AllCategories_Elements(driver); ac.clickOnBackToSchoolIcon(); //verify
	 * title of page Assert.assertTrue(true); Thread.sleep(1000);
	 * System.out.println(driver.getTitle());
	 * 
	 * }
	 */
	@Test(priority = 2)
	public void clickOnOfficeAutomationIconTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Office Automation Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.clickOnOfficeAutoamtionIcon();
		ac.getOfficeAutomationStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 3)
	public void cliclOnBuiltInKitchenAppliancesStoreIconTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Built In Kitchen Appliances Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getBuiltInKitchenAppliancesStoreIcon();
		ac.getBuiltInKitchenAppliancesStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 4)
	public void cliclOnHomeEntaetainmentTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Home entertainment store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getHomeEntertainmentStoreIcon();
		ac.getHomeEntertainmentStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 5)
	public void cliclOnMobileTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On mobile store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getMobilesStoreIcon();
		ac.getMobilesStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 6)
	public void cliclOnGamingTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Gaming store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getGamingStoreIcon();
		ac.getGamingStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 7)
	public void cliclOnComputerAndTabletsTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Computer and Tablet store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getComputersAndTabletsStoreIcon();
		ac.getComputersAndTabletsStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 8)
	public void cliclOnAirConditionTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Air Condition store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getAirConditionersStoreIcon();
		ac.getAirConditionersStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 9)
	public void cliclOnHomeAppliencesTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Home Appliances store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getHomeAppliancesStoreIcon();
		ac.getHomeAppliancesStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 10)
	public void cliclOnOfficeAutomationTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Office Automation store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getOfficeAutomationStoreIcon();
		ac.getOfficeAutomationStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 11)
	public void cliclOnPersonalCareTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Personal Care store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getPersonalCareStoreIcon();
		ac.getPersonalCareStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 12)
	public void cliclOnPerfumeAndWatchesTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Personal Care store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getPerfumeWatchesStoreIcon();
		ac.getPerfumeWatchesStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 13)
	public void cliclOnToysAndBagsTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Personal Care store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getToysBagsStoreIcon();
		ac.getToysBagsStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

	@Test(priority = 14)
	public void cliclOnYearEndSalesTest() throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		// click on all categories
		hp.getAllCatagoiesIcon().click();
		Thread.sleep(2000);
		// click On Personal Care store Icon
		AllCategories_Elements ac = new AllCategories_Elements(driver);
		ac.getYearEndSaleStoreIcon();
		ac.getYearEndSaleStoreIcon().click();
		// verify title of page
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, true);
	}

}
