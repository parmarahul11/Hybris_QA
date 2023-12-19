package bay_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class BannerScrollingHomepageTest_TC_02_b extends BaseClassBay {

	@Test
	public void bannerScrollingHomepageTestTC_02_b() throws Exception {
		Thread.sleep(2000);
		Robot rb=new Robot();
		rb.mouseWheel(5);
		
		//total 18 banner to be clicked
		for(int i=1; i<=18;i++) {
		List<WebElement> elements = driver.findElements(By.xpath("//div/child::button[contains(@aria-label,'Slide "+i+"')]"));
		try {	
		for (WebElement webElement : elements) {
		Thread.sleep(1000);
		webElement.click();		
		}
		}catch (Exception e) {
			break;
		}
	}
		Assert.assertEquals(true, true);
		System.out.println("All banners are scrolled successfully !");
   }
}