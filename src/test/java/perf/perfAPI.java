package perf;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class perfAPI {
	
//	@Test
//	public void perfUITest() {
//		System.out.println("..perfUITest..");
//		System.setProperty("webdriver.chrome.driver", "C:\\WorkingFolder\\GS\\Code\\POC\\Workspace\\GSRestAssuredFramework\\src\\test\\resources\\Drivers\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		System.out.println("..driver initiated..");
//		driver.get("https://thinktribe.com");
//		driver.close();
//	}
	
	@Test
	public void jsonTest() {
		JSONParser parser = new JSONParser();
		try {
			System.out.println("hello how are you..");
			Object obj = parser.parse(new FileReader("src/test/resources/TestData/QA/placeValidationPostAPI.json"));
			
			System.out.println("hello how are you 2.."+obj);
 
			// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
			JSONObject jsonObject = (JSONObject) obj;
			String name = (String)jsonObject.get("accuracy");
			System.out.println(name.toString());
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
