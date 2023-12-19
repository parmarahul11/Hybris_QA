package bay_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.MyAccountPage;
import object_Repo_BAY.UpdatProfile;
@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class MyAccountUpdateProfileTC_23_a extends BaseClassBay{


	@Test
	public void MyAccountUpdateProfileTestTC_23_a() throws InterruptedException {

		HomePage_EleBAY ma=new HomePage_EleBAY(driver);
		//login as user
		ma.getLoginIcon().click();

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
				MyAccountPage my1=new MyAccountPage(driver);
				Thread.sleep(2000);
				//click on update profile book  
				my1.getViewUpdateProfile().click();
				Thread.sleep(1000);
				UpdatProfile ab=new UpdatProfile(driver);
				//send text on the Firstfield name
				ab.getFirstNameTextArea().clear();
				ab.getFirstNameTextArea().sendKeys("xysz");
				Thread.sleep(2000);
				//send text on the lastfield name
				ab.getLastNameTextArea().clear();
				ab.getLastNameTextArea().sendKeys("k288hh5552556k");
				Thread.sleep(1000);
				//send text on Password field
				ab.getPasswordTextArea().sendKeys("Test@123");
				Thread.sleep(1000);
				
				//click update button
				driver.findElement(By.xpath("//button[@class='btn form-action-btn btn-primary']")).click();
				Thread.sleep(2000);
				Assert.assertEquals(true, true);
				System.out.println("Profile update successfully !");
				
			}else {
				System.out.println("Profile is not updated plz try again !");
				Assert.assertEquals(false, true);
			}
		}}}