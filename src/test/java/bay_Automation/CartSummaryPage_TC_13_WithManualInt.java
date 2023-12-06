package bay_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class CartSummaryPage_TC_13_WithManualInt extends BaseClassBay{

	/**@throws InterruptedException 
	 * @scenario:
	 * 
	 * Select and Add multiple products in to the cart
	 1. Select and Add multiple products in to the cart
	 2. Verify that cart summary page is updated acordingly add/remove products
	 3. Update quantity for any single /multiple products
	 4. Verify that user is having option to 'Proceed to checkout
	 * 
	 */

	@Test
	public void cartSummaryPageTest() throws InterruptedException {

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
			//select first product 
			driver.findElement(By.xpath("(//a[@class='cx-product-name'])[2]")).click();
			//add first product to cart 
			driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
			Thread.sleep(1000);
			//click on cross button
			driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();
			//navigate to plp page
			driver.navigate().back();
			Thread.sleep(1000);
			//select second product 
			driver.findElement(By.xpath("(//a[@class='cx-product-name'])[3]")).click();
			Thread.sleep(1000);
			// add second product to cart 
			driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
			Thread.sleep(1000);
			System.out.println("Two products added to cart successfully");
			//quantity increase by one
			driver.findElement(By.xpath("//button[@aria-label='Add one more']")).click();  
			Thread.sleep(1000);
			//go to view cart
			driver.findElement(By.xpath("//a[@cxmodalreason='View Cart click']")).click();
			Thread.sleep(2000);
			//			//Verify that user is having option to 'Proceed to checkout
			String ExpProceedToCheckoutButton="Proceed To Checkout";
			String actualProceedToCheckoutButton = driver.findElement(By.xpath("//div[@class='cx-progress-button-container']")).getText();
			//System.out.println(actualProceedToCheckoutButton.getText().toString());
			if (actualProceedToCheckoutButton.contains(ExpProceedToCheckoutButton)) {
				Assert.assertEquals(true, true);
				System.out.println("user is having option to 'Proceed to checkout(verified) !");
			}else {
				System.out.println("Proceed to checkout element not found (not verified)");
				Assert.assertTrue(false);
			}	
		}else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertEquals(false, true);
		}


		/*
		driver.findElement(By.xpath("//button[@class='cx-btn btn btn-block btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary nextPage ng-star-inserted']")).click();
		Thread.sleep(1000);
		String ExpectedCheckoutPageTitle = "";
		String actualCheckoutPageTitle = driver.getTitle();
		System.out.println(actualCheckoutPageTitle);
		Assert.assertEquals(ExpectedCheckoutPageTitle, actualCheckoutPageTitle);
		System.out.println("");
		 */
	}
}
