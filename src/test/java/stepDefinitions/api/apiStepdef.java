package stepDefinitions.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import core.api.*;
import core.common.GetLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.api.AddPlace;
import pojo.api.AddPlace_location;
import pojo.api.UpdatePlace;


public class apiStepdef extends apiCommon  
{
		RequestSpecification request;
		Response apiResponse;
		String placeId;
	
		//------------------Post API Calls -------------------
		@Given("Add a place payload with {string} {string} and {string}")
		public void add_a_place_payload_with_and(String name, String language, String address) throws FileNotFoundException, SecurityException {
			AddPlace postPayload=new AddPlace();
			AddPlace_location l=new AddPlace_location();
				l.setLat(-38.383494);
				l.setLng(33.427362);
			postPayload.setLocation(l);
			postPayload.setAccuracy(50);
			postPayload.setName(name);
			postPayload.setPhone_number("(+91) 983 893 3937");
			postPayload.setAddress(address);
			List<String> myList=new ArrayList<String>();
				myList.add("shoe park");
				myList.add("shop");
			postPayload.setTypes(myList);
			postPayload.setWebsite("http://google.com");
			postPayload.setLanguage(language);
			
			request=given()
					.spec(requestSpecification("PlaceAPIBaseURL"))
					.body(postPayload);
		}	
	
		// ------------------Get API calls -------------------
		
		@When("Verify the {string} when user calls the {string}")
		public void verify_the_when_user_calls_the(String value, String infoUrl) throws FileNotFoundException, SecurityException  {
			request=given().spec(requestSpecification("PlaceAPIBaseURL"))
					.queryParam("place_id", placeId);
			user_calls_with_http_request(infoUrl,"GET");
			assertEqualsCustom(value,getJasonPath(apiResponse,"name"));
		}
		
		// ------------------Put API calls -------------------
		
		@When("Update a place payload with {string}")
		public void update_a_place_payload_with(String updatedAddress) throws FileNotFoundException, SecurityException {
			UpdatePlace putPayload=new UpdatePlace();
			putPayload.setPlace_id(placeId);
			putPayload.setAddress(updatedAddress);
			putPayload.setKey("qaclick123");
			request=given()
					.spec(requestSpecification("PlaceAPIBaseURL"))
					.body(putPayload);
		}
		
		//------------------Common--------------------------
		
		@When("User calls {string} with {string} http request")
		public void user_calls_with_http_request(String infoUrl, String httpMethod) {
			apiResponse=callAPI(request,infoUrl,httpMethod);
		}
		
	
		@Then("{string} in response body is {string}")		
		public void in_response_body_is(String key, String value) {
			apiResponse=apiResponse.then().extract().response();
			placeId=getJasonPath(apiResponse,"place_id");
			GetLogger.logger.info("placeId is : "+ placeId);
			assertEqualsCustom(value,getJasonPath(apiResponse,key));		
		}
		
		@Then("API call got success with status code {int}")
		public void api_call_got_success_with_status_code(Integer statusCode) {
			assertEquals(apiResponse.getStatusCode(),200);
			//assertEqualsCustom(statusCode,apiResponse.getStatusCode());	
		}
		


}
