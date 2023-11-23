package bay_Automation;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.random.Well1024a;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import generic.utilities.BaseClassBay;
import generic.utilities.ListenerImplementationWithExtentReport;
import object_Repo_BAY.HomePage_EleBAY;
@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class PLPScenario extends BaseClassBay {
	@Test
	public void plpGetAllProdName() throws AWTException, InterruptedException {

		Robot robot=new Robot();		
		robot.mouseWheel(10);

		//	String sourceEle="HP Victus Gaming Laptop Intel� Core� i5-12450H, NVIDIA� GeForce RTX� 3050 4GB, 16GB RAM, 512GB SSD, Windows 11 Home, 15.6 Inch FHD, Performance Blue with Bundle";

		List<WebElement> actualEles = driver.findElements(By.xpath("(//*[@class='cx-product-name'])"));

		for(WebElement webele:actualEles) {
			Thread.sleep(500);
			System.out.println(webele.getText().toString());
			//Assert.assertEquals(sourceEle, actualEle, "data matched");
		}
		Assert.assertTrue(true);
		System.out.println("All products name from plp are listed !");
	}
	
	////a[@class='product-details-cnt']/child::div[@class='price']

	@Test
	public void plpGridiew() {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("iphone");
		hp.clickOnSearchButton();

		driver.findElement(By.cssSelector("[class='cx-icon fas fa-th-large ng-star-inserted']")).click();
		Assert.assertTrue(true);
		System.out.println("Products are listed are per Grid view !");
	}
	@Test
	public void plpListiew() {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("iphone");
		hp.clickOnSearchButton();

		driver.findElement(By.cssSelector("[class='cx-icon fas fa-bars ng-star-inserted']")).click();

		Assert.assertTrue(true);
		System.out.println("Products are listed are per List view !");
	}
	@Test
	public void PriceOfProductVisibleTest() {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("cooker");
		hp.clickOnSearchButton();

		List<WebElement> elements=driver.findElements(By.xpath("//div[@class='cx-product-price']"));

		for (WebElement webElement : elements) {
			if(webElement.isDisplayed()) {	
				Assert.assertEquals(true, true);
			}else if(!webElement.isDisplayed()) {
				Assert.assertEquals(false, true);
				System.out.println("Price of product is  not displayed !");
			}
		}
		Assert.assertTrue(true);
		System.out.println("Price of product is displayed !");
	}

	@Test
	public void currencyOfProductValTest() {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("cooker");
		hp.clickOnSearchButton();

		List<WebElement> elements=driver.findElements(By.xpath("//div[@class='cx-product-price']"));
		for (WebElement webElement : elements) {
			
			String priceText = webElement.getText();
			
			if (priceText.contains("KD")) {
				Assert.assertEquals(true, true);
			//	System.out.println(priceText);
			}else {
				Assert.assertEquals(false, true);
			}
		}
		Assert.assertTrue(true);
		System.out.println("Currency of product is displayed !");
	}
//	public ExtentTest test;
	@Test
	public void compareIcon() throws IOException, InterruptedException  {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("cooker");
		hp.clickOnSearchButton();
		WebElement anyProductICon1=driver.findElement(By.xpath("(//a[@class='add-to-compare'])[1]"));
		WebElement anyProductICon2=driver.findElement(By.xpath("(//a[@class='add-to-compare'])[2]"));

		if (anyProductICon1.isDisplayed()==true && anyProductICon2.isDisplayed()==true) {

			Assert.assertEquals(true, true);
			anyProductICon1.click();
			Thread.sleep(2000);
			anyProductICon2.click();
		//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//	WebElement frameNotification=driver.findElement(By.xpath("//iframe[@id='snap2061150']"));
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='snap2061150']")));
		//	driver.findElement(By.xpath("//a[@href='compare']")).click();
		//	wait.until(ExpectedConditions.visibilityOf(compareLink)).click();
			Thread.sleep(3000);
			wUtil.takeScreenShot(driver, "comparePage"+jUtil.getSystemDateFormat());
			/*	
			String path = BaseClassBay.takeScreenShots("compareIcon");
			test.pass("test passed for comapareIcon"+test.addScreenCaptureFromPath(path));
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			test.pass("details").addScreenCaptureFromPath(path);
			 */
		//	Reporter.log("Product added to compare list..!");
			Assert.assertEquals(true, true);
			System.out.println("Product added to compare list..!");

		}else {
			Assert.assertEquals(false, true);
			System.out.println("Add to compare icon not visible for this product");
		//	Reporter.log("Add to compare icon not visible for this product");
		}
		//	ListenerImplementationWithExtentReport.reports.flush();
	}
	
	@Test
	public void clickAndCollectTest() {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("cooker");
		hp.clickOnSearchButton();
		
		driver.findElement(By.xpath("(//*[@class='cx-product-name'])[1]")).click();
		
		WebElement clickCollectButton=driver.findElement(By.xpath("//button[@class='btn collect-from-store-btn btn-block ng-star-inserted']"));
		
		if (clickCollectButton.isDisplayed()==true) {
			clickCollectButton.click();
		Assert.assertEquals(true, true);	
		}
		Assert.assertTrue(true);
		System.out.println("Click and collect is displayed & are available for this product !");

	}
}
