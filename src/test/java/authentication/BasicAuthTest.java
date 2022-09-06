package authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BasicAuthTest {

	public static void main(String[] args) {
	
	       RequestSpecification httpRequest = RestAssured.given().auth().basic("postman", "password");
	       Response res = httpRequest.get("https://postman-echo.com/basic-auth");
	       ResponseBody body = res.body();
	       String rbdy = body.asString();
	       System.out.println("Data from the GET API- "+rbdy);

	}

}
