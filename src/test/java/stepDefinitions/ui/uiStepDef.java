package stepDefinitions.ui;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import core.ui.webdriverCore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ui.loginPage;
import pageobjects.ui.secureareaPage;
import pageobjects.ui.welcomePage;

public class uiStepDef {
	
	welcomePage welcomepage;
	loginPage loginpage;
	secureareaPage securedareapage;
	String actualErrorMessage;
	
	@Given("I Open the login page")
	public void open_the_login_page() 
	{
		welcomepage=new welcomePage();
		welcomepage.openPage();
		loginpage=welcomepage.clickFormAuthenticationLink();		
		
//		driver.findElement(By.linkText("Form Authentication")).click();
//		driver.findElement(By.id("username")).sendKeys("tomsmith");
//		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		WebElement loginButton=driver.findElement(By.className("radius"));
//		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//		loginButton.click();
//		
//		String expectedUrl="http://the-internet.herokuapp.com/secure";
//		System.out.println("Current URL -->"+driver.getCurrentUrl());
//		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
//		
//		driver.quit();
		
	}

	@When("I enter the valid username and password")
	public void i_enter_the_username_password() {
		securedareapage=loginpage.logIn();
	}

	@Then("I should land successfully to secure area page")
	public void i_should_be_land_to_respective_page() {
		System.out.println("I should land successfully to secure area page");
		String expectedUrl="http://the-internet.herokuapp.com/secure";
		String actualUrl=securedareapage.getPageUrl();
		Assert.assertEquals(actualUrl,expectedUrl);
	}
	
	
	@When("I enter the invalid username and password")
	public void i_enter_the_invalid_username_and_password() {
		actualErrorMessage=loginpage.NegativelogIn();
		System.out.println("errorMessage-->"+actualErrorMessage);
	}

	@Then("I should get the an error")
	public void i_should_get_the_an_error() {
		Assert.assertTrue(actualErrorMessage.contains("invalid"), "Login Credentials are not valid");
	}
}
