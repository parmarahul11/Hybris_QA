package object_Repo_BAY;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PLP_page {

	WebDriver driver;
	
	public PLP_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy( xpath = "//div[@class='price ng-star-inserted']")
	private WebElement priceFilterh2HeaderOnPLP ;
	
	@FindBy(xpath = "//div[@class='best-facet ng-star-inserted']")
	private List<WebElement> plpAllfilterselements;

	public WebElement getPriceFilterh2HeaderOnPLP() {
		return priceFilterh2HeaderOnPLP;
	}

	public List<WebElement> getPlpAllfilterselements() {
		return plpAllfilterselements;
	}
	
	
	
	
}
