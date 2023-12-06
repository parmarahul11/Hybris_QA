package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressBookPage {

	WebDriver driver;
	//initialize driver
	public AddressBookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@class='btn card-actions edit ng-star-inserted'])[1]")
	private WebElement editFirstAdressButton;
	
	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	private WebElement lastNameTextArea;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[6]")
	private WebElement AdderessBook;
	
	@FindBy(xpath = "//div[@class='heading']")
	private WebElement Title;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary submit-button mb-3']")
	private WebElement submitButtonOnAddressBook;
	
	/**
	 * @return the submitButtonOnAddressBook
	 */
	public WebElement getSubmitButtonOnAddressBook() {
		return submitButtonOnAddressBook;
	}

	/**
	 * @return the title
	 */
	public WebElement getTitle() {
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(WebElement title) {
		Title = title;
	}

	/**
	 * @return the adderessBook
	 */
	public WebElement getAdderessBook() {
		return AdderessBook;
	}

	/**
	 * @param adderessBook the adderessBook to set
	 */
	public void setAdderessBook(WebElement adderessBook) {
		AdderessBook = adderessBook;
	}

	/**
	 * @return the lastNameTextArea
	 */
	public WebElement getLastNameTextArea() {
		return lastNameTextArea;
	}

		//Initialization
		//public AddressBookPage(WebDriver driver) {
			//PageFactory.initElements(driver, this);


		/**
		 * @return the logOutTexArea
		 */
		public WebElement getEditFirstAdressButton() {
			return editFirstAdressButton;
		}
		
}
