package Factory;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utils.CommonUtills;
import utils.ConfigReader;

public class DriverFactory {
	static  WebDriver driver=null;
	public static WebDriver initializebrowser(String browserName) throws FileNotFoundException {
		
		if(browserName.equals("chrome")) {
			 driver=new ChromeDriver();
			
		}else if(browserName.equals("edge")) {
			 driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtills.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtills.IMPLICIT_WAIT_TIME));
		
		return driver;
		
	}

public  static WebDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}






}
