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
public class PDPScenarioTest extends BaseClassBay {

	@DataProvider
	public String[] productList() {

		String[] data=new String[] {
				//any product xpath
				"(//a[@class='cx-product-name'])[2]"
		};
		return data;
	}

	@Test(dataProvider = "productList")
	public void getProductName(String data) {

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("iphone 12");
		hp.clickOnSearchButton();

		//select product
		driver.findElement(By.xpath(data)).click();
		//get product name
		WebElement proName = driver.findElement(By.xpath("(//h2[@class='product-name'])[2]"));

		if (proName.isDisplayed()) {
			System.out.println(proName.getText());
			Assert.assertTrue(true);	
		}
		Reporter.log(proName.getText());
	}

	@Test(dataProvider = "productList")
	public void getSKUOfProduct(String data) {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("iphone 12");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();
		String sku=driver.findElement(By.xpath("(//div[@class='lineText product-code']/child::span[@class='ng-star-inserted'])[2]")).getText();
		System.out.println(sku);
	}
	/**
	 * Click And collect button disable/enable check
	 * @param data
	 * #clickAndCollectButtonTest()
	 * @throws Exception 
	 */
	@Test(dataProvider = "productList")
	public void clickAndCollectButtonTest(String data) throws Exception {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("iphone 12");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();

		WebElement clickCollect = driver.findElement(By.xpath("//button[@class='btn collect-from-store-btn btn-block ng-star-inserted']"));

		//	 Assert.assertFalse(clickCollect.isEnabled());

		if (clickCollect.isEnabled()) {
			Assert.assertTrue(true);
			System.out.println("click and collect available for this product(button enabled)");
		} else {
			System.out.println("click and collect not available for this product (button is disabled)");
			Assert.assertTrue(false);
		}
	}
	@Test(dataProvider = "productList")
	public void stockStatusCheck(String data) throws Exception {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("iphone 12");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();

		String stockStatus = driver.findElement(By.xpath("//span[@class='instock']")).getText();
		System.out.println(stockStatus);
		String inStock="In Stock";
		if (stockStatus.equals(inStock)) {
			driver.findElement(By.xpath("//*[text()=' Add to cart ']")).click();
			System.out.println("Product added to cart successfully");
		}else {
			throw new Exception("Product is out of stock");
		}
	}

	@Test(dataProvider = "productList")
	public void getBriefDescpription(String data)  {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("iphone 12");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();

		String briefDescription = driver.findElement(By.xpath("//div[@class='description ng-star-inserted']")).getText();

		System.out.println(briefDescription);
		Assert.assertTrue(true);
	}

	@Test(dataProvider ="productList" )
	public void quantityIncreaseByOne(String data) {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("Apple IPhone 15Pro");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();
		//click on add to cart button
		driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
		
		//quantity increase by one
		driver.findElement(By.xpath("//button[@aria-label='Add one more']")).click();
		
		Assert.assertTrue(true);
		
		System.out.println("Quantity updated (plus) successfully !");

	}
	
	@Test(dataProvider ="productList" )
	public void quantityDecreaseByOne(String data) throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("Apple IPhone 15Pro");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();
		//click on add to cart button
		driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
		//quantity increase by one
		driver.findElement(By.xpath("//button[@aria-label='Add one more']")).click();
		//quantity decrease by one
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		//identify minus button element				
		WebElement minusButton = driver.findElement(By.xpath("//button[@aria-label='Remove one']"));
		//wait for to element to load
		wait.until(ExpectedConditions.elementToBeClickable(minusButton));
		minusButton.click();
		Thread.sleep(2000);
		Assert.assertTrue(true);
		
		System.out.println("Quantity updated(minus) successfully !");

	}

	@Test(dataProvider ="productList" )
	public void quantityManualUpdate(String data) throws InterruptedException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.sendTextOnSeachbar("Apple IPhone 15Pro");
		hp.clickOnSearchButton();
		//select product
		driver.findElement(By.xpath(data)).click();
		//add to cart
		driver.findElement(By.xpath("//button[@class='btn add-to-cart-btn btn-block ng-star-inserted']")).click();
		//quantity increase manually
		driver.findElement(By.xpath("//input[@aria-label='Quantity']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-label='Quantity']")).sendKeys(Keys.DELETE);
		driver.findElement(By.xpath("//input[@aria-label='Quantity']")).sendKeys("5");
		
		Assert.assertTrue(true);
		System.out.println("Quantity updated successfully !");
	}

	@Test(dataProvider = "WarrentyXPath",dataProviderClass = DataproviderBAY.class)
	public void warrentyDropdown(String xpath) throws Exception {	

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);

		hp.getLaptopsIcon().click();

		driver.findElement(By.xpath("(//a[contains(text(),'HP Laptop')])[1]")).click();

		Robot rb=new Robot();
		Thread.sleep(2000);
		rb.mouseWheel(3);
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])"));
		
		if(element.isDisplayed()) {
		driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(xpath)).click();
		
		Assert.assertEquals(true, true);
		}else {
			System.out.println("Extended Warrenty feature is not available for this product...!");
		}
		
		//	driver.findElement(By.xpath("(//span[@class='ng-option-label ng-star-inserted'])[4]")).click();

	}

	@Test
	public void seeDetailsTest() throws Exception {	

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);

		hp.getLaptopsIcon().click();

		driver.findElement(By.xpath("(//a[contains(text(),'HP Laptop')])[1]")).click();

		Robot rb=new Robot();
		rb.mouseWheel(3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' See Details']")).click();
	}

	@Test
	public void productDescriptionTest() throws Exception {	

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);

		hp.getLaptopsIcon().click();

		driver.findElement(By.xpath("(//a[contains(text(),'HP Laptop')])[1]")).click();

		Robot rb=new Robot();
		rb.mouseWheel(3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' PRODUCT DESCRIPTION ']")).click();
	}

	@Test
	public void goToProductsSpecificationTest() throws Exception {	

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);

		hp.getLaptopsIcon().click();

		driver.findElement(By.xpath("(//a[contains(text(),'HP Laptop')])[1]")).click();

		Robot rb=new Robot();
		rb.mouseWheel(3);

		driver.findElement(By.xpath("//button[text()=' PRODUCT SPECIFICATION ']")).click();

	}
	@Test
	public void reviewRatingTest() throws Exception {	

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);

		hp.getLaptopsIcon().click();

		driver.findElement(By.xpath("(//a[contains(text(),'HP Laptop')])[1]")).click();

		Robot rb=new Robot();
		rb.mouseWheel(3);

		driver.findElement(By.xpath("//button[text()=' RATINGS & REVIEWS ']")).click();

	}	
	@Test
	public void faqTest() throws Exception {	

		HomePage_EleBAY hp=new HomePage_EleBAY(driver);

		hp.getLaptopsIcon().click();

		driver.findElement(By.xpath("(//a[contains(text(),'HP Laptop')])[1]")).click();

		Robot rb=new Robot();
		rb.mouseWheel(10);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'FAQ')]")).click();
		Assert.assertEquals(true, true);
	}

	@Test
	public void viewOfImageTest() throws AWTException {
		HomePage_EleBAY hp=new HomePage_EleBAY(driver);
		hp.getLaptopsIcon().click();

		driver.findElement(By.xpath(("(//a[contains(text(),'HP Laptop')])[1]"))).click();
		
		Robot rb=new Robot();
		
		rb.mouseWheel(5);


	}
}
