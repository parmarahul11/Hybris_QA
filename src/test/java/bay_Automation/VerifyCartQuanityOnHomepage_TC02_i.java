package bay_Automation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;

//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class VerifyCartQuanityOnHomepage_TC02_i extends BaseClassBay {

	@DataProvider
	public String[] productList() {

		String[] data = new String[] {
				// any product path
				"(//a[@class='cx-product-name'])[2]"

		};
		return data;
	}

	@Test(dataProvider = "productList")
	public void verifyCartQuanityOnHomepage_TC02_i(String data) throws InterruptedException {
		HomePage_EleBAY hp = new HomePage_EleBAY(driver);
		wUtil.waitForDom(driver);
		// login as user
		hp.getLoginIcon().click();

		driver.findElement(By.xpath("//button[@class='btn request-otp-btn']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='mobileNo']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
		// wait for manual intervention
		Thread.sleep(8000);
		WebElement VerifyButton = driver.findElement(By.xpath("//button[@class='btn login-btn']"));

		if (VerifyButton.isEnabled()) {
			Thread.sleep(2000);
			VerifyButton.click();
			System.out.println("user logged in successfully !");
			driver.navigate().refresh();
			Thread.sleep(4000);
			// 1. get cart quantity after login and before add to cart

			String cartQtyBefore = hp.getMinicartQuantity().getText();
			int CARTQTYBEFORE = Integer.parseInt(cartQtyBefore);
			System.out.println("Current mini cart QTY: " + CARTQTYBEFORE);
			// search for product
			hp.sendTextOnSeachbar("Apple IPhone 15Pro");
			hp.clickOnSearchButton();
			Thread.sleep(1000);
			// select any product
			driver.findElement(By.xpath(data)).click();
			// add product to cart
			driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			// 2. get cart quantity after add to cart

			String cartQtyAfter = hp.getMinicartQuantity().getText();
			int CARTQTYAFTER = Integer.parseInt(cartQtyAfter);

			if (CARTQTYAFTER == (CARTQTYBEFORE + 1)) {
				Assert.assertEquals(true, true);
				System.out.println("Cart quantity updated Successfully by One(+1) ");
				System.out.println("mini cart QTY after update: " + CARTQTYAFTER);
			} else {
				Assert.assertEquals(false, true);
				System.out.println("Cart quantity Not updated, pls check...!");
			}

		} else {
			System.out.println("User not get logged in, Please login to Proceed !");
			Assert.assertEquals(false, true);
		}

	}

}
