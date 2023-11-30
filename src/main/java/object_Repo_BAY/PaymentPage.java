package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	WebDriver driver;
	//initialize driver
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath = "//input[@id='creditsales']")
	private WebElement creditSalesRadio;

	@FindBy(xpath = "//select[@formcontrolname='nationality']")
	private WebElement nationalityDropdown;

	@FindBy(xpath = "//input[@formcontrolname='monthlyIncome']")
	private WebElement monthlyIncomeTextArea;

	@FindBy(xpath = "//input[@formcontrolname='civilIdNumber']")
	private WebElement civilIdNumberTextArea;

	@FindBy(xpath = "//select[@formcontrolname='incomeType']")
	private WebElement incomeTypeDropdown;

	@FindBy(xpath = "//select[@formcontrolname='tenure']")
	private WebElement tenureDropdown;

	@FindBy(xpath = "//select[@formcontrolname='preferredArea']")
	private WebElement preferredAreaDropdown;

	@FindBy(xpath = "//button[@class='btn btn-block btn-primary ng-star-inserted']")
	private WebElement continuePaymentButton;

	public WebElement getContinuePaymentButton() {
		return continuePaymentButton;
	}

	//getters
	public WebElement getCreditSalesRadio() {
		return creditSalesRadio;
	}

	public WebElement getNationalityDropdown() {
		return nationalityDropdown;
	}

	public WebElement getMonthlyIncomeTextArea() {
		return monthlyIncomeTextArea;
	}

	public WebElement getCivilIdNumberTextArea() {
		return civilIdNumberTextArea;
	}

	public WebElement getIncomeTypeDropdown() {
		return incomeTypeDropdown;
	}

	public WebElement getTenureDropdown() {
		return tenureDropdown;
	}

	public WebElement getPreferredAreaDropdown() {
		return preferredAreaDropdown;
	}
	
	
}
