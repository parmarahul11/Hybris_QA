package object_Repo_BAY;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utilities.WebdriverUtility;
/**
 * this class contains Homepage elements 
 * @author Ratnadeep_Khaple
 *
 */
public class HomePage_EleBAY{
	WebDriver driver;
	/**
	 * HEADER elements	
	 * 
	 * @bAYLogoIcon @ChangeLangToArebic @loginIcon @allCatagoiesIcon
	 * @seachBarTextArea
	 */

	//declaration
	@FindBy(xpath = "//img[@alt='Best Al Yousifi']")
	private WebElement bAYLogoIcon;

	@FindBy(xpath = "//a[@class='blue-bg-link mt-30 current-lang']")
	private WebElement ChangeLangToArebic;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginIcon;

	@FindBy(xpath = "//input[@placeholder='Search here...']")
	private WebElement searchBarTextArea;
	
	@FindBy(xpath = "//*[@class='search-icon']")
	private WebElement searchButton;
	
	@FindBy(xpath="(//a[@class='cx-best-mini-cart'])[1]/div[1]/div[2]/div[2]/span[@class='count']")
	private WebElement minicartQuantity;
	
	public WebElement getMinicartQuantity() {
		return minicartQuantity;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	//Utilization - getters
	public WebElement getbAYLogoIcon() {
		return bAYLogoIcon;
	}
	public WebElement getChangeLangToArebic() {
		return ChangeLangToArebic;
	}
	public WebElement getLoginIcon() {
		return loginIcon;
	}
	public WebElement getSearchBarTextArea() {
		return searchBarTextArea;
	}
	/**
	 * Navigation Bar Elements
	 * @giftCardsIcon @digitalCardsIcon @airConditionerIcon
	 * @mobilePhonesIcon @refrigaratorsIcon @gasCookersIcon @laptopsIcon	
	 * @myCartIcon
	 */
	@FindBy(xpath = "//a[@id='navbarDropdown']")
	private WebElement allCatagoiesIcon;

//	@FindBy(xpath = "(//a[text()=' Gift Cards '])[1]")
//	private WebElement giftCardsIcon;

	@FindBy(xpath = "(//a[text()=' Digital Cards '])[2]")
	private WebElement digitalCardsIcon;

	@FindBy(xpath = "(//a[text()=' Air Conditioners '])[1]")
	private WebElement airConditionerIcon;

	@FindBy(xpath = "(//a[text()=' Mobile Phones '])[1]")
	private WebElement mobilePhonesIcon;

	@FindBy(xpath = "(//a[text()=' Refrigerators '])[1]")
	private WebElement refrigaratorsIcon;

	@FindBy(xpath = "(//a[text()=' Gas Cookers '])[1]")
	private WebElement gasCookersIcon;

	@FindBy(xpath = "(//a[text()=' Laptops '])[1]")
	private WebElement laptopsIcon;
	
	@FindBy(xpath = "(//div[text()='My Cart'])[1]")
	private WebElement myCartIcon;

	//Utilization - getters
	public WebElement getAllCatagoiesIcon() {
		return allCatagoiesIcon;
	}
//	public WebElement getGiftCardsIcon() {
//		return giftCardsIcon;
//	}
	public WebElement getDigitalCardsIcon() {
		return digitalCardsIcon;
	}
	public WebElement getAirConditionerIcon() {
		return airConditionerIcon;
	}
	public WebElement getMobilePhonesIcon() {
		return mobilePhonesIcon;
	}
	public WebElement getRefrigaratorsIcon() {
		return refrigaratorsIcon;
	}
	public WebElement getGasCookersIcon() {
		return gasCookersIcon;
	}
	public WebElement getLaptopsIcon() {
		return laptopsIcon;
	}
	public WebElement getMyCartIcon() {
		return myCartIcon;
	}
	//Initialization
	public HomePage_EleBAY(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Business logic
	public void mouseOverOnAllCategories() {
		allCatagoiesIcon.click();
	}
//	public void clickOnGiftCards() {
//		giftCardsIcon.click();
//	}
	public void clickOnDigitalCards() {
		digitalCardsIcon.click();
	}
	public void clickOnAirConditioner() {
		airConditionerIcon.click();
	}
	public void sendTextOnSeachbar(String searchText) {
		searchBarTextArea.sendKeys(searchText);
	}
	public void clickOnSearchButton() {
		searchBarTextArea.click();
	}
	public void clickOnMyCartIcon() {
		myCartIcon.click();
	}
	
	/**
	 * footer elements
	 */
	
	@FindBy(xpath = "//a[@title='Help']")
	private WebElement helpLink;
	
	@FindBy(xpath = "//a[@title='Contact Us']")
	private WebElement contactUsLink;

	@FindBy(xpath = "//a[@title='Return Policy']")
	private WebElement returnPolicyLink;
	
	@FindBy(xpath = "//a[@title='Terms & Conditions']")
	private WebElement termsConditionsLink;
	
	@FindBy(xpath = "//a[@title='FAQs']")
	private WebElement faqLink;
	
	@FindBy(xpath = "//a[@title='About Us']")
	private WebElement aboutUsLink;
	
	@FindBy(xpath = "//a[@title='Store Locator']")
	private WebElement storeLocatorLink;
	
	@FindBy(xpath = "//a[@title='Site Map']")
	private WebElement siteMapLink;
	
	@FindBy(id = "Youtube")
	private WebElement youTubeLink;
	
	@FindBy(id = "Instagram")
	private WebElement InstagramLink;
	
	@FindBy(id = "Linked In")
	private WebElement LinkedInLink;
	
	@FindBy(id = "Facebook")
	private WebElement FacebookLink;

	@FindBy(id = "Twitter")
	private WebElement TwitterLink;
	
	public WebElement getHelpLink() {
		return helpLink;
	}	
	public WebElement getReturnPolicyLink() {
		return returnPolicyLink;
	}
	public WebElement getTermsConditionsLink() {
		return termsConditionsLink;
	}
	public WebElement getFaqLink() {
		return faqLink;
	}	
	public WebElement getAboutUsLink() {
		return aboutUsLink;
	}	
	public WebElement getStoreLocatorLink() {
		return storeLocatorLink;
	}	
	public WebElement getSiteMapLink() {
		return siteMapLink;
	}	
	public WebElement getContactUsLink() {
		return contactUsLink;
	}
	public WebElement TwitterLink() {
		return TwitterLink;
	}
	public WebElement FacebookLink() {
		return FacebookLink;
	}
	public WebElement LinkedInLink() {
		return LinkedInLink;
	}
	public WebElement InstagramLink() {
		return InstagramLink;
	}
	public WebElement youTubeLink() {
		return youTubeLink;
	}
	
//business logic-footer
	
	public void clickOnHelpLink() {
		helpLink.click();
	}
	public void clickOnReturnPolicyLink() {
		returnPolicyLink.click();
	}
	public void clickOnFaqLink() {
		faqLink.click();
	}
	public void clickOnAboutUsLink() {
		aboutUsLink.click();
	}
	public void clickOnStoreLocatorLink() {
		storeLocatorLink.click();
	}
	public void clickOnSiteMapLink() {
		siteMapLink.click();
	}
	public void clickOnContactUsLink() {
		contactUsLink.click();
	}
	public void clickOnTermsConditionsLink() {
		termsConditionsLink.click();
	}	
	public void clickOnTwitterLink() {
		TwitterLink.click();
	}
	public void clickOnInstagramLink() {
		InstagramLink.click();	
	}
	public void clickOnyouTubeLink() {
		youTubeLink.click();
	}
	public void clickOnLinkedInLink() {
		LinkedInLink.click();
	}
	public void clickOnFacebookLink() {
		FacebookLink.click();
	}
	
}

