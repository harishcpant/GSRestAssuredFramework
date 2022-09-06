package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonPathRestAssured {

	public static void main(String[] args) {		
		RestAssured.baseURI="https://reqres.in/api";
        RequestSpecification httpRequest=RestAssured.given(); 
        Response response=httpRequest.request(Method.GET,"/unknown");
        String responseBody= response.getBody().asString();
        response.prettyPrint();
        JsonPath jsonpath= response.jsonPath();
        System.out.println(jsonpath.getInt("data[0].id"));

        HashMap aa=jsonpath.get("data[0]");
        Iterator it = aa.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }

	}
}
