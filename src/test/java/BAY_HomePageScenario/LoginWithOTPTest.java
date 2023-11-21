package BAY_HomePageScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;

public class LoginWithOTPTest extends BaseClassBay{

	@Test
	public void loginWithOTPTest() throws InterruptedException {
		
		wUtil.waitForDom(driver);
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);

		hp.getLoginIcon().click();
	
		driver.findElement(By.xpath("//button[@class='btn request-otp-btn']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='mobileNo']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
		
		Thread.sleep(8000);
		/*
		WebElement otpField1 = driver.findElement(By.xpath("//input[contains(@id,'otp_0_')]"));
		otpField1.click();	
		wUtil.sendTextUsingJSE(driver, "1", otpField1);
		Thread.sleep(1000);
		WebElement otpField2 = driver.findElement(By.xpath("//input[contains(@id,'otp_1_')]"));
		otpField2.click();	
		wUtil.sendTextUsingJSE(driver, "2", otpField2);
		Thread.sleep(1000);
		WebElement otpField3 = driver.findElement(By.xpath("//input[contains(@id,'otp_2_')]"));
		otpField3.click();	
		wUtil.sendTextUsingJSE(driver, "3", otpField3);
		Thread.sleep(1000);
		WebElement otpField14 = driver.findElement(By.xpath("//input[contains(@id,'otp_3_')]"));
		otpField14.click();	
		wUtil.sendTextUsingJSE(driver, "4", otpField14);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn login-btn']"));
		js.executeScript("arguments[0].removeAttribute('disabled')", submitButton);
		Thread.sleep(2000);
		*/
//		if (submitButton.isEnabled()) {
//			js.executeScript("arguments[0].click();",submitButton );
//			System.out.println("user successfully logged in..!");
//		}else {
//			System.out.println("user successfully logged in..!");
//			Assert.assertEquals(false, true);
//		}
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn login-btn']"));
		submitButton.click();
	}
}
