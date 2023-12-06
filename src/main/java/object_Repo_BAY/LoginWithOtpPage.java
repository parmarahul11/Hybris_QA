package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithOtpPage {

	WebDriver driver;
	
	public LoginWithOtpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='form-container sign-in-container ng-star-inserted']/h2")
	private WebElement h2HeaderLoginwithOtpPage;
	
	@FindBy(xpath = "//input[@formcontrolname='mobileNo']")
	private WebElement mobilenumberTextField;
	
	@FindBy(xpath = "//button[@class='btn login-btn']")
	private WebElement requestOtpButton;
	
	@FindBy(xpath = "//button[@class='btn request-otp-btn']")
	private WebElement backToLoginPageButton;
	
	@FindBy(xpath = "//button[@class='btn login-btn']")
	private WebElement verifyButtonAfterOtpEnter;

	@FindBy(xpath = "//button[@class='btn login-btn']")
	private WebElement resendOtpButtonOnLWOtpPage;
	
	public WebElement getVerifyButtonAfterOtpEnter() {
		return verifyButtonAfterOtpEnter;
	}

	public WebElement getResendOtpButtonOnLWOtpPage() {
		return resendOtpButtonOnLWOtpPage;
	}

	public WebElement getH2HeaderLoginwithOtpPage() {
		return h2HeaderLoginwithOtpPage;
	}

	public WebElement getMobilenumberTextField() {
		return mobilenumberTextField;
	}

	public WebElement getRequestOtpButton() {
		return requestOtpButton;
	}

	public WebElement getBackToLoginPageButton() {
		return backToLoginPageButton;
	}
}
