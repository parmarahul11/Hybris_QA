package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	

	WebDriver driver;
	//declaration
	@FindBy(xpath = "(//div[@class='myacc-cnt'])[2]")
	private WebElement MyAccountTextArea;
	


	/**
	 * @return the myAccountTextArea
	 */
	public WebElement getMyAccountTextArea() {
		return MyAccountTextArea;
	}


	/**
	 * @return the viewUpdateProfile
	 */
	public WebElement getViewUpdateProfile() {
		return ViewUpdateProfile;
	}


	/**
	 * @return the updateMobileNumber
	 */
	public WebElement getUpdateMobileNumber() {
		return UpdateMobileNumber;
	}


	/**
	 * @return the eWallet
	 */
	public WebElement getEWallet() {
		return EWallet;
	}


	/**
	 * @return the updateEmailId
	 */
	public WebElement getUpdateEmailId() {
		return UpdateEmailId;
	}


	/**
	 * @return the orderHistory
	 */
	public WebElement getOrderHistory() {
		return OrderHistory;
	}


	/**
	 * @return the adderessBook
	 */
	public WebElement getAdderessBook() {
		return AdderessBook;
	}


	/**
	 * @return the updatePassword
	 */
	public WebElement getUpdatePassword() {
		return UpdatePassword;
	}


	/**
	 * @return the wishlist
	 */
	public WebElement getWishlist() {
		return Wishlist;
	}


	/**
	 * @return the loyltyPoint
	 */
	public WebElement getLoyltyPoint() {
		return LoyltyPoint;
	}


	/**
	 * @return the logOutTexArea
	 */
	public WebElement getLogOutTexArea() {
		return LogOutTexArea;
	}


	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[1]")
	private WebElement ViewUpdateProfile;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[2]")
	private WebElement UpdateMobileNumber;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[3]")
	private WebElement EWallet;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[4]")
	private WebElement UpdateEmailId;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[5]")
	private WebElement OrderHistory;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[6]")
	private WebElement AdderessBook;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[7]")
	private WebElement UpdatePassword;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[8]")
	private WebElement Wishlist;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[9]")
	private WebElement LoyltyPoint;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[10]")
	private WebElement LogOutTexArea;
	
	
	//Initialization
		public MyAccountPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
	

}
}