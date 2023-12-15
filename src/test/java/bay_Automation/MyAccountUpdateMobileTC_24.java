package bay_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.MyAccountPage;
import object_Repo_BAY.UpdateMobileAndEmailPage;

//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class MyAccountUpdateMobileTC_24 extends BaseClassBay {

	@Test(priority = 1)
	public void MyAccountMobileNumberUpdateTestTC_24() throws InterruptedException {

		HomePage_EleBAY ma = new HomePage_EleBAY(driver);
		// login as user
		ma.getLoginIcon().click();

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
			// search for product
			Thread.sleep(1000);
			// wUtil.waitForDom(driver);
			WebElement MyAccount = driver.findElement(By.xpath("//div[@class='myacc-cnt']"));
			if (MyAccount.isEnabled()) {
				Thread.sleep(4000);
				// wUtil.waitForDom(driver);
				MyAccount.click();
				System.out.println("user is on MyAccoynt page !");
				MyAccountPage my1 = new MyAccountPage(driver);
				Thread.sleep(2000);
				// click on update profile book
				my1.getUpdateMobileNumber().click();
				Thread.sleep(1000);
				UpdateMobileAndEmailPage ab = new UpdateMobileAndEmailPage(driver);
				// send text on the New mobile number field
				ab.getNewMobileNumberTextArea().sendKeys("94945151");
				Thread.sleep(2000);
				// send text on the confirm New mobile number field
				ab.getConfirmNewMobileNumberTextArea().sendKeys("94945151");
				Thread.sleep(1000);
				// send text on Password field
				ab.getPasswordTextArea().sendKeys("Test@123");
				Thread.sleep(1000);

				// click update button
				// driver.findElement(By.xpath("//button[@class='btn form-action-btn
				// btn-primary']")).click();
				ab.getUpdateButton().click();
				Thread.sleep(2000);
				Assert.assertEquals(true, true);
				System.out.println("Mobile number update successfully !");

			} else {
				System.out.println("Mobile number is already exist !");
				Assert.assertEquals(false, true);
			}
		}
	}

	@Test(priority = 2)
	public void MyAccountEmailUpdateTest() throws InterruptedException {

		HomePage_EleBAY ma = new HomePage_EleBAY(driver);
		// login as user
		ma.getLoginIcon().click();

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
			// search for product
			Thread.sleep(1000);
			// wUtil.waitForDom(driver);
			WebElement MyAccount = driver.findElement(By.xpath("//div[@class='myacc-cnt']"));
			if (MyAccount.isEnabled()) {
				Thread.sleep(4000);
				// wUtil.waitForDom(driver);
				MyAccount.click();
				System.out.println("user is on MyAccoynt page !");
				MyAccountPage my1 = new MyAccountPage(driver);
				Thread.sleep(2000);
				// click on update email ID
				my1.getUpdateEmailId().click();
				// wait for manual intervention
				Thread.sleep(8000);
				UpdateMobileAndEmailPage ab2 = new UpdateMobileAndEmailPage(driver);
				// click on Verify button
				ab2.getVerifyButtonOnEmailOtp().click();
				Thread.sleep(4000);
				// send text on the New eamil field
				ab2.getEnterNewEmailTextField().sendKeys("jayviru@gmail.com");
				Thread.sleep(1000);
				// send text on Password field
				ab2.getConfirmEmailTextField().sendKeys("jayviru@gmail.com");
				Thread.sleep(1000);

				// click update button
				// driver.findElement(By.xpath("//button[@class='btn form-action-btn
				// btn-primary']")).click();
				ab2.getUpdateButton1().click();
				Thread.sleep(2000);
				Assert.assertEquals(true, true);
				System.out.println("Email adderess update successfully !");

			} else {
				System.out.println("Email adderess is already exist !");
				Assert.assertEquals(false, true);
			}
		}
	}
}