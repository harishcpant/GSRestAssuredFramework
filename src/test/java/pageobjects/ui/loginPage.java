package pageobjects.ui;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;



public class loginPage {
	
	WebDriver driver;
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public secureareaPage logIn(String userName, String password) {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement loginButton=driver.findElement(By.className("radius"));
		//wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		return new secureareaPage(driver);
	}
	
	public String NegativelogIn(String userName,String password) {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement loginButton=driver.findElement(By.className("radius"));
		//wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();		
		return driver.findElement(By.id("flash")).getText();
	}
	
//	@AfterClass
//	public void tierDown()
//	{
//		System.out.println("This is a tierdown function..");
//		driver.close();
//	}
}
