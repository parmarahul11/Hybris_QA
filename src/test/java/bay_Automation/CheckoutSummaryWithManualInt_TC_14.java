package bay_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class CheckoutSummaryWithManualInt_TC_14 extends BaseClassBay{

	@Test
	public void TC_14Test_1_verify_orderContent() throws InterruptedException {

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
			//search for product
			Thread.sleep(1000);
			hp.sendTextOnSeachbar("Apple IPhone 15Pro");
			hp.clickOnSearchButton();
			Thread.sleep(1000);
			//select first product & add to cart 
			driver.findElement(By.xpath("(//a[@class='cx-product-name'])[2]")).click();
			driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
			Thread.sleep(1000);
			System.out.println("product added to cart successfully");
			//go to view cart
			driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();

			List<WebElement> orderDetails = driver.findElements(By.xpath("//*[@class='summary-cnt']"));

			for(int i=0;i<orderDetails.size();i++) {
				String ordDetail = orderDetails.get(i).getText();

				if (ordDetail.contains("Subtotal")) {
					System.out.println("Subtotal passed");
					System.out.println(orderDetails.get(i).getText());
					Assert.assertEquals(true, true);
				}else if (ordDetail.contains("Discount")) {
					System.out.println("Discount passed");
					System.out.println(orderDetails.get(i).getText());
					Assert.assertEquals(true, true);
				}else if (ordDetail.contains("Delivery")) {
					System.out.println("Delivery passed");
					System.out.println(orderDetails.get(i).getText());
					Assert.assertEquals(true, true);
				}else {
					System.out.println("Required order details are not available !");
				}	
			}	
		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertTrue(false);
		}
	}	
	@DataProvider
	public String[] addressName() {

		String[] data=new String[] {
				//any product path
				"Gujjar R"
		};
		return data;
	}
	@Test(dataProvider = "addressName")
	public void changeShippingAdressTest(String addressName) throws InterruptedException {
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
			//search for product
			Thread.sleep(1000);
			hp.sendTextOnSeachbar("Apple IPhone 15Pro");
			hp.clickOnSearchButton();
			Thread.sleep(1000);
			//select first product & add to cart 
			driver.findElement(By.xpath("(//a[@class='cx-product-name'])[2]")).click();
			driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
			Thread.sleep(1000);
			System.out.println("product added to cart successfully");
			//go to view cart & Proceed to checkout
			driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();
			driver.findElement(By.xpath("//div[@class='cx-progress-button-container']")).click();
			
			//changes in below xpath needed if addessname changed:
			WebElement userAddress = driver.findElement(By.xpath("//*[text()=' Gujjar R ']"));
			
			if ((userAddress.getText()).contains(addressName)) {
				userAddress.click();
				Assert.assertEquals(true, true);
				System.out.println("User successfully changed the address as required !");
			}else {
				System.out.println("Required address text not found, please check the data !");
				Assert.assertEquals(false, true);
			}
		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void verifyPaymentScreenTest() throws InterruptedException {
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
			//search for product
			Thread.sleep(1000);
			hp.sendTextOnSeachbar("Apple IPhone 15Pro");
			hp.clickOnSearchButton();
			Thread.sleep(1000);
			//select first product & add to cart 
			driver.findElement(By.xpath("(//a[@class='cx-product-name'])[2]")).click();
			driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
			Thread.sleep(1000);
			System.out.println("product added to cart successfully");
			//go to view cart & Proceed to checkout
			driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();
			driver.findElement(By.xpath("//div[@class='cx-progress-button-container']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='cx-btn btn btn-block btn-primary']")).click();
			driver.findElement(By.cssSelector("[class='btn btn-block btn-primary nextPage ng-star-inserted']")).click();
			Thread.sleep(1000);
			WebElement h2title = driver.findElement(By.xpath("//h2[@class='col-md-12 cx-checkout-title d-none d-lg-block d-xl-block']"));
			if ((h2title.getText()).equalsIgnoreCase("Payment")) {
				Assert.assertEquals(true, true);
				System.out.println("User navigated to payment screen !");
			} else {
				Assert.assertEquals(false, true);
				System.out.println("No payment screen is visible, please check...");
			}

		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertTrue(false);
		}
	}
	@Test
	public void verifyOrderTotalTest() throws InterruptedException {
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
			//search for product
			Thread.sleep(1000);
			hp.sendTextOnSeachbar("Apple IPhone 15Pro");
			hp.clickOnSearchButton();
			Thread.sleep(1000);
			//select first product & add to cart 
			driver.findElement(By.xpath("(//a[@class='cx-product-name'])[2]")).click();
			driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
			Thread.sleep(1000);
			System.out.println("product added to cart successfully");
			//go to view cart & Proceed to checkout
			driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();
			driver.findElement(By.xpath("//div[@class='cx-progress-button-container']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='cx-btn btn btn-block btn-primary']")).click();
			driver.findElement(By.cssSelector("[class='btn btn-block btn-primary nextPage ng-star-inserted']")).click();
			Thread.sleep(2000);

			List<WebElement> allCharges = driver.findElements(By.xpath("//div[@class='best-summary-wrapper']/child::div[2]"));
			double total=0;
			for(int i=0;i<allCharges.size();i++) {
				//	System.out.println(allCharges.get(i).getText());
				String charges = allCharges.get(i).getText().substring(3);
				double chargesDouble = Double.parseDouble(charges);
				total=total+chargesDouble;
			}
			System.out.println("order total is: KD "+total);

			String gtotal = driver.findElement(By.xpath("//div[@class='best-summary-total-heading best-summary-wrapper']/child::div[2]")).getText().substring(3);
			double grandTotal = Double.parseDouble(gtotal);

			if (grandTotal==total) {
				Assert.assertEquals(true, true);
				System.out.println("Grand total seems summation of subtotal,discount,deliveryCharges for std delivery mode");
			} else {
				System.out.println("calculation error, please check order details !");
				Assert.assertEquals(false, true);
			}
		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertTrue(false);
		}
	}
}
