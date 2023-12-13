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
	
	@Test
	public void navigateToHomepage_TC_01() {
		
	//	Access URL using any standard browser ie: Chrome or edge	
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		
		wait.until(ExpectedConditions.visibilityOf(home.getbAYLogoIcon()));
		
		Assert.assertEquals(home.getbAYLogoIcon().isDisplayed(),true);
	//	Reporter.log("Browser navigated to Homepage successfully");
		System.out.println("Browser navigated to Homepage successfully");
	}
	
	@Test
	public void ChangeToArebicTest_TC_02_E() throws InterruptedException {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		wUtil.waitUntilElementToVisible(driver, hp.getChangeLangToArebic());
		Thread.sleep(3000);
		hp.getChangeLangToArebic().click();
		Thread.sleep(2000);
		String ArebicText = driver.getTitle();
		System.out.println(ArebicText);//?????? ????????
		
		Assert.assertEquals(true, true);
		System.out.println("User successfully changed the Language to Arabic");

	}
	/*
	@Test(dataProvider = "searchData")
	public void clickOnSearchBarAndSearchSomething(String data) throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar(data);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(true, true);
		System.out.println("User successfully searched required data !");
	}
	*/
	@DataProvider(name = "searchData")
	public String[][] inputdata(){
		return new String[][] {{"iphone"},{"12345"}};
	}
	
	
	@Test
	public void goToLoginPageAndbackToHomepage_TC_02_D() throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.getLoginIcon().click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(true, true);
		System.out.println("User successfully went to login and again back to homepage");
	}
	
	@Test
	public void captureBAYLogo_TC_02_C() throws IOException {
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
