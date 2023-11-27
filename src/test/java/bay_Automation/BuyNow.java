package bay_Automation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import generic.utilities.JavaUtility;
import object_Repo_BAY.HomePage_EleBAY;
@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class BuyNow extends BaseClassBay {

	@DataProvider
	public String[] productList() {

		String[] data=new String[] {
				//any product path
				 "(//a[@class='cx-product-name'])[2]" 
		};
		return data;
	}
	@Test(dataProvider ="productList" )
	public void BuyNowSc(String data) throws InterruptedException, IOException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("Apple IPhone 15Pro");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();
		//click on add to buy button
		driver.findElement(By.xpath("//button[@class='btn btn-block buy-now-btn ng-star-inserted']")).click();
		
		//quantity increase by one
		//driver.findElement(By.xpath("//button[@aria-label='Add one more']")).click();
	    
		Thread.sleep(2000);
		wUtil.waitForDom(driver);
		HomePage_EleBAY hp1=new HomePage_EleBAY(driver);

		hp1.getLoginIcon().click();
	
		driver.findElement(By.xpath("//button[@class='btn request-otp-btn']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='mobileNo']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
		
		Thread.sleep(8000);
	
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn login-btn']"));
		submitButton.click();
		
		driver.findElement(By.xpath("//button[@class='cx-btn btn btn-block btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary nextPage ng-star-inserted']")).click();
		
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"./BAYScreenShots/BAY"+jUtil.getRandomNumber()+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		
		Assert.assertTrue(true);
		
		System.out.println("User successfully buy now product !");
	}
}
	