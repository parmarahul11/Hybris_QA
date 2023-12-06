package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPassword {

	WebDriver driver;
	//initialize driver
	public ResetPassword(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[6]")
	private WebElement UpdatePasswordBook;
	
	@FindBy(name = "oldPassword")
	private WebElement oldPasswordTextArea;
	
	@FindBy(name = "newPassword")
	private WebElement newPasswordTextArea;
	
	@FindBy(name = "newPasswordConfirm")
	private WebElement newPasswordConfirmTextArea;
	
	@FindBy(xpath = "//button[@class='btn form-action-btn btn-primary']")
	private WebElement saveButton;
	/**
	 * @return the updatePasswordBook
	 */
	public WebElement getUpdatePasswordBook() {
		return UpdatePasswordBook;
	}

	/**
	 * @return the oldPasswordTextArea
	 */
	public WebElement getOldPasswordTextArea() {
		return oldPasswordTextArea;
	}

	/**
	 * @return the newPasswordTextArea
	 */
	public WebElement getNewPasswordTextArea() {
		return newPasswordTextArea;
	}

	/**
	 * @return the newPasswordConfirmTextArea
	 */
	public WebElement getNewPasswordConfirmTextArea() {
		return newPasswordConfirmTextArea;
	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}

	/**
	 * @param updatePasswordBook the updatePasswordBook to set
	 */
	public void setUpdatePasswordBook(WebElement updatePasswordBook) {
		UpdatePasswordBook = updatePasswordBook;
	}

	/**
	 * @param oldPasswordTextArea the oldPasswordTextArea to set
	 */
	public void setOldPasswordTextArea(WebElement oldPasswordTextArea) {
		this.oldPasswordTextArea = oldPasswordTextArea;
	}

	/**
	 * @param newPasswordTextArea the newPasswordTextArea to set
	 */
	public void setNewPasswordTextArea(WebElement newPasswordTextArea) {
		this.newPasswordTextArea = newPasswordTextArea;
	}

	/**
	 * @param newPasswordConfirmTextArea the newPasswordConfirmTextArea to set
	 */
	public void setNewPasswordConfirmTextArea(WebElement newPasswordConfirmTextArea) {
		this.newPasswordConfirmTextArea = newPasswordConfirmTextArea;
	}

	/**
	 * @param saveButton the saveButton to set
	 */
	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}
	
	
	
	
}