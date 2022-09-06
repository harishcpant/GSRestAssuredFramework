package misc;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class ThenExample {
	public static void main(String[] args) {
	      RestAssured.baseURI =
	      "http://dummy.restapiexample.com";
	      given().when().get("/api/v1/employee/1").then().log().all().assertThat().statusCode(200);
	      //given().when().get("http://www.google.com").then().statusCode(200);
	}
}
