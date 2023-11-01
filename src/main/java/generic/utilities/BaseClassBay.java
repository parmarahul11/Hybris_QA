package generic.utilities;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassBay {

	public WebDriver driver=null;

	public WebdriverUtility wUtil=new WebdriverUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	
	public static WebDriver sDriver;

	@BeforeMethod
//	@Parameters({"browser","url"*/})
	public void beforeConfig(/*String BROWSER*/) throws IOException {
	
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
	//	String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
		
		//	WebDriverManager.chromedriver().setup();
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			opt.addArguments("--disable-notifications");
			opt.addArguments("--start-maximized");
			WebDriver driver=new ChromeDriver(opt);
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			//System.getProperty("browser").equalsIgnoreCase("edge")
		//	WebDriverManager.edgedriver().setup();
			EdgeOptions opt=new EdgeOptions();
			opt.addArguments("--disable-notifications");
			driver=new EdgeDriver();
		}
		else {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		} 
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		driver.get(pUtil.readDataFromPropertyFile("BAY"));
		sDriver=driver;
	}

	@AfterMethod
	public void afterConfig() {

		try {
			Thread.sleep(3000);
		//	driver.quit();
		} catch (Exception e) {
		//	e.printStackTrace();
		}
	}
	/*
	 public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	    {
	        TakesScreenshot screenShot = (TakesScreenshot) driver;
	        File source = screenShot.getScreenshotAs(OutputType.FILE);
	        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png";
	        FileUtils.copyFile(source, new File(destinationFile));
	        return destinationFile;
	    }
	 */

	public static String takeScreenShots(String methodname) throws IOException {
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"./BAYScreenShots/BAY"+jUtil.getRandomNumber()+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);

		return path;
		//return dest.getAbsolutePath();

	}	
}
