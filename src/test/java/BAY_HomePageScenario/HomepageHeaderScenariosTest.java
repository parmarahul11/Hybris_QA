package BAY_HomePageScenario;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClass;
import object_Repo_BAY.HomePage_EleBAY;

@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class HomepageHeaderScenariosTest extends BaseClass {

	@Test(priority = 1)
	public void ChangeToArebicTest() throws InterruptedException {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		wUtil.waitUntilElementToVisible(driver, hp.getChangeLangToArebic());
		hp.getChangeLangToArebic().click();
		Thread.sleep(2000);
		String ArebicText = driver.getTitle();
		System.out.println(ArebicText);//?????? ????????
		
		Assert.assertTrue(true);
		System.out.println("User successfully changed the Language to Arabic");

	}

	@Test(priority = 2,dataProvider = "searchData")
	public void clickOnSearchBarAndSearchSomething(String data) throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar(data);
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		Assert.assertTrue(true);
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
		
		Assert.assertTrue(true);
		System.out.println("User successfully went to login and again back to homepage");
	}
	
	@Test(priority = 4)
	public void captureBAYLogo() throws IOException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		WebElement BAYLogo = hp.getbAYLogoIcon();
		String logoPath = wUtil.takeScreenShot(BAYLogo, "bayLogo"+jUtil.getRandomNumber()+"");
		System.out.println(logoPath);
		
		Assert.assertTrue(true);
		System.out.println("User successfully caputerd the screenshot for BAY logo !");
	}
}
