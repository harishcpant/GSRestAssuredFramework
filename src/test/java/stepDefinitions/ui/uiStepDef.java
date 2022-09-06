package stepDefinitions.ui;

import org.testng.Assert;
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

	}

	@When("I enter the valid (.*) and (.*)")
	public void i_enter_the_username_password(String userName,String password) {
		securedareapage=loginpage.logIn(userName,password);
	}

	@Then("I should land successfully to secure area page")
	public void i_should_be_land_to_respective_page() {
		System.out.println("I should land successfully to secure area page");
		String expectedUrl="http://the-internet.herokuapp.com/secure";
		String actualUrl=securedareapage.getPageUrl();
		Assert.assertEquals(actualUrl,expectedUrl);
	}
	
	
	@When("I enter the invalid (.*) and (.*)")
	public void i_enter_the_invalid_username_and_password(String userName,String password) {
		actualErrorMessage=loginpage.NegativelogIn(userName,password);
		System.out.println("errorMessage-->"+actualErrorMessage);
	}

	@Then("I should get the an error")
	public void i_should_get_the_an_error() {
		Assert.assertTrue(actualErrorMessage.contains("invalid"), "Login Credentials are not valid");
	}
}
