package object_Repo_BAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllCategories_Elements {

	WebDriver driver;
	
//Identification	
	
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[2]")
	private WebElement  builtInKitchenAppliancesStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[3]")
	private WebElement homeEntertainmentStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[4]")
	private WebElement  mobilesStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[5]")
	private WebElement   gamingStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[6]")
	private WebElement  computersAndTabletsStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[7]")
	private WebElement   airConditionersStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[8]")
	private WebElement    homeAppliancesStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[9]")
	private WebElement   officeAutomationStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[10]")
	private WebElement    personalCareStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[11]")
	private WebElement    perfumeWatchesStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[12]")
	private WebElement    toysBagsStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[13]")
	private WebElement    swimmingFitnessStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[14]")
	private WebElement    yearEndSaleStoreIcon;
	
	@FindBy(xpath = "(//a[@class='dropdown-item ng-star-inserted'])[1]")
	private WebElement    panasonicStoreStoreIcon;
	


//Initialization	
	public AllCategories_Elements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//Utilization - getters
	
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	

	
	/**
	 * @return the swimmingfitnessIcon
	 */
//	public WebElement getSwimmingfitnessIcon() {
//		return swimmingfitnessIcon;
//	}

	/**
	 * @return the builtInKitchenAppliancesStoreIcon
	 */
	public WebElement getBuiltInKitchenAppliancesStoreIcon() {
		return builtInKitchenAppliancesStoreIcon;
	}

	/**
	 * @return the homeEntertainmentStoreIcon
	 */
	public WebElement getHomeEntertainmentStoreIcon() {
		return homeEntertainmentStoreIcon;
	}

	/**
	 * @return the mobilesStoreIcon
	 */
	public WebElement getMobilesStoreIcon() {
		return mobilesStoreIcon;
	}

	/**
	 * @return the gamingStoreIcon
	 */
	public WebElement getGamingStoreIcon() {
		return gamingStoreIcon;
	}

	/**
	 * @return the computersAndTabletsStoreIcon
	 */
	public WebElement getComputersAndTabletsStoreIcon() {
		return computersAndTabletsStoreIcon;
	}

	/**
	 * @return the airConditionersStoreIcon
	 */
	public WebElement getAirConditionersStoreIcon() {
		return airConditionersStoreIcon;
	}

	/**
	 * @return the homeAppliancesStoreIcon
	 */
	public WebElement getHomeAppliancesStoreIcon() {
		return homeAppliancesStoreIcon;
	}

	/**
	 * @return the officeAutomationStoreIcon
	 */
	public WebElement getOfficeAutomationStoreIcon() {
		return officeAutomationStoreIcon;
	}

	/**
	 * @return the personalCareStoreIcon
	 */
	public WebElement getPersonalCareStoreIcon() {
		return personalCareStoreIcon;
	}

	/**
	 * @return the perfumeWatchesStoreIcon
	 */
	public WebElement getPerfumeWatchesStoreIcon() {
		return perfumeWatchesStoreIcon;
	}

	/**
	 * @return the toysBagsStoreIcon
	 */
	public WebElement getToysBagsStoreIcon() {
		return toysBagsStoreIcon;
	}

	/**
	 * @return the swimmingFitnessStoreIcon
	 */
	public WebElement getSwimmingFitnessStoreIcon() {
		return swimmingFitnessStoreIcon;
	}

	/**
	 * @return the yearEndSaleStoreIcon
	 */
	public WebElement getYearEndSaleStoreIcon() {
		return yearEndSaleStoreIcon;
	}

	/**
	 * @return the panasonicStoreStoreIcon
	 */
	public WebElement getPanasonicStoreStoreIcon() {
		return panasonicStoreStoreIcon;
	}

	/**
	 * @param swimmingfitnessIcon the swimmingfitnessIcon to set
	 */
//	public void setSwimmingfitnessIcon(WebElement swimmingfitnessIcon) {
//		this.swimmingfitnessIcon = swimmingfitnessIcon;
//	}

	/**
	 * @param builtInKitchenAppliancesStoreIcon the builtInKitchenAppliancesStoreIcon to set
	 */
	public void setBuiltInKitchenAppliancesStoreIcon(WebElement builtInKitchenAppliancesStoreIcon) {
		this.builtInKitchenAppliancesStoreIcon = builtInKitchenAppliancesStoreIcon;
	}

	/**
	 * @param homeEntertainmentStoreIcon the homeEntertainmentStoreIcon to set
	 */
	public void setHomeEntertainmentStoreIcon(WebElement homeEntertainmentStoreIcon) {
		this.homeEntertainmentStoreIcon = homeEntertainmentStoreIcon;
	}

	/**
	 * @param mobilesStoreIcon the mobilesStoreIcon to set
	 */
	public void setMobilesStoreIcon(WebElement mobilesStoreIcon) {
		this.mobilesStoreIcon = mobilesStoreIcon;
	}

	/**
	 * @param gamingStoreIcon the gamingStoreIcon to set
	 */
	public void setGamingStoreIcon(WebElement gamingStoreIcon) {
		this.gamingStoreIcon = gamingStoreIcon;
	}

	/**
	 * @param computersAndTabletsStoreIcon the computersAndTabletsStoreIcon to set
	 */
	public void setComputersAndTabletsStoreIcon(WebElement computersAndTabletsStoreIcon) {
		this.computersAndTabletsStoreIcon = computersAndTabletsStoreIcon;
	}

	/**
	 * @param airConditionersStoreIcon the airConditionersStoreIcon to set
	 */
	public void setAirConditionersStoreIcon(WebElement airConditionersStoreIcon) {
		this.airConditionersStoreIcon = airConditionersStoreIcon;
	}

	/**
	 * @param homeAppliancesStoreIcon the homeAppliancesStoreIcon to set
	 */
	public void setHomeAppliancesStoreIcon(WebElement homeAppliancesStoreIcon) {
		this.homeAppliancesStoreIcon = homeAppliancesStoreIcon;
	}

	/**
	 * @param officeAutomationStoreIcon the officeAutomationStoreIcon to set
	 */
	public void setOfficeAutomationStoreIcon(WebElement officeAutomationStoreIcon) {
		this.officeAutomationStoreIcon = officeAutomationStoreIcon;
	}

	/**
	 * @param personalCareStoreIcon the personalCareStoreIcon to set
	 */
	public void setPersonalCareStoreIcon(WebElement personalCareStoreIcon) {
		this.personalCareStoreIcon = personalCareStoreIcon;
	}

	/**
	 * @param perfumeWatchesStoreIcon the perfumeWatchesStoreIcon to set
	 */
	public void setPerfumeWatchesStoreIcon(WebElement perfumeWatchesStoreIcon) {
		this.perfumeWatchesStoreIcon = perfumeWatchesStoreIcon;
	}

	/**
	 * @param toysBagsStoreIcon the toysBagsStoreIcon to set
	 */
	public void setToysBagsStoreIcon(WebElement toysBagsStoreIcon) {
		this.toysBagsStoreIcon = toysBagsStoreIcon;
	}

	/**
	 * @param swimmingFitnessStoreIcon the swimmingFitnessStoreIcon to set
	 */
	public void setSwimmingFitnessStoreIcon(WebElement swimmingFitnessStoreIcon) {
		this.swimmingFitnessStoreIcon = swimmingFitnessStoreIcon;
	}

	/**
	 * @param yearEndSaleStoreIcon the yearEndSaleStoreIcon to set
	 */
	public void setYearEndSaleStoreIcon(WebElement yearEndSaleStoreIcon) {
		this.yearEndSaleStoreIcon = yearEndSaleStoreIcon;
	}

	/**
	 * @param panasonicStoreStoreIcon the panasonicStoreStoreIcon to set
	 */
	public void setPanasonicStoreStoreIcon(WebElement panasonicStoreStoreIcon) {
		this.panasonicStoreStoreIcon = panasonicStoreStoreIcon;
	}

	
	  public void clickOnOfficeAutoamtionIcon() {
	  
	  }
	 

	public void clickOnBackToSchoolIcon() {
		
	}

	
	
}
