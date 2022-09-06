//package stepDefinitions.api;
//
//import static io.restassured.RestAssured.given;
//import static org.testng.Assert.assertEquals;
//
//import java.util.Properties;
//import core.api.*;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//
//public class apiStepDef_old  {
//	RequestSpecification requestBasic;
//	RequestSpecification request;
//	Response apiResponse;
//	JsonPath jsonPath;
//	String placeId;
//	
//	Properties p=GetProperties.getConfig();
//	
//	@Given("Add a place payload")
//	public void add_a_place_payload() {
//		String postPayload=GetAPITestData.getAPITestData("placeValidationPostAPI");
//		System.out.println("Post Payload-->"+postPayload);
//		requestBasic=(RequestSpecification) new RequestSpecBuilder().setBaseUri(p.getProperty("placeValidationBaseURL"))
//				.addQueryParam("key","qaclick123")
//				.setContentType(ContentType.JSON)
//				.build();
//		request=given().spec(requestBasic).body(postPayload);
//	}
//
//	@When("user calls AddPlaceAPI with post http request")
//	public void user_calls_AddPlaceAPI_with_post_http_request() {
//		apiResponse=request.when().post(p.getProperty("placeValidationInfoUrlPost")).then().extract().response();
//	}
//
//	@Then("Status in response body is OK")
//	public void status_in_response_body_is_OK() {
//		jsonPath=new JsonPath(apiResponse.asString());
//		placeId=jsonPath.getString("place_id");		
//		System.out.println("PlaceID--->"+placeId);
//		assertEquals(jsonPath.getString("status"),"OK");	
//
//	}
//	
//	// ------------------Put API calls -------------------
//	
//		@When("user calls updatePlaceAPI with put http request")
//		public void user_calls_updatePlaceAPI_with_put_http_request() {
//			String putPayloadFromFile=GetAPITestData.getAPITestData("placeValidationPutAPI");
//			String putPayload=putPayloadFromFile.replace("aaaaaaaa", placeId);
//			System.out.println("putPayload-->"+putPayload);
//			requestBasic=(RequestSpecification) new RequestSpecBuilder().setBaseUri(p.getProperty("placeValidationBaseURL"))
//					.addQueryParam("key","qaclick123")
//					.setContentType(ContentType.JSON)
//					.build();
//		    request=given().spec(requestBasic).body(putPayload);
//			apiResponse=request.when().put(p.getProperty("placeValidationInfoUrlPut")).then().extract().response();
//			jsonPath=new JsonPath(apiResponse.asString());
//			System.out.println("Put output-->"+jsonPath.getString("msg"));			
//		}
//		
//		@Then("Status in response body is Address successfully updated")
//		public void status_in_response_body_is_Address_successfully_updated() {
//			assertEquals(jsonPath.getString("msg"),"Address successfully updated");
//		}
//		
//		// ------------------Get API calls -------------------
//		
//		@When("user calls getPlaceAPI with get http request")
//		public void user_calls_getPlaceAPI_with_get_http_request() {
//			requestBasic=(RequestSpecification) new RequestSpecBuilder().setBaseUri(p.getProperty("placeValidationBaseURL"))
//					.addQueryParam("key","qaclick123")
//					.addQueryParam("place_id",placeId)
//					.setContentType(ContentType.JSON)
//					.build();
//			request=given().spec(requestBasic);
//			apiResponse=request.when().get(p.getProperty("placeValidationInfoUrlGet")).then().extract().response();
//			jsonPath=new JsonPath(apiResponse.asString());				
//		}
//
//		@Then("Status in get response body should be correct")
//		public void status_in_get_response_body_should_be_correct() {
//			assertEquals(jsonPath.getString("name"),"Frontline house");
//		}
//		
//		//------------------Common--------------------------
//		
//		@Then("API call got success with status code {int}")
//		public void api_call_got_success_with_status_code(Integer int1) {
//			assertEquals(apiResponse.getStatusCode(),200);
//		}
//
//
//}
