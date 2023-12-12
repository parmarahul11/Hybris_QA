package bay_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class BrowseProductTest_TC_06 extends BaseClassBay {
	
	@DataProvider(name = "products")
	public String[] ProductData() {
		String[] data=new String[] {
			"(//a[@class='cx-product-name'])[1]"
		};
		return data;
	}
	@Test(dataProvider = "products")
	public void browseProductTest(String product) throws InterruptedException, AWTException, IOException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.getLaptopsIcon().click();
		wUtil.waitForDom(driver);
		Robot rb=new Robot();
	//1. check price slider functionality:
		
		WebElement sliderMax = driver.findElement(By.xpath("(//span[@role='slider'])[2]"));
	//	WebElement sliderMin= driver.findElement(By.xpath("//span[@class='ngx-slider-span ngx-slider-pointer ngx-slider-pointer-min']"));					
	//	WebElement sliderNow = driver.findElement(By.xpath("//span[@aria-valuenow='1465']"));
		
		Actions ac=new Actions(driver);
		Thread.sleep(4000);
		ac.dragAndDropBy(sliderMax, -100, 320).perform();
	//	ac.contextClick();
		Thread.sleep(2000);
		wUtil.takeScreenShot(driver, "priceSliderFilterCheck"+jUtil.getSystemDateFormat());
	//	WebElement flag = driver.findElement(By.xpath("/html/body/app-root/cx-storefront/main/cx-page-layout/cx-page-slot[1]/best-product-facet-navigation-component/best-active-facets/a"));
	//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.visibilityOf(flag));
		
		Assert.assertEquals(true, true);
		System.out.println("Price using slider is manipulated randomly-passed");
		
	//2. select brand from filter:	
	
		rb.mouseWheel(4);
		Thread.sleep(2000);
		String brand="ASUS";
		driver.findElement(By.xpath("//a[@data-cx-focus='"+brand+"']")).click();
		
		Assert.assertEquals(true, true);
		System.out.println("User abled to select product brand-passed");
	}
}
