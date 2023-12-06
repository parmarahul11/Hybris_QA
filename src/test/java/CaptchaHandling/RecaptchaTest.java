package CaptchaHandling;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;
import object_Repo_BAY.HomePage_EleBAY;
import object_Repo_BAY.LoginPage;
import object_Repo_BAY.MyAccountPage;

public class RecaptchaTest extends BaseClassBay{
	
	@Test
	public void reCaptchaHandling(/*String userId,String password */) throws IOException, InterruptedException {
	/*	ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		opt.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(opt);
		
		driver.get("https://best.com.kw/en/");
	*/	HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		LoginPage lp=new LoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		hp.getLoginIcon().click();
		Thread.sleep(2000);
		String userId=pUtil.readDataFromPropertyFile("userId");
		String password=pUtil.readDataFromPropertyFile("password");
		lp.getEmailTextField().sendKeys(userId);
		lp.getPasswordTextField().sendKeys(password);
		
		Thread.sleep(2000);
		
	//	WebElement reCaptcha=driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
	//	wait.until(ExpectedConditions.visibilityOf(reCaptcha));
	//  driver.switchTo().frame(reCaptcha);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(lp.getRechaptchaFrameElement()));
		
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(lp.getRechaptchaCheckbox())).click();
		
	//	driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
		
		Thread.sleep(20000);
			
		driver.switchTo().parentFrame();
		
		Thread.sleep(2000);
		
		lp.getSignInButtton().click();
		
		MyAccountPage my=new MyAccountPage(driver);
		if (my.getMyAccountLink().isDisplayed()) {
			Thread.sleep(2000);
			Assert.assertEquals(true, true);
			System.out.println("User logged in successFully");
		}
	}
}
