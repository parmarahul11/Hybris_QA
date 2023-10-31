package CaptchaHandling;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import generic.utilities.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class NLPCaptcha {

	@Test
	public void handleNLPCaptcha() throws InterruptedException, IOException, TesseractException {

		//WebDriverManager.chromedriver().setup();

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		opt.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(opt);

		driver.get("https://www.irctc.co.in/nget/train-search");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.=' LOGIN ']")).click();
		Thread.sleep(2000);
		File src = driver.findElement(By.xpath("//img[@class='captcha-img']")).getScreenshotAs(OutputType.FILE);
		JavaUtility jUtil=new JavaUtility();
		String path=System.getProperty("user.dir")+"/CaptchScreenshots/captchaShot"+jUtil.getSystemDateFormat()+".png";

		FileHandler.copy(src, new File(path));

		ITesseract image=new Tesseract();
		
		String imageText = image.doOCR(new File(path));
		
		System.out.println(imageText);
		
		driver.findElement(By.id("captcha")).sendKeys(imageText);
		
		
	}
}
