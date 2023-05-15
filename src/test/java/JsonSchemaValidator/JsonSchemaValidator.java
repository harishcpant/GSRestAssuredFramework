package JsonSchemaValidator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;

public class JsonSchemaValidator {

	public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);

        try (
                InputStream jsonStream = inputStreamFromClasspath("example.json");
                InputStream schemaStream = inputStreamFromClasspath("example-schema.json")
        ) {
            JsonNode json = objectMapper.readTree(jsonStream);
            JsonSchema schema = schemaFactory.getSchema(schemaStream);
            Set<ValidationMessage> validationResult = schema.validate(json);

            if (validationResult.isEmpty()) {
                System.out.println("no validation errors :-)");
            } else {
            	System.out.println("validation errors :-)");
            	Iterator<ValidationMessage> namesIterator = validationResult.iterator();
            	while(namesIterator.hasNext()) {
            		   System.out.println(namesIterator.next().getMessage());
            		}
            }
        }
	}
	
    private static InputStream inputStreamFromClasspath(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }
}
