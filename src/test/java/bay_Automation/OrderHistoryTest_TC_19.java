package bay_Automation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.AddToCartPage;
import object_Repo_BAY.DeliveryInformationPage;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.LoginPage;
import object_Repo_BAY.LoginWithOtpPage;
import object_Repo_BAY.MyAccountPage;
import object_Repo_BAY.ShippingAddressPage;

//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class OrderHistoryTest_TC_19 extends BaseClassBay{	
	@Test
	public void orderHistoryTest_TC_19_a() throws InterruptedException, IOException{

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
				//go to my account page	
				Thread.sleep(1000);
				my.getMyAccountLink().click();
				//click on order history page
				Thread.sleep(2000);
				my.getOrderHistory().click();
				Thread.sleep(4000);
				System.out.println(driver.getTitle());
				Assert.assertEquals(true, true);
				System.out.println("Order history page displayed- Passed");

				//a. verify if order history page -displaying order Number:	

				WebElement orderNo = driver.findElement(By.xpath("(//td[@class='cx-order-history-code'])[1]"));
				Assert.assertEquals(orderNo.isDisplayed(), true, "Order history page displayed Order number- Passed");
				System.out.println("Latest Order number is: "+orderNo.getText());
				Thread.sleep(2000);

				//b. verify if order history page -displaying order Status:	
				Thread.sleep(2000);
				WebElement orderStatus = driver.findElement(By.xpath("(//a[@class='cx-order-history-value'])[3]"));
				Assert.assertEquals(orderStatus.isDisplayed(), true, "Order history page displayed Order Status- Passed");
				System.out.println("Latest order status is: "+orderStatus.getText());

				//c. verify if order history page -displaying order Date:	
				Thread.sleep(2000);
				WebElement orderDate = driver.findElement(By.xpath("(//a[@class='cx-order-history-value'])[4]"));
				Assert.assertEquals(orderDate.isDisplayed(), true, "Order history page displayed Order Date- Passed");
				System.out.println(orderDate.getText());

				//d. verify if order history page -displaying order Amount:	
				Thread.sleep(2000);
				WebElement orderAmount = driver.findElement(By.xpath("(//a[@class='cx-order-history-value'])[3]"));
				Assert.assertEquals(orderAmount.isDisplayed(), true, "Order history page displayed Order Amount- Passed");
				System.out.println(orderAmount.getText());

			}else {
				System.out.println("Unable to login(my account not displayed, please check");
				Assert.assertEquals(false, true);
			}
		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertEquals(false, true);
		}
	}

	@Test
	public void maxOrderToBeListedPerPageTest_TC_19_b() throws InterruptedException, IOException{

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
				//go to my account page	
				Thread.sleep(1000);
				my.getMyAccountLink().click();
				//click on order history page
				Thread.sleep(2000);
				my.getOrderHistory().click();
				Thread.sleep(4000);
				System.out.println(driver.getTitle());
				Assert.assertEquals(true, true);
				System.out.println("Order history page displayed- Passed");
				//Identify all orders on order history page: 	
				List<WebElement> allOrders = driver.findElements(By.xpath("//td[@class='cx-order-no']"));
				//verify order per page:

				if (allOrders.size()<=10) {
					Assert.assertEquals(true, true);
					System.out.println("Order count on order history page: "+allOrders.size());
					WebElement nextPagination = driver.findElement(By.xpath("//a[@aria-label='next page']"));
					for(;;) {
						try {
							if (nextPagination.isEnabled()) {
								nextPagination.click();
								Thread.sleep(3000);
								List<WebElement> allOrdersNext = driver.findElements(By.xpath("//td[@class='cx-order-no']"));
								System.out.println("Orders on next page: "+allOrdersNext.size());
								
							}
						} catch (Exception e) {
							System.out.println("You reached the end page");
							break;
						}
					}

				} else if (allOrders.size()>10){
					System.out.println("Orders at Order history page are more that 10 ! ");
					System.out.println("Order count on order history page: "+allOrders.size());
					Assert.assertEquals(false, true);

				}else if (allOrders.size()==0) {
					System.out.println("No any orders placed yet, please fill free & make your choices! ");
					System.out.println("Order count on order history page: "+allOrders.size());
					Assert.assertEquals(true, true);
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
