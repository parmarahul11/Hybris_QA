package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	WebDriver driver;
	//declaration
	@FindBy(xpath = "(//div[@class='cart-cnt'])[1]")
	private WebElement CartIconYellowBack;

	@FindBy(xpath = "//input[@formcontrolname='couponCode']")
	private WebElement coupenCodeTextArea;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-secondary apply-coupon-button']")
	private WebElement coupenCodeApplyButton;

	@FindBy(xpath = "//div[@class='cx-progress-button-container']")
	private WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-block cart-btn-continue']")
	private WebElement continueShoppingButton;

	@FindBy(xpath = "(//input[@name='delivery_option_IPH-13P-1TB-GRT'])[1]")
	private WebElement clickAndCollectRadioButton;

	@FindBy(xpath = "(//input[@name='delivery_option_IPH-13P-1TB-GRT'])[2]")
	private WebElement StdDeliveryRadioButton;

	@FindBy(xpath = "(//input[@name='delivery_option_IPH-13P-1TB-GRT'])[3]")
	private WebElement ScheduledDeliveryRadioButton;

	@FindBy(xpath = "(//input[@name='delivery_option_IPH-13P-1TB-GRT'])[4]")
	private WebElement expressDeliveryRadioButton;

	@FindBy(xpath = "(//a[@class='cx-link ng-star-inserted'])[1]")
	private WebElement firstProdNamelinkAtCart;

	@FindBy(xpath = "(//*[@aria-label='Remove Product from Cart'])[1]")
	private WebElement removeFirstElementFromCart;

	@FindBy(xpath = "(//*[@aria-label='Remove Product from Cart'])[2]")
	private WebElement removeSecondElementFromCart;

	@FindBy(xpath = "(//*[@aria-label='Add one more'])[1]")
	private WebElement quantityIncreaseByOneIcon;

	@FindBy(xpath = "(//*[@aria-label='Remove one'])[1]")
	private WebElement quantityDecreaseByOneIcon;

	@FindBy(xpath = "(//*[@aria-label='Quantity'])[1]")
	private WebElement manualQuantityUpdate;

	@FindBy(xpath = "//div[@class='heading']")
	private WebElement H2HeadingAtCartPage;

	@FindBy(xpath = "//div[@class='cx-product-summary ng-star-inserted']")
	private WebElement productBriefDescriptAtCart;

	@FindBy(xpath = "//div[@class='summary-cnt']")
	private WebElement allPricingElements;

	@FindBy(xpath = "//div[@class='sum-amount text-right']")
	private WebElement grandTotalPrice;

	@FindBy(xpath = "//ng-select[@class='ng-select-searchable ng-select ng-select-single ng-untouched ng-pristine ng-valid ng-select-opened ng-select-top']")
	private WebElement warrantyDropdown;

	//Utilization - getters:
	public WebElement getCartIconYellowBack() {
		return CartIconYellowBack;
	}
	
	public WebElement getCoupenCodeTextArea() {
		return coupenCodeTextArea;
	}
	
	public WebElement getCoupenCodeApplyButton() {
		return coupenCodeApplyButton;
	}

	public WebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}

	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getClickAndCollectRadioButton() {
		return clickAndCollectRadioButton;
	}

	public WebElement getStdDeliveryRadioButton() {
		return StdDeliveryRadioButton;
	}

	public WebElement getScheduledDeliveryRadioButton() {
		return ScheduledDeliveryRadioButton;
	}

	public WebElement getExpressDeliveryRadioButton() {
		return expressDeliveryRadioButton;
	}

	public WebElement getFirstProdNamelinkAtCart() {
		return firstProdNamelinkAtCart;
	}

	public WebElement getRemoveFirstElementFromCart() {
		return removeFirstElementFromCart;
	}

	public WebElement getRemoveSecondElementFromCart() {
		return removeSecondElementFromCart;
	}

	public WebElement getQuantityIncreaseByOneIcon() {
		return quantityIncreaseByOneIcon;
	}

	public WebElement getQuantityDecreaseByOneIcon() {
		return quantityDecreaseByOneIcon;
	}

	public WebElement getManualQuantityUpdate() {
		return manualQuantityUpdate;
	}

	public WebElement getH2HeadingAtCartPage() {
		return H2HeadingAtCartPage;
	}

	public WebElement getProductBriefDescriptAtCart() {
		return productBriefDescriptAtCart;
	}

	public WebElement getAllPricingElements() {
		return allPricingElements;
	}

	public WebElement getGrandTotalPrice() {
		return grandTotalPrice;
	}

	public WebElement getWarrantyDropdown() {
		return warrantyDropdown;
	}
	//Initialization
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business logic

}
