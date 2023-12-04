package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BAckOfficePages {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='j_username']")
	private WebElement usernameTextField;
	
	@FindBy(xpath = "//input[@name='j_password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[@class='login_btn y-btn-primary z-button']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//input[@id='kVuCjb-real']")
	private WebElement searchBarTextArea;

	public WebElement getSearchBarTextArea() {
		return searchBarTextArea;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}
	
	public BAckOfficePages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
