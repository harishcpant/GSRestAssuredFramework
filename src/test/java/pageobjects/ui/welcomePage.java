package pageobjects.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import core.ui.webdriverCore;

public class welcomePage extends webdriverCore {

	String pageUrl="http://the-internet.herokuapp.com/";
	WebDriver driver=getDriver();
	
	public void openPage()
	{
		System.out.println("Open the login page-->");
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}
	
	public loginPage clickFormAuthenticationLink() {
		driver.findElement(By.linkText("Form Authentication")).click();		
		return new loginPage(driver);
		
	}
}
