package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateMobileAndEmailPage {
	
	WebDriver driver;
	//initialize driver
	public UpdateMobileAndEmailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[2]")
	private WebElement UpdateMobileNumber;
	
	@FindBy(xpath = "//input[@name='mobilenumber']")
	private WebElement NewMobileNumberTextArea;
	
	@FindBy(xpath = "//input[@name='confirmMobile']")
	private WebElement ConfirmNewMobileNumberTextArea;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement PasswordTextArea;
	
	@FindBy(xpath = "//button[@class='btn form-action-btn btn-primary']")
	private WebElement UpdateButton;
	/**
	 * @return the updateMobileNumber
	 */
	public WebElement getUpdateMobileNumber() {
		return UpdateMobileNumber;
	}

	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[4]")
	private WebElement UpdateEmailId;
	
	@FindBy(xpath = "//button[@class='btn request-otp-btn']")
	private WebElement VerifyButtonOnEmailOtp;
	
	@FindBy(xpath = "(//input[@name='email'])[1]")
	private WebElement EnterNewEmailTextField;
	
	@FindBy(xpath = "(//input[@name='confirmEmail'])[1]")
	private WebElement ConfirmEmailTextField;
	
	@FindBy(xpath = "//button[@class='btn form-action-btn btn-primary']")
	private WebElement UpdateButton1;
	
	/**
	 * @return the enterNewEmailTextField
	 */
	public WebElement getEnterNewEmailTextField() {
		return EnterNewEmailTextField;
	}

	/**
	 * @return the confirmEmailTextField
	 */
	public WebElement getConfirmEmailTextField() {
		return ConfirmEmailTextField;
	}

	/**
	 * @return the updateButton1
	 */
	public WebElement getUpdateButton1() {
		return UpdateButton1;
	}

	/**
	 * @param enterNewEmailTextField the enterNewEmailTextField to set
	 */
	public void setEnterNewEmailTextField(WebElement enterNewEmailTextField) {
		EnterNewEmailTextField = enterNewEmailTextField;
	}

	/**
	 * @param confirmEmailTextField the confirmEmailTextField to set
	 */
	public void setConfirmEmailTextField(WebElement confirmEmailTextField) {
		ConfirmEmailTextField = confirmEmailTextField;
	}

	/**
	 * @param updateButton1 the updateButton1 to set
	 */
	public void setUpdateButton1(WebElement updateButton1) {
		UpdateButton1 = updateButton1;
	}

	/**
	 * @return the updateEmailId
	 */
	public WebElement getUpdateEmailId() {
		return UpdateEmailId;
	}

	/**
	 * @return the verifyButton
	 */
	public WebElement getVerifyButtonOnEmailOtp() {
		return VerifyButtonOnEmailOtp;
	}

	/**
	 * @param updateEmailId the updateEmailId to set
	 */
	public void setUpdateEmailId(WebElement updateEmailId) {
		UpdateEmailId = updateEmailId;
	}

	/**
	 * @param verifyButton the verifyButton to set
	 */
//	public void setVerifyButtonOnEmailOtp(WebElement verifyButton) {
//		VerifyButtonOnEmailOtp = VerifyButtonOnEmailOtp;
//	}

	/**
	 * @return the newMobileNumberTextArea
	 */
	public WebElement getNewMobileNumberTextArea() {
		return NewMobileNumberTextArea;
	}

	/**
	 * @return the confirmNewMobileNumberTextArea
	 */
	public WebElement getConfirmNewMobileNumberTextArea() {
		return ConfirmNewMobileNumberTextArea;
	}

	/**
	 * @return the passwordTextArea
	 */
	public WebElement getPasswordTextArea() {
		return PasswordTextArea;
	}

	/**
	 * @return the updateButton
	 */
	public WebElement getUpdateButton() {
		return UpdateButton;
	}

	/**
	 * @param updateMobileNumber the updateMobileNumber to set
	 */
	public void setUpdateMobileNumber(WebElement updateMobileNumber) {
		UpdateMobileNumber = updateMobileNumber;
	}

	/**
	 * @param newMobileNumberTextArea the newMobileNumberTextArea to set
	 */
	public void setNewMobileNumberTextArea(WebElement newMobileNumberTextArea) {
		NewMobileNumberTextArea = newMobileNumberTextArea;
	}

	/**
	 * @param confirmNewMobileNumberTextArea the confirmNewMobileNumberTextArea to set
	 */
	public void setConfirmNewMobileNumberTextArea(WebElement confirmNewMobileNumberTextArea) {
		ConfirmNewMobileNumberTextArea = confirmNewMobileNumberTextArea;
	}

	/**
	 * @param passwordTextArea the passwordTextArea to set
	 */
	public void setPasswordTextArea(WebElement passwordTextArea) {
		PasswordTextArea = passwordTextArea;
	}

	/**
	 * @param updateButton the updateButton to set
	 */
	public void setUpdateButton(WebElement updateButton) {
		UpdateButton = updateButton;
	}
	
	
	
}
