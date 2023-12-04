package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdatProfile {

	WebDriver driver;
	//initialize driver
	public UpdatProfile(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[1]")
	private WebElement UpdateProfile;
	
	@FindBy(xpath = "(//a[@class='btn card-actions edit ng-star-inserted'])[1]")
	private WebElement editFirstAdressButton;
	
	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	private WebElement firstNameTextArea;
	
	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	private WebElement lastNameTextArea;
	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement passwordTextArea;
	
	@FindBy(xpath = "//button[@class='btn form-action-btn btn-primary']")
	private WebElement UpdtaeButton;
	/**
	 * @return the updateProfile
	 */
	public WebElement getUpdateProfile() {
		return UpdateProfile;
	}

	/**
	 * @param updateProfile the updateProfile to set
	 */
	public void setUpdateProfile(WebElement updateProfile) {
		UpdateProfile = updateProfile;
	}

	/**
	 * @return the editFirstAdressButton
	 */
	public WebElement getEditFirstAdressButton() {
		return editFirstAdressButton;
	}

	/**
	 * @param editFirstAdressButton the editFirstAdressButton to set
	 */
	public void setEditFirstAdressButton(WebElement editFirstAdressButton) {
		this.editFirstAdressButton = editFirstAdressButton;
	}

	/**
	 * @return the firstNameTextArea
	 */
	public WebElement getFirstNameTextArea() {
		return firstNameTextArea;
	}

	/**
	 * @param firstNameTextArea the firstNameTextArea to set
	 */
	public void setFirstNameTextArea(WebElement firstNameTextArea) {
		this.firstNameTextArea = firstNameTextArea;
	}

	/**
	 * @return the lastNameTextArea
	 */
	public WebElement getLastNameTextArea() {
		return lastNameTextArea;
	}

	/**
	 * @param lastNameTextArea the lastNameTextArea to set
	 */
	public void setLastNameTextArea(WebElement lastNameTextArea) {
		this.lastNameTextArea = lastNameTextArea;
	}

	/**
	 * @return the passwordTextArea
	 */
	public WebElement getPasswordTextArea() {
		return passwordTextArea;
	}

	/**
	 * @param passwordTextArea the passwordTextArea to set
	 */
	public void setPasswordTextArea(WebElement passwordTextArea) {
		this.passwordTextArea = passwordTextArea;
	}

	/**
	 * @return the updtaeButton
	 */
	public WebElement getUpdtaeButton() {
		return UpdtaeButton;
	}

	/**
	 * @param updtaeButton the updtaeButton to set
	 */
	public void setUpdtaeButton(WebElement updtaeButton) {
		UpdtaeButton = updtaeButton;
	}
	
}
