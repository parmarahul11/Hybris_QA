package bay_Automation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.AddToCartPage;
import object_Repo_BAY.DeliveryInformationPage;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.LoginPage;
import object_Repo_BAY.LoginWithOtpPage;
import object_Repo_BAY.MyAccountPage;
import object_Repo_BAY.ShippingAddressPage;

public class ModesOfPaymentCheck_TC14_Additional extends BaseClassBay {

	@Test
	public void allPayementModesTest_TC_14() throws IOException, InterruptedException {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		LoginPage lp=new LoginPage(driver);
		LoginWithOtpPage lwp=new LoginWithOtpPage(driver);
		MyAccountPage my=new MyAccountPage(driver);

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
				Thread.sleep(1000);
				hp.sendTextOnSeachbar(pUtil.readDataFromPropertyFile("searchProductWithName"));
				hp.clickOnSearchButton();
				Thread.sleep(1000);
				//select any product & add to cart 
				driver.findElement(By.xpath("(//a[@class='cx-product-name'])[2]")).click();
				driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
				Thread.sleep(1000);
				System.out.println("product added to cart successfully");
				//go to view cart
				driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();

				//go to view cart & Proceed to checkout
				AddToCartPage ac=new AddToCartPage(driver);
				ac.getProceedToCheckoutButton().click();
				//continue forword from shipping address page
				ShippingAddressPage sh=new ShippingAddressPage(driver);
				sh.getContinueButton().click();
				//continue forword from Delivery information page
				DeliveryInformationPage di=new DeliveryInformationPage(driver);
				di.getContinueButton().click();
				//get all payment modes and verify
				List<WebElement> allPaymentModes = driver.findElements(By.xpath("//div[@class='form-check']"));

				for(int i=0;i<allPaymentModes.size();i++) {
					String paymentMode = allPaymentModes.get(i).getText();
				//	System.out.println(paymentMode);

					if (paymentMode.contains("KNET")) {
						System.out.println("KNET delivery mode is available and is displayed- passed");
						System.out.println(allPaymentModes.get(i).getText());
						Assert.assertEquals(true, true);
					}else if (paymentMode.contains("Card")) {
						System.out.println("Credit Card delivery mode is available and is displayed- passed");
						System.out.println(allPaymentModes.get(i).getText());
						Assert.assertEquals(true, true);
					}else if (paymentMode.contains("Credit")) {
						System.out.println("Credit Sales delivery mode is available and is displayed- passed");
						System.out.println(allPaymentModes.get(i).getText());
						Assert.assertEquals(true, true);
					}else if (paymentMode.contains("E-Wallet")) {
						System.out.println("E-Wallet delivery mode is available and is displayed- passed");
						System.out.println(allPaymentModes.get(i).getText());
						Assert.assertEquals(true, true);
					}else if (paymentMode.contains("Loyalty")) {
						System.out.println("Loyalty Points delivery mode is available and is displayed- passed");
						System.out.println(allPaymentModes.get(i).getText());
						Assert.assertEquals(true, true);
					}else {
						System.out.println("Payment modes are not displaying-please check !");
						Assert.assertEquals(false, true);
					}	
				}
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
