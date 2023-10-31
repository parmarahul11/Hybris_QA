package bay_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;

public class BannerScrollingHomepageTest extends BaseClassBay {

	@Test
	public void headerPrimaryREDBackColourTest() throws Exception {
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
   }
}