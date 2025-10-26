package hooks;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class myHooks {
	 WebDriver driver;
	
	
	@Before
   public  void setup() throws FileNotFoundException  {
		

		Properties prop = new ConfigReader().initializeProperties();
		driver=DriverFactory.initializebrowser(prop.getProperty("browser"));
	
		driver.get(prop.getProperty("URL"));
		
		 }
	@After
	public  void tearDown(Scenario scenario) {
		String scenarioName=scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
		byte[] srcScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenShot, "image/png", scenarioName);
		}
		//if(driver !=null)
		driver.quit();
		
		//private ConfigReader configReader;
		
		// configReader=new ConfigReader();
		 
				//Properties prop=configReader.initializeProperties();
				//or Properties prop=new ConfigReader().initializeProperties();

	
	}

}
