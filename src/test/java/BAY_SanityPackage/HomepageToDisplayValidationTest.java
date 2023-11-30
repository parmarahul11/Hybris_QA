package BAY_SanityPackage;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;

public class HomepageToDisplayValidationTest extends BaseClassBay{
	
	@Test
	public void navigateToHomepage() {
		
	//	Access URL using any standard browser ie: Chrome or edge	
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		
		wait.until(ExpectedConditions.visibilityOf(home.getbAYLogoIcon()));
		
		Assert.assertTrue(home.getbAYLogoIcon().isDisplayed());
	//	Reporter.log("Browser navigated to Homepage successfully");
		System.out.println("Browser navigated to Homepage successfully");
	}
}
