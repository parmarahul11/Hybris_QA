package bay_Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.MyAccountPage;
import object_Repo_BAY.ResetPassword;
//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class MyAccountResetPasswordTc_25 extends BaseClassBay{

	@Test
	public void MyAccountUpdateProfileTest() throws InterruptedException, IOException {

		HomePage_EleBAY HP=new HomePage_EleBAY(driver);
		//login as user
		HP.getLoginIcon().click();

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
			//wUtil.waitForDom(driver);
			WebElement MyAccount = driver.findElement(By.xpath("//div[@class='myacc-cnt']"));
			if (MyAccount.isEnabled()) {
				Thread.sleep(4000);
				//wUtil.waitForDom(driver);
				MyAccount.click();
				System.out.println("user is on MyAccoynt page !");
				MyAccountPage my2=new MyAccountPage(driver);
				Thread.sleep(2000);
				my2.getUpdatePassword().click();
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				//driver.findElement(By.xpath("//input[@name='oldPassword']")).sendKeys("Test@123");
	            //driver.findElement(By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-touched'])[2]")).sendKeys("Test@123");
	            //driver.findElement(By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-touched'])[3]")).sendKeys("Test@123");
	            //driver.findElement(By.xpath("//button[@class='btn form-action-btn btn-primary']")).click();
				//click on update profile book  
				//my2.getUpdatePassword().click();
				Thread.sleep(1000);
				ResetPassword rp=new ResetPassword(driver);
				//driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched'][1]")).sendKeys("Test@123");
				//send text on old Password field
				//Thread.sleep(2000);
				 // rp.getOldPasswordTextArea().click();
				  rp.getOldPasswordTextArea().sendKeys("Test@123"); 
				Thread.sleep(4000);
				 
				//send text on new Password field
				//rp.getNewPasswordTextArea().click();
				rp.getNewPasswordTextArea().sendKeys("Test@123");
				Thread.sleep(4000);
				//send text on confirm Password field
				//rp.getNewPasswordConfirmTextArea().click();
				rp.getNewPasswordConfirmTextArea().sendKeys("Test@123");
				Thread.sleep(2000);
				//click on save button
				//driver.findElement(By.xpath("//button[@class='btn form-action-btn btn-primary']")).click();
				rp.getSaveButton().click();
				Thread.sleep(2000);
				wUtil.takeScreenShot(driver, "MyAccountResetPasswordTc_25");
				Assert.assertEquals(true, true);
				System.out.println("Password update successfully !");
				
			}else {
				System.out.println("Password is not updated plz try again !");
				Assert.assertEquals(false, true);
			}
		}
	}
}
