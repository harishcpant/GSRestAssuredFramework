package stepDefinitions.api;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import core.api.GetAPIConf;
import core.common.GetLogger;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiCommon extends GetLogger {
	static RequestSpecification reqSpec;
	Properties p=GetAPIConf.getAPIConfig();
	
	
	Response apiResponse;
	
	public RequestSpecification requestSpecification(String apiName) throws FileNotFoundException,SecurityException
	{
		if (reqSpec==null)
		{
			PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
			reqSpec=(RequestSpecification) new RequestSpecBuilder().setBaseUri(p.getProperty(apiName))
			.addQueryParam("key","qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON)
			.build();
		}
		GetLogger.logger.info("Request Specification generated for : "+apiName);
		return reqSpec;
	}
	
	public String getJasonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath jp=new JsonPath(resp);
		return jp.get(key).toString();
		
	}

	public Response callAPI(RequestSpecification request,String infoUrl, String httpMethod)
	{
		if (httpMethod.equalsIgnoreCase("POST"))
		{			
			apiResponse=request.when().post(p.getProperty(infoUrl));
		}
		else if (httpMethod.equalsIgnoreCase("GET"))
		{
			apiResponse=request.when().get(p.getProperty(infoUrl));
		}
		if (httpMethod.equalsIgnoreCase("PUT"))
		{
			apiResponse=request.when().put(p.getProperty(infoUrl));
		}	
		
		GetLogger.logger.info("httpMethod is: "+ httpMethod+ " and infoUrl is: "+ p.getProperty(infoUrl));
		GetLogger.logger.info(infoUrl +" API Call Response : "+ apiResponse.asString());
		
		return apiResponse;
	}
	
	public void assertEqualsCustom(String expected,String actual)
	{
		assertEquals(expected,actual,"Expected is: "+expected+", But Actual is: "+actual+"  /");		
	}
	
}
