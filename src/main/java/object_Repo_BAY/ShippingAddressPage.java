package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {

	WebDriver driver;
	//declaration
	@FindBy(xpath = "//button[@class='cx-btn btn btn-block btn-primary']")
	private WebElement continueButton ;

	//Utilization - getters:
	public WebElement getContinueButton() {
		return continueButton;
	}
	//Initialization
	public ShippingAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
}
