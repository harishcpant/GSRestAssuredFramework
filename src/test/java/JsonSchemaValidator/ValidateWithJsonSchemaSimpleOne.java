package JsonSchemaValidator;


import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ValidateWithJsonSchemaSimpleOne {
    public static void main(String[] args) {
        System.out.println("Hello ValidateWithJsonSchema...");
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/2";

        //obtain response
        given().when().get().then().assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("C:\\Harish\\Study\\Github\\GSRestAssuredFramework\\src\\test\\java\\JsonSchemaValidator\\simpleSchema.json")));
        System.out.println("Json is looking good as compared to schema.");
    }
}
