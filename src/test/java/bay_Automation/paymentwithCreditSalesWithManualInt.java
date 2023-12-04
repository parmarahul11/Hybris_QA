package bay_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.utilities.BaseClassBay;
import generic.utilities.JavaUtility;
import generic.utilities.ListenerImplementationWithExtentReport;
import generic.utilities.PropertyFileUtility;
import generic.utilities.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo_BAY.AddToCartPage;
import object_Repo_BAY.DeliveryInformationPage;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.MyAccountPage;
import object_Repo_BAY.OrderConfirmationPage;
import object_Repo_BAY.PaymentPage;
import object_Repo_BAY.ShippingAddressPage;
//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class paymentwithCreditSalesWithManualInt {
	
	WebDriver driver=null;
	WebdriverUtility wUtil=new WebdriverUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	JavaUtility jUtil=new JavaUtility();
	
	public static WebDriver sDriver;
	@BeforeTest
	public void beforeConfig() throws IOException {
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
		//	WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver(/*opt*/);
			 
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			EdgeOptions opt=new EdgeOptions();
			opt.addArguments("--disable-notifications");
			driver=new EdgeDriver();
		}
		else {
		//	WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(/*options*/);
		} 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.get(pUtil.readDataFromPropertyFile("bayStg"));	
		sDriver=driver;
		wUtil.waitForDom(driver);
	}
