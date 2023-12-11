package bay_Automation;

import java.awt.AWTException;
import java.awt.Robot;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.PLP_page;

//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class SearchProductTest_TC_07 extends BaseClassBay{

	@Test(dataProvider = "searchData")
	public void searchProductAndCheckAvailability(String data) throws InterruptedException, AWTException {

		
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar(data);
		hp.clickOnSearchButton();
		Thread.sleep(2000);
		//System.out.println(driver.getTitle());
		
		String result = driver.findElement(By.cssSelector("[class='total_result']")).getText();
	//	System.out.println(result);
		String ch="";
		for(int i=0;i< result.length();i++) {
			
			char[] chara = result.toCharArray();
			
			if (Character.isDigit(chara[i])) {
				ch=ch+chara[i];   
			}	
		}
	//	System.out.println(ch);
		int totalProducts=Integer.parseInt(ch);
			System.out.println("Total products displayed are: "+totalProducts);
		Assert.assertEquals(true,true);
		
		PLP_page plp=new PLP_page(driver);
		Robot rb=new Robot();
		
		for(int i=1;i<plp.getPlpAllfilterselements().size();i++) {
			WebElement element = plp.getPlpAllfilterselements().get(i);
			if (element.isDisplayed()) {
				Assert.assertEquals(element.isDisplayed(), true, element.getText()+" is displayed");
					
			}else if (!element.isDisplayed()) {
				Assert.assertEquals(false, true,element.getText()+" is not displayed");
			}
			Thread.sleep(2000);
			rb.mouseWheel(3);
		}
		
	}	
	@DataProvider
	public String[] searchData() {
		String[] data=new String[] {
			"iphone",/*"12345","iphone 12","4564jjkg"*/
		};
		return data;
	}
	
//	@AfterTest
//	public void afterTest() {
//		//driver.close();
//	}
}
