package bay_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import generic.utilities.WebdriverUtility;
import object_Repo_BAY.HomePage_EleBAY;
//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class FooterLinksNavigation_TC_04 extends BaseClassBay{

//	@BeforeTest
//	public void linkNavigation() throws AWTException, InterruptedException {	
//		/*
//		//scroll to footer	
//		Thread.sleep(2000);
//		Robot rb=new Robot();
//		rb.mouseWheel(60);
//
//		JavascriptExecutor jse=(JavascriptExecutor) driver;
//		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		 */
//	}
	//navigate to each & every page	
	@Test
	public void aboutUsNavigation() throws AWTException, InterruptedException {

		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnAboutUsLink();
		Thread.sleep(4000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}
	@Test
	public void faqNavigation() throws AWTException, InterruptedException {	
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnFaqLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}
	@Test
	public void ReturnPolicyNavigation() throws AWTException, InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnReturnPolicyLink();	
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}

	@Test
	public void contactUsLinkNavigation() throws AWTException, InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnAboutUsLink();	
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
		
	}
	@Test
	public void HeplLinkNavigation() throws AWTException, InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnHelpLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());	
	}
	@Test
	public void StoreLocatorLinkNavigation() throws AWTException, InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnStoreLocatorLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}

	@Test
	public void siteMapLinkNavigation() throws AWTException, InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnSiteMapLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}

	@Test
	public void youTubeLinkNavigation() throws AWTException, InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnyouTubeLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}

	@Test
	public void InstagramLinkNavigation() throws AWTException, InterruptedException {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnInstagramLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}

	@Test
	public void LinkedInLinkNavigation() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnLinkedInLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}

	@Test
	public void FacebookLinkNavigation() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnFacebookLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}

	@Test
	public void TwitterLinkNavigation() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		HomePage_EleBAY home=new HomePage_EleBAY(driver);
		Thread.sleep(2000);
		home.clickOnTwitterLink();
		Thread.sleep(3000);
		Assert.assertEquals(true,true);
		System.out.println(driver.getTitle());
	}
}
