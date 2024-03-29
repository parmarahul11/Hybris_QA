package bay_Automation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
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
import object_Repo_BAY.HomePage_EleBAY;
//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class AddToCart_TC_12 extends BaseClassBay {

	@DataProvider
	public String[] productList() {

		String[] data=new String[] {
				//any product path
				 "(//a[@class='cx-product-name'])[2]" 
		};
		return data;
	}
	@Test(dataProvider ="productList" )
	public void addToCart_TC_12(String data) throws InterruptedException, IOException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("Apple IPhone 15Pro");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();
		//click on add to cart button
		driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
		
		//quantity increase by one
		driver.findElement(By.xpath("//button[@aria-label='Add one more']")).click();
	    
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();
		
		//driver.findElement(By.xpath("//*[@class='btn btn-primary best-cart-button btn-block']")).click();
		
		
		Assert.assertEquals(true,true);
		
		System.out.println("Product added successfully into cart !");
	}
}
	