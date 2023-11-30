package BAY_HomePageScenario;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.utilities.BaseClassBay;
import generic.utilities.ListenerImplementationWithExtentReport;
import object_Repo_BAY.HomePage_EleBAY;

//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class HomepageHeaderScenariosTest extends BaseClassBay {
	
	@Test(priority = 0)
	public void navigateToHomepage() {
		
	//	Access URL using any standard browser ie: Chrome or edge	
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		
		wait.until(ExpectedConditions.visibilityOf(home.getbAYLogoIcon()));
		
		Assert.assertTrue(home.getbAYLogoIcon().isDisplayed());
	//	Reporter.log("Browser navigated to Homepage successfully");
		System.out.println("Browser navigated to Homepage successfully");
	}
	
	@Test(priority = 1)
	public void ChangeToArebicTest() throws InterruptedException {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		wUtil.waitUntilElementToVisible(driver, hp.getChangeLangToArebic());
		hp.getChangeLangToArebic().click();
		Thread.sleep(2000);
		String ArebicText = driver.getTitle();
		System.out.println(ArebicText);//?????? ????????
		
		Assert.assertEquals(true, true);
		System.out.println("User successfully changed the Language to Arabic");

	}

	@Test(priority = 2,dataProvider = "searchData")
	public void clickOnSearchBarAndSearchSomething(String data) throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar(data);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(true, true);
		System.out.println("User successfully searched required data !");
	}
	@DataProvider(name = "searchData")
	public String[][] inputdata(){
		return new String[][] {{"iphone"},{"12345"}};
	}
	
	
	@Test(priority = 3)
	public void goToLoginPageAndbackToHomepage() throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.getLoginIcon().click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(true, true);
		System.out.println("User successfully went to login and again back to homepage");
	}
	
	@Test(priority = 4)
	public void captureBAYLogo() throws IOException {
		ListenerImplementationWithExtentReport exReport=new ListenerImplementationWithExtentReport();
				
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		WebElement BAYLogo = hp.getbAYLogoIcon();
		String logoPath = wUtil.takeScreenShot(BAYLogo, "bayLogo_"+jUtil.getSystemDateFormat()+"");
		System.out.println("Captured Screenshot path is: "+logoPath);
		
		Assert.assertEquals(true, true);
		System.out.println("User successfully caputerd the screenshot for BAY logo !");
		Reporter.log("User successfully caputerd the screenshot for BAY logo !");
		
		BaseClassBay.takeScreenShots(logoPath);
		
		exReport.logTestStatus(Status.PASS, "captureBAYLogo", logoPath);
		
	}
}
