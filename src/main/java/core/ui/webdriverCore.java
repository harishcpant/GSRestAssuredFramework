package core.ui;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import core.common.GetEnvDetails;
import core.common.GetLogger;

public class webdriverCore {
	public static WebDriver driver;
	static Properties p=GetEnvDetails.getEnvDetails();
	
	public static WebDriver getDriver()
	{
		System.out.println("Browser from property file-->"+p.getProperty("browser"));
		
		switch (p.getProperty("browser")) {
		  case "chrome":			  	
			  	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
				break;
		  case "IE":
				System.setProperty("webdriver.ie.driver", "src\\test\\resources\\Drivers\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				break;
		  case "firefox":
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				break;
		}
		return driver;
	}
}
