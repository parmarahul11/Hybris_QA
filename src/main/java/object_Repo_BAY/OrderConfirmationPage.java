package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	

	WebDriver driver;
	//initialize driver
	public OrderConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrderId() {
		return orderId;
	}

	@FindBy(xpath = "//p[@class='order-confirmation--number']")
	private WebElement orderId;
}
