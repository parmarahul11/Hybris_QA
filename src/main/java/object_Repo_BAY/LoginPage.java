package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@class='btn request-otp-btn']")
	private WebElement loginWithOtpButton;
	
	@FindBy(xpath = "//input[@formcontrolname='userId']")
	private WebElement emailTextField ;
	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//a[@class='btn-link ng-star-inserted']")
	private WebElement forgetPasswordLink ;
	
	@FindBy(xpath = "//button[@class='btn login-btn']")
	private WebElement signInButtton;
	
	@FindBy(xpath = "//div[@class='heading']")
	private WebElement h2HeaderLoginPage;
	
	@FindBy(xpath = "//a[@class='btn login-btn']")
	private WebElement createAccountButton;
	
	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	private WebElement rechaptchaFrameElement;
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	private WebElement rechaptchaCheckbox;
	
	public WebElement getRechaptchaFrameElement() {
		return rechaptchaFrameElement;
	}

	public WebElement getRechaptchaCheckbox() {
		return rechaptchaCheckbox;
	}

	public WebElement getLoginWithOtpButton() {
		return loginWithOtpButton;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getForgetPasswordLink() {
		return forgetPasswordLink;
	}

	public WebElement getSignInButtton() {
		return signInButtton;
	}

	public WebElement getH2HeaderLoginPage() {
		return h2HeaderLoginPage;
	}

	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}	
}
