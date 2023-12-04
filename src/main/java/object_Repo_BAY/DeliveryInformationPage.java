package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryInformationPage {

	WebDriver driver;
	//declaration
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary nextPage ng-star-inserted']")
	private WebElement continueButton ;

	//Utilization - getters:
	public WebElement getContinueButton() {
		return continueButton;
	}
	//Initialization
	public DeliveryInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
}