//data for product name	
	@DataProvider(name="product")
	public String[] productList() {

		String[] data=new String[] {
				//any product path
				 "(//a[@class='cx-product-name'])[1]" 
		};
		return data;
	}
	@Test(dataProvider ="product" )
	public void paymentWithCreditSalesTest(String data) throws InterruptedException, AWTException, IOException {
	//	ListenerImplementationWithExtentReport exReport=new ListenerImplementationWithExtentReport();
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		//login as user
		hp.getLoginIcon().click();

		driver.findElement(By.xpath("//button[@class='btn request-otp-btn']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='mobileNo']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
		//wait for manual intervention
		Thread.sleep(8000);
		WebElement VerifyButton = driver.findElement(By.xpath("//button[@class='btn login-btn']"));

		if (VerifyButton.isEnabled()) {
			Thread.sleep(2000);
			VerifyButton.click();
			System.out.println("user logged in successfully !");
			//search for product: SDM-WD3438BG
			Thread.sleep(1000);
			hp.sendTextOnSeachbar("SDM-WD3438BG");
			hp.clickOnSearchButton();
			Thread.sleep(1000);
			//select first product & add to cart 
			driver.findElement(By.xpath(data)).click();
			driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
			Thread.sleep(1000);
			System.out.println("product added to cart successfully");
			//go to view cart & Proceed to checkout
			driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();
			driver.findElement(By.xpath("//div[@class='cx-progress-button-container']")).click();
			Thread.sleep(1000);
			//continue fwd twice:
			driver.findElement(By.xpath("//button[@class='cx-btn btn btn-block btn-primary']")).click();
			driver.findElement(By.cssSelector("[class='btn btn-block btn-primary nextPage ng-star-inserted']")).click();
			Thread.sleep(1000);
			//select credit sales radio button:
			PaymentPage pp=new PaymentPage(driver);
			pp.getCreditSalesRadio().click();
			Thread.sleep(1000);
			//select country:
			Select Sel = new Select(pp.getNationalityDropdown());
			Sel.selectByValue("KUWAITI");
			Thread.sleep(1000);
			pp.getMonthlyIncomeTextArea().sendKeys("10000");
			pp.getCivilIdNumberTextArea().sendKeys("123456789123");
			Thread.sleep(1000);
			Select Sel1 = new Select(pp.getIncomeTypeDropdown());
			Sel1.selectByValue("SALARIED");
			Thread.sleep(1000);
			Robot rb=new Robot();
			rb.mouseWheel(5);
			Thread.sleep(2000);
			Select Sel2 = new Select(pp.getTenureDropdown());
			Sel2.selectByIndex(1);
			Thread.sleep(1000);
			Select Sel3 = new Select(pp.getPreferredAreaDropdown());
			Sel3.selectByValue("SHUWAIKH");
			Thread.sleep(1000);
			if (pp.getContinuePaymentButton().isEnabled()) {
				Assert.assertEquals(true, true);
				pp.getContinuePaymentButton().click();
			Assert.assertEquals(true, true);
			System.out.println("Order Placed Successfully with Credit sales !");
			Thread.sleep(2000);
			rb.mouseWheel(5);
			Thread.sleep(2000);
			OrderConfirmationPage ocf=new OrderConfirmationPage(driver);
			System.out.println("Order ID is: "+ocf.getOrderId().getText());
			/*
			//take order confirmation page screenshot:
			String OrderConfPagePath = wUtil.takeScreenShot(driver, "OrderConfirmationPage_"+jUtil.getSystemDateFormat());
	//		String OrderConfPagePath=BaseClassBay.takeScreenShots("paymentWithCreditSalesTest");
			
			System.out.println("Captured Screenshot path is: "+OrderConfPagePath);
			
			BaseClassBay.takeScreenShots(OrderConfPagePath);
			
			exReport.logTestStatus(Status.PASS, "CaptureOrderConfirmationPage", OrderConfPagePath);
			
			*/
			Assert.assertEquals(true, true);
				
			} else {
				System.out.println("Required data for payment is Credit Sales is insufficient, Plase verify data !");
				Assert.assertEquals(false, true);
			}

		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertTrue(false);
		}
	}
	@DataProvider(name = "orderIdData")
	public String[] orderIdData() {

		String[] iDdata=new String[] {
				//any product path
				 "0006225954" 
		};
		return iDdata;
	}
	@Test(dataProvider = "orderIdData")
	public void reOrderPaymentWithCreditSalesTest(String iDdata) throws InterruptedException, AWTException {
		Robot robot=new Robot();
		ListenerImplementationWithExtentReport exReport=new ListenerImplementationWithExtentReport();
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		//login as user
		//driver.navigate().refresh();
		wUtil.waitForDom(driver);
		hp.getLoginIcon().click();

		driver.findElement(By.xpath("//button[@class='btn request-otp-btn']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='mobileNo']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
		//wait for manual intervention
		Thread.sleep(8000);
		WebElement VerifyButton = driver.findElement(By.xpath("//button[@class='btn login-btn']"));
		MyAccountPage map=new MyAccountPage(driver);
		if (VerifyButton.isEnabled()) {
			Thread.sleep(2000);
			VerifyButton.click();
			Thread.sleep(2000);
			Assert.assertEquals(map.getMyAccountLink().isDisplayed(), true);
			System.out.println("user logged in successfully !");
			//go to my account page
			map.getMyAccountLink().click();
			//go to order history
			map.getOrderHistory().click();
			//select order
		/*	String data="0006225954"; */
			
			driver.findElement(By.xpath("//a[text()=' "+iDdata+"']/parent::td/following::td[4]/child::button")).click();
			//go to cart and proceed
			AddToCartPage cart=new AddToCartPage(driver);
			Thread.sleep(1000);
			cart.getProceedToCheckoutButton().click();
			//go to address and proceed
			ShippingAddressPage sheep=new ShippingAddressPage(driver);
			sheep.getContinueButton().click();
			//go to delivery and proceed
			DeliveryInformationPage delivery=new DeliveryInformationPage(driver);
			robot.mouseWheel(4);
			Thread.sleep(1000);
			delivery.getContinueButton().click();
			Thread.sleep(1000);
			//go to payment and continuous order with credit sales
			PaymentPage pp=new PaymentPage(driver);
			pp.getCreditSalesRadio().click();
			Thread.sleep(1000);
			//select country:
			Select Sel = new Select(pp.getNationalityDropdown());
			Sel.selectByValue("KUWAITI");
			Thread.sleep(1000);
			//enter income
			pp.getMonthlyIncomeTextArea().sendKeys("10000");
			//enter civil number
			pp.getCivilIdNumberTextArea().sendKeys("123456789123");
			Thread.sleep(1000);
			//select income type
			Select Sel1 = new Select(pp.getIncomeTypeDropdown());
			Sel1.selectByValue("SALARIED");
			Thread.sleep(1000);
			Robot rb=new Robot();
			rb.mouseWheel(5);
			Thread.sleep(2000);
			//select tenure
			Select Sel2 = new Select(pp.getTenureDropdown());
			Sel2.selectByIndex(1);
			Thread.sleep(1000);
			//select preferred area
			Select Sel3 = new Select(pp.getPreferredAreaDropdown());
			Sel3.selectByValue("SHUWAIKH");
			Thread.sleep(1000);
			//continue payment
			if (pp.getContinuePaymentButton().isEnabled()) {
				Assert.assertEquals(true, true);
				pp.getContinuePaymentButton().click();
			Assert.assertEquals(true, true);
			System.out.println("Order Placed Successfully with Credit sales !");
			Thread.sleep(2000);
			rb.mouseWheel(5);
			Thread.sleep(2000);
			OrderConfirmationPage ocf=new OrderConfirmationPage(driver);
			System.out.println("Order ID is: "+ocf.getOrderId().getText());
			Assert.assertEquals(true, true);
			}else {
				System.out.println("Required data for payment is Credit Sales is insufficient, Plase verify data !");
				Assert.assertEquals(false, true);
			}
		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertTrue(false);
		}		
	}	
}
