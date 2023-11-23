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
import org.testng.annotations.Test;

import generic.utilities.BaseClassBay;

public class RecaptchaTest extends BaseClassBay{
	
	@Test
	public void reCaptchaHandling(/*String userId,String password */) throws IOException, InterruptedException {
	/*	ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		opt.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(opt);
		
		driver.get("https://best.com.kw/en/");
	*/
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[.='Login']")).click();
		String userId=pUtil.readDataFromPropertyFile("userId");
		String password=pUtil.readDataFromPropertyFile("password");
		
		driver.findElement(By.xpath("//*[@formcontrolname='userId']")).sendKeys(userId);
		driver.findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
		
		Thread.sleep(2000);
		
		WebElement reCaptcha=driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
	//	wait.until(ExpectedConditions.visibilityOf(reCaptcha));
	//  driver.switchTo().frame(reCaptcha);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
		
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
		
	//	driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
		
		Thread.sleep(20000);
			
		driver.switchTo().parentFrame();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
		
		Thread.sleep(1500);
	}
}
