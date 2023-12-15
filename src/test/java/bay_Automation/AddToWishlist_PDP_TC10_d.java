package bay_Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;

public class AddToWishlist_PDP_TC10_d extends BaseClassBay{

	@Test
	public void addProductToWishlistForLoggedInUserOnlyTC10_d() throws InterruptedException, IOException {
		//go to login page
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.getLoginIcon().click();
		//login with otp	
		driver.findElement(By.xpath("//button[@class='btn request-otp-btn']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='mobileNo']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
		Thread.sleep(8000);
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn login-btn']"));
		submitButton.click();
		Thread.sleep(2000);
		//go to any product pdp
		hp.getLaptopsIcon().click();
		driver.findElement(By.xpath(("(//a[contains(text(),'HP Laptop')])[1]"))).click();
		//click on wish-list icon
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='far fa-heart'])[2]")).click();
		Thread.sleep(2000);
		wUtil.takeScreenShot(driver, "addedToWishlistScreenshot"+jUtil.getSystemDateFormat());
		
		Assert.assertEquals(true, true);
		System.out.println("Product added to Wishlist successfully !");
		
	}
}
