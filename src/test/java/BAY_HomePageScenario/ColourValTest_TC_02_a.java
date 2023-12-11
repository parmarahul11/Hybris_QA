package BAY_HomePageScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.utilities.BaseClass;
import generic.utilities.BaseClassBay;
//@Listeners(generic.utilities.ListenerImplementationWithExtentReport.class)
public class ColourValTest_TC_02_a extends BaseClassBay {

	@Test
	public void headerPrimaryREDBackColourTest() {
		String textCol = driver.findElement(By.xpath("//*[@id='header']")).getCssValue("background-color");
		System.out.println(textCol);//rgba(227, 6, 19, 1)
		String actualHexa="#e30613";
		String textHex = Color.fromString(textCol).asHex();
		System.out.println(textHex);//#E30613
		//validate using assertion		
		Assert.assertEquals(actualHexa, textHex);	
	}
	
	@Test
	public void headerSecondaryYELLOWColTest() {
		String textBagCol = driver.findElement(By.xpath("(//*[@id='navbarDropdown'])[1]")).getCssValue("background-color");
		System.out.println(textBagCol);//
		String colorhex = Color.fromString(textBagCol).asHex();
		System.out.println(colorhex);
		String actualHexa="#ffc423";
		//validate using assertion
		Assert.assertEquals(actualHexa, colorhex);		
	}
	
	@Test
	public void headerSecondaryWhiteBackColTest() {
		String textBagCol = driver.findElement(By.xpath("(//*[@class='nav-menu ng-star-inserted'])[15]")).getCssValue("color");
		System.out.println(textBagCol);//rgba(255, 255, 255, 1)
		String colorhex = Color.fromString(textBagCol).asHex();
		System.out.println(colorhex);
		String actualHexa="#ffffff";
		
		//validate using assertion
		Assert.assertEquals(actualHexa, colorhex);		
		
	}
}
