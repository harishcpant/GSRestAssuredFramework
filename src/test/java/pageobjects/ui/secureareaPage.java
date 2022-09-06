package pageobjects.ui;

import org.openqa.selenium.WebDriver;

public class secureareaPage {
	WebDriver driver;

	public secureareaPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

}
