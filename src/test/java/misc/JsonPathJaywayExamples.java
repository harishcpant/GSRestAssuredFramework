package misc;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;

public class JsonPathJaywayExamples {
	public static void main(String[] args) {
	    RestAssured.baseURI="https://reqres.in/api";
        RequestSpecification httpRequest=RestAssured.given(); 
        Response response=httpRequest.request(Method.GET,"/unknown");
        String responseBody= response.getBody().asString();
        response.prettyPrint();
        DocumentContext docCtx = JsonPath.parse(responseBody);
        JsonPath jsonPath1 = JsonPath.compile("$.data");
	    JSONArray val1=docCtx.read(jsonPath1);
	    System.out.println(val1);
	    
	    JsonPath jsonPath2 = JsonPath.compile("$.data[?(@.year>2001)]");
	    JSONArray val2=docCtx.read(jsonPath2);
	    System.out.println(val2);	    
	}
}
