package BAY_HomePageScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.MyAccountPage;

public class LoginWithOTPWithManualIntevention extends BaseClassBay{


	@Test
	public void loginWithOTPTestwithManualIntevetion() throws InterruptedException {
		
		wUtil.waitForDom(driver);
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);

		hp.getLoginIcon().click();
	
		driver.findElement(By.xpath("//button[@class='btn request-otp-btn']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='mobileNo']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
	
		Thread.sleep(8000);
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn login-btn']"));
		submitButton.click();
		MyAccountPage my=new MyAccountPage(driver);
		
		if (my.getMyAccountLink().isDisplayed()) {
			Assert.assertEquals(true, true);
			System.out.println("User logged in successfully");
		} else {
			Assert.assertEquals(false, true);
			System.out.println("Unable to login pls check !");
		}
		
	}
}
