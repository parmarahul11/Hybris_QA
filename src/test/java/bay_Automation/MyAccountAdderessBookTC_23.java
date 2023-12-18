package bay_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.AddressBookPage;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.MyAccountPage;
//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class MyAccountAdderessBookTC_23 extends BaseClassBay{

	@Test
	public void MyAccountAdderessBookTC_23Test_2() throws InterruptedException {

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
			WebElement MyAccount = driver.findElement(By.xpath("//div[@class='myacc-cnt']"));
			
			if (MyAccount.isEnabled()) {
				Thread.sleep(2000);
				MyAccount.click();
				System.out.println("user is on MyAccount page !");
				MyAccountPage my=new MyAccountPage(driver);
//				Thread.sleep(2000);
//				if ((my.getH2header()).isDisplayed()) {
//					Assert.assertEquals(true, true);
//					System.out.println(my.getH2header().getText());		
//				}
				
				//click on adderess book  
				my.getAdderessBook().click();
				Thread.sleep(1000);
				AddressBookPage ab=new AddressBookPage(driver);
				//click on edit address
				ab.getEditFirstAdressButton().click();
				//send text on the lastfield name
				ab.getLastNameTextArea().clear();
				ab.getLastNameTextArea().sendKeys("k2852556k");
				Thread.sleep(1000);
				
				//click submit button
				ab.getSubmitButtonOnAddressBook().click();
				Thread.sleep(2000);
				//navigate to plp page
				//driver.navigate().back();
				
				//click on adderess book  
				//my.getAdderessBook().click();
				//Thread.sleep(1000);
				
				Assert.assertEquals(true, true);
				System.out.println("Adderess update successfully !");
				
			}else {
				System.out.println("Adderess is not updated plz try again !");
				Assert.assertTrue(false);
			}
		}}}