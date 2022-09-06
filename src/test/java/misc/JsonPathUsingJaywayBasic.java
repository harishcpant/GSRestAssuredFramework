package misc;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JsonPathUsingJaywayBasic {
	public static void main(String[] args) {
		String jsonString = "{ \"list\": [ { \"name\": \"foo1\"}, { \"name\": \"foo2\"} ]}";
	    DocumentContext docCtx = JsonPath.parse(jsonString);
	    JsonPath jsonPath = JsonPath.compile("$.list[?(@.name == \"foo1\")]");
	    JSONArray val1=docCtx.read(jsonPath);
	    System.out.println(val1);
	}
}
