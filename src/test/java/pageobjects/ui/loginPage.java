package pageobjects.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	
	WebDriver driver;
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public secureareaPage logIn() {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement loginButton=driver.findElement(By.className("radius"));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		return new secureareaPage(driver);
	}
	
	public String NegativelogIn() {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement loginButton=driver.findElement(By.className("radius"));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();		
		return driver.findElement(By.id("flash")).getText();
	}
}
