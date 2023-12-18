package bay_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import generic.utilities.JavaUtility;
import generic.utilities.PropertyFileUtility;
import generic.utilities.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo_BAY.AddToCartPage;
import object_Repo_BAY.DeliveryInformationPage;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.LoginPage;
import object_Repo_BAY.LoginWithOtpPage;
import object_Repo_BAY.MyAccountPage;
import object_Repo_BAY.OrderConfirmationPage;
import object_Repo_BAY.PaymentPage;
import object_Repo_BAY.ShippingAddressPage;

public class PaymentWithVoucherAppliedTest_TC_16  {

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
	@DataProvider(name = "coupenData")
	public String[] orderIdData() {

		String[] coupen=new String[] {
				//any product path
				"j2o5qECQxBWD" 
		};
		return coupen;
	}
	@Test(dataProvider = "coupenData")
	public void paymentWithVoucherTestTC_16(String coupen) throws IOException, InterruptedException, AWTException {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		LoginPage lp=new LoginPage(driver);
		LoginWithOtpPage lwp=new LoginWithOtpPage(driver);
		MyAccountPage my=new MyAccountPage(driver);
		AddToCartPage ac=new AddToCartPage(driver);
		ShippingAddressPage sh=new ShippingAddressPage(driver);
		DeliveryInformationPage di=new DeliveryInformationPage(driver);
		PaymentPage pp=new PaymentPage(driver);

		//go to login page
		hp.getLoginIcon().click();
		//go to login with otp page
		lp.getLoginWithOtpButton().click();
		//enter mobile number on otp page
		lwp.getMobilenumberTextField().sendKeys(pUtil.readDataFromPropertyFile("loginwithMobileNumber"));
		Thread.sleep(3000);
		lwp.getRequestOtpButton().click();
		//wait for manual intervention to enter otp
		Thread.sleep(8000);

		if ((lwp.getVerifyButtonAfterOtpEnter()).isEnabled()) {
			Thread.sleep(1000);
			lwp.getVerifyButtonAfterOtpEnter().click();
			Assert.assertEquals(true, true);
			Thread.sleep(2000);
			if (my.getMyAccountLink().isDisplayed()) {
				Assert.assertEquals(true, true);
				System.out.println("user logged in successfully-My Account module displayed");
				//search for product
				Thread.sleep(500);
				hp.sendTextOnSeachbar(pUtil.readDataFromPropertyFile("searchProductWithName"));
				hp.clickOnSearchButton();
				Thread.sleep(1000);
				//select any product & add to cart 
				driver.findElement(By.xpath("(//a[@class='cx-product-name'])[1]")).click();
				WebElement addTocartButton = driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']"));
				if (addTocartButton.isEnabled()) {
					Assert.assertEquals(true, true);
					System.out.println("product is in stock, user can add to cart ");
					
				} else {
					System.out.println("Product is out of stock, add product to wishlist so you buy once stock is available");
					Assert.assertEquals(false, true);
				}
				Thread.sleep(1000);
				addTocartButton.click();
				System.out.println("product added to cart successfully");
				//go to view cart
				driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();
				//grant total before:
				String grandTotalB = ac.getGrandTotalPrice().getText().substring(3);
				Double grandTotalBefore = Double.parseDouble(grandTotalB);
				System.out.println(grandTotalBefore);
				//apply voucher:
				ac.getCoupenCodeTextArea().sendKeys(coupen);
				Thread.sleep(1000);
				ac.getCoupenCodeApplyButton().click();
				//get coupon alert text
				WebElement alertText = driver.findElement(By.xpath("//div[@class='alert alert-success ng-star-inserted']"));
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(alertText));
				System.out.println(alertText.getText());
				//grant total after
				String grantTotalA = ac.getGrandTotalPrice().getText().substring(3);
				double grantTotalAfter = Double.parseDouble(grantTotalA);
				System.out.println(grantTotalAfter);
				if (grantTotalAfter<grandTotalBefore) {
					Assert.assertEquals(true, true);
					System.out.println("Discount is reflecting in grand total-coupen passed");
				} else {
					System.out.println("Coupen not applied, pls check if it is a valid coupen !");
					Assert.assertEquals(false, true);
				}
				Thread.sleep(3000);
				//go to view cart & Proceed to checkout
				ac.getProceedToCheckoutButton().click();
				//continue forword from shipping address page
				sh.getContinueButton().click();
				//continue forword from Delivery information page
				di.getContinueButton().click();
				
		/*		Thread.sleep(1000);
				//go to payment and continuous order with credit sales
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
		*/
			}else {
				System.out.println("Unable to login(my account not displayed, please check");
				Assert.assertEquals(false, true);
			}
		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertEquals(false, true);
		}

	}

}
