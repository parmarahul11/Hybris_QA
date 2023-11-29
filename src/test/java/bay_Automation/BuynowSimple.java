package bay_Automation;
import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generic.utilities.BaseClassBay;
import generic.utilities.DataproviderBAY;
import object_Repo_BAY.HomePage_EleBAY;
@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class BuynowSimple extends BaseClassBay {
	@DataProvider
	public String[] productList() {
		String[] data=new String[] {
				//any product xpath
				"(//a[@class='cx-product-name'])[2]"
		};
		return data;
	}
	@Test(dataProvider = "productList")
	public void InStock(String data) throws Exception {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar(" SKU : SM-F731BLIAMEA-SG ");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();
		String stockStatus = driver.findElement(By.xpath("//span[@class='instock']")).getText();
		System.out.println(stockStatus);
		String inStock="In Stock";
		if (stockStatus.equals(inStock)) {
			driver.findElement(By.xpath("//*[text()=' Buy Now ']")).click();
			System.out.println("button is enabled");
			Assert.assertTrue(true);
		}else {
			throw new Exception("button is disabled, please verified stock");
		}
	}
}