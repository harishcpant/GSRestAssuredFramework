package core.api;

import java.io.FileReader;
import java.util.Properties;
import org.json.simple.parser.JSONParser;
import core.common.GetEnvDetails;



public class GetAPITestData {
	static Properties p=GetEnvDetails.getEnvDetails();
	public static String getAPITestData(String apiFileName)
	{
		JSONParser parser = new JSONParser();
		Object obj;
		String postPayload=null;
		String env=p.getProperty("environment");
		//String apiFileName="placeValidationPostAPI";
		try {
			obj= parser.parse(new FileReader("src/test/resources/TestData/"+env+"/"+apiFileName+".json"));
			postPayload=obj.toString();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postPayload;
	}

}
