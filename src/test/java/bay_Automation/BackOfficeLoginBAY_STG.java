package bay_Automation;

import java.io.IOException;
import java.time.Duration;

import org.bouncycastle.crypto.prng.drbg.DualECPoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.utilities.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo_BAY.BAckOfficePages;

public class BackOfficeLoginBAY_STG {

	
	@Test
	public void backOfficeLoginTest() throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//go to backOffice
		driver.get("https://backoffice.ctxzq48eta-easahussa1-s1-public.model-t.cc.commerce.ondemand.com/backoffice/login.zul");
		//login
		BAckOfficePages back=new BAckOfficePages(driver);
		PropertyFileUtility pUtil=new PropertyFileUtility();
		Thread.sleep(2000);
		back.getUsernameTextField().sendKeys(pUtil.readDataFromPropertyFile("backOfficeUsername"));
		Thread.sleep(2000);
		back.getPasswordTextField().sendKeys(pUtil.readDataFromPropertyFile("backOffcePasssword"));
		Thread.sleep(2000);
		back.getSignInButton().click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(back.getSearchBarTextArea()));
		
		back.getSearchBarTextArea().sendKeys("business");
		
		
		
	}
}
